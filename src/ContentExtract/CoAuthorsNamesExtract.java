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
package ContentExtract;

import Exceptions.MatchNotFoundException;

import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract co-authors.
 */
public class CoAuthorsNamesExtract extends Extract {
    // reg ex tracker for co Authors names extract.
    private static final Pattern coAuthorsExtractregEx = Pattern.compile("<a "
        + "class=\"cit-dark-link\" "
        + "href=\"http://scholar\\.google\\.ca/citations\\?user=(.*?)"
        + "\" title=\"(.*?)\">([\\sa-zA-Z.'-]+?)</a>");

    //tracker for names set of names, sorted and non repeated.
    private static TreeSet<String> coAuthors = new TreeSet<String>();
    //default constructor.
    public CoAuthorsNamesExtract(){}

    /**
     * Return the names of co-Authors listed in html content, line by line.
     * @param htmlContent - String version of html
     * @return - the names of co-authors listed in html
     * @throws MatchNotFoundException
     */
    public static String extract(String htmlContent) throws
        MatchNotFoundException{
        //match
        Matcher m = coAuthorsExtractregEx.matcher(htmlContent);

        //tree set such that no duplicated allowed and sorted in order.
        while(m.find()){
            coAuthors.add(m.group(3));
        }
        if (!coAuthors.isEmpty()) {
            //convert treeSet to string
            String coAuthorsString = setToString(coAuthors);
            return coAuthorsString.substring(0, coAuthorsString.length()-1);
        }
        else{
            throw new MatchNotFoundException("No Co-Authors found\n");
        }
    }

    /**
     * return the total number of coAuthors.
     * @return - the total number of coAuthors.
     */
    public static int totalCoAuthors(){
        return coAuthors.size();
    }

    /**
     * Given set of co-authors, return a string version of each co-author
     * listed in the set, separated by newline.
     * @param coAuthorsMap - set of co-authors.
     * @return - a string version of each co-author
     * listed in the set, separated by newline
     */
    private static String setToString(TreeSet<String> coAuthorsMap){
        //build up coAuthors string.
        String coAuthors = "";
        for(String author: coAuthorsMap){
            coAuthors += author + "\n";
        }
        return coAuthors.substring(0, coAuthors.length());

    }

}
