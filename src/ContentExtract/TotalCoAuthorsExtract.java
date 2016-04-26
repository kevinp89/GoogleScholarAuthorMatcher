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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Total number of Co-Authors extract.
 */
public class TotalCoAuthorsExtract extends Extract{
    // reg ex tracker for number of co authors extraction
    private static final Pattern coAuthorsExtractregEx = Pattern.compile("<a "
        + "class=\"cit-dark-link\" "
        + "href=\"http://scholar\\.google\\.ca/citations\\?user=(.*?)"
        + "\" title=\"(.*?)\">([\\sa-zA-Z.'-]+?)</a>");

    //default constructor for testing
    public TotalCoAuthorsExtract(){
    }

    /**
     * return String number of co authors listed in the html content.
     * @param htmlContent - the string version of html content.
     * @return - string number of co authors found.
     * @throws MatchNotFoundException
     */
    public static String extract(String htmlContent) throws
        MatchNotFoundException{
        //match
        Matcher m = coAuthorsExtractregEx.matcher(htmlContent);
        int numberOfCoAuthors = 0;
        //coAuthors name tracker for debugging purposes.
        String coAuthors = "";
        while(m.find()){
            coAuthors += m.group(3);
            numberOfCoAuthors++;
        }
        if (numberOfCoAuthors !=0) {
            return Integer.toString(numberOfCoAuthors);
        }
        else{
            throw new MatchNotFoundException("0 Co-Authors found\n");
        }
    }

}
