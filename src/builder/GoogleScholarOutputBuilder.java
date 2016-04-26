//**********************************************************
//Assignment3:
//CDF user_name: c4patelk
//
//Author: Kevin Patel
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package builder;

import ContentExtract.*;
import Exceptions.MatchNotFoundException;
import format.Formatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Build the output for the parser.
 */
public class GoogleScholarOutputBuilder implements OutputBuilder{
    //tracker for the number bullets.
    private int i = 1;
    //tracker for the htmlContent
    private String htmlContent;
    //tracker for the output, initially empty static so that only one output
    // is created.
    private String output = "";
    //tracker for output, each output is listed and stored in outputSet.
    private static List<String> outputSet = new ArrayList<String>();
    //tracker for build object.
    private Build build;

    //private constructor for building output.
    private GoogleScholarOutputBuilder(Build builder){
        this.build = builder;
        buildOutput();
    }

    /**
     * Build the output with GoogleScholar build specifications.
     */
    private void buildOutput(){
        // build output using i as a bullet point. If no data is present in
        // build.instanceVar then append empty string.
        output = "---------------------------------------------------\n";
        output += (build.authorBuild != null) ? Integer.toString(i) + ". " +
            build.authorBuild : "";
        i++;
        output += (build.totalCitationsBuild != null) ? Integer.toString(i) +
            ". "
            + "" + build.totalCitationsBuild : "";
        i++;
        output += (build.iIndexBuild != null) ? Integer.toString(i) + ". "
            + build.iIndexBuild : "";
        i++;
        output += (build.publications != null) ? Integer.toString(i) + ". "
            + build.publications : "";
        i++;
        output += (build.nCitations != null) ? Integer.toString(i) + ". " +
            build.nCitations : "";
        i++;
        output += (build.numberOfCoAuthors != null) ? Integer.toString(i) + ""
            + ". " + build
            .numberOfCoAuthors : "";
        i++;
        //add the output in the outputSet.
        outputSet.add(output.substring(0, output.length()-1));
        //set output to empty for later use.
        output = "";
    }

    /**
     * Get the built output.
     * @return - output.
     */
    @Override public String getOutputForContent() {
        //combine each output into a single output..
        for(String outputString : outputSet){
            output += outputString + "\n";

        }
        //append in the co-authors.
        output +=
            "---------------------------------------------------\n";
        output += (this.build.namesOfCoAuthors != null) ? Integer.toString(i)
            +  ". " + this
            .build.namesOfCoAuthors : "";
        return output;
    }


    // ++++++++++++++++++++++++++++++ BUILD CLASS ++++++++++++++++++++++++++++


    /**
     * output builder class.
     */
    public static class Build{
        //html content tracker
        private String htmlContent;
        // author name tracker
        private String authorBuild;
        //total citations tracker
        private String totalCitationsBuild;
        // i-Index tracker
        private String iIndexBuild;
        // first n  publications tracker
        private String publications;
        // first n citations tracker
        private String nCitations;
        // number of co Authors tracker
        private String numberOfCoAuthors;
        // names of co authors tracker
        private String namesOfCoAuthors;
        // total content size tracker.
        private int contentSize = 0;

        //build construct wih String version of html content.
        public Build(String htmlContent){
            this.htmlContent = htmlContent;
        }

        //each build returns this class, and each build calls format to
        // format the output.

        /**
         * Get author and format author name
         * @return - this class.
         */
        public Build author(){
            try{
                String author = AuthorExtract.extract(htmlContent);
                this.authorBuild = Formatter.authorFormat(author);
                contentSize ++;
                return this;
            }
            catch (MatchNotFoundException e){
                this.authorBuild = e.getMessage();
                contentSize ++;
                return this;
            }

        }

        /**
         * Get the number of citations listed for the author in the html page.
         * @return - this class.
         */
        public Build totalCitations(){
            try{
                String totalCitations = TotalCitationsExtract.extract
                    (htmlContent);
                this.totalCitationsBuild = Formatter.numberOfCitations
                    (totalCitations);
                contentSize ++;
                return this;
            }
            catch (MatchNotFoundException e){
                this.totalCitationsBuild = e.getMessage();
                contentSize ++;
                return this;
            }
        }

        /**
         * Get the i-Index after 2009
         * @return - this class
         */
        public Build iIndex(){
            try{
                String iIndex = IndexExtract.extract(htmlContent);
                this.iIndexBuild = Formatter.iIndex(iIndex);
                contentSize ++;
                return this;
            }catch (MatchNotFoundException e){
                this.iIndexBuild = e.getMessage();
                contentSize ++;
                return this;
            }
        }

        /**
         * Extract the first n number of publications.
         * @param n - number of publications needed to extract.
         * @return - this class.
         */
        public Build publications(int n){
            try{
                String publications = PublicationsExtract.extract
                    (htmlContent, n);
                this.publications = Formatter.publicationsFormat(publications);
                contentSize ++;
                return this;
            }
            catch (MatchNotFoundException e){
                this.publications = e.getMessage();
                contentSize ++;
                return this;
            }
        }

        /**
         * Extract first n number of citations.
         * @param n - number of citations.
         * @return - this class.
         */
        public Build firstnCitations(int n){
            try{
                String nCitations = CitationsExtract.extract
                    (htmlContent, n);
                this.nCitations = Formatter.firstnCitations(nCitations, n);
                contentSize ++;
                return this;
            }
            catch (MatchNotFoundException e){
                this.nCitations = e.getMessage();
                contentSize ++;
                return this;
            }
        }

        /**
         * Extract number of co Authors in the html Content.
         * @return - this class.
         */
        public Build numberOfCoAuthors(){
            try{
                String numCoAuthors = TotalCoAuthorsExtract.extract
                    (htmlContent);
                this.numberOfCoAuthors = Formatter.numCoAuthorsFormat
                    (numCoAuthors);
                this.contentSize++;
                return this;

            }catch (MatchNotFoundException e){
                this.numberOfCoAuthors = e.getMessage();
                this.contentSize++;
                return this;
            }
        }

        /**
         * Extract names of co Authors in the html Content.
         * @return - this class.
         */
        public Build namesOfCoAuthors(){
            try{
                String namesCoAuthors = CoAuthorsNamesExtract.extract
                    (htmlContent);
                this.namesOfCoAuthors = Formatter.CoAuthorsFormat
                    (namesCoAuthors, CoAuthorsNamesExtract.totalCoAuthors());
                this.contentSize++;
                return this;

            }catch (MatchNotFoundException e){
                this.namesOfCoAuthors = e.getMessage();
                this.contentSize++;
                return this;
            }
        }

        /**
         * Get the content size.
         * @return - the content size.
         */
        public int getContentSize(){
            return this.contentSize;}

        /**
         * Return a new object of GoogleScholarOutputBuilder, such that
         * output can be built using this class.
         * @return - a new object of GoogleScholarOutputBuilder
         */
        public GoogleScholarOutputBuilder build(){
            return new GoogleScholarOutputBuilder(this);
        }
    }
}
