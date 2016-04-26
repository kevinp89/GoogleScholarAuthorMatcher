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
package format;

/**
 * Formatter class for formatting the String.
 */
public class Formatter {

    /**
     * Return the string format for author.
     * @param name - name of author.
     * @return - the string format for author.
     */
    public static String authorFormat(String name){
        return "Name of Author:\n" + "    " + name + "\n";
    }

    /**
     * Return the string format for number of citations.
     * @param numCitations - String version of number of citations.
     * @return - the string format for number of citations.
     */
    public static String numberOfCitations(String numCitations){
        return "Number of all citations:\n" + "    " + numCitations + "\n";
    }

    /**
     * Return the string format for number of citations.
     * @param numCitations - String version of number of citations.
     * @return - the string format for number of citations.
     */
    public static String firstnCitations(String numCitations, int n){
        return "Total paper citations (first " + Integer.toString(n) +  " "
            + "papers):\n" + "    " + numCitations + "\n";
    }

    /**
     * Return the string format for i-index.
     * @param index - String of i-index number.
     * @return - the string format for i-index.
     */
    public static String iIndex(String index){
        return "Number of i10-index after 2009:\n" +  "    " + index + "\n";
    }

    /**
     * Return the formatted version of publications.
     * @param publications - titles of publications
     * @return - the formatted version of publications.
     */
    public static String publicationsFormat(String publications){
        return "Title of the first 3 publications: \n" +
                publications + "\n";
    }

    /**
     * Return the formatted version of number of co-authors.
     * @param numCoAuthors - String of number of co-authors.
     * @return - the formatted version of number of co-authors.
     */
    public static String numCoAuthorsFormat(String numCoAuthors){
        return "Total Co-Authors:\n" + "    " + numCoAuthors + "\n";
    }

    /**
     * Return the formatted version of names of co-authors.
     * @param namesOfCoAuthors - names of Co-Authors.
     * @return - the formatted version of number of co-authors.
     */
    public static String CoAuthorsFormat(String namesOfCoAuthors, int
        totalNumber){
        return "Co-Authors list sorted(total: " + Integer.toString
            (totalNumber) + "):\n" + namesOfCoAuthors + "\n";
    }


}
