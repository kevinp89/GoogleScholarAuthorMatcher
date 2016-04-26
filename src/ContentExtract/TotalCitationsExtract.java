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
 * Extract total number of citations.
 */
public class TotalCitationsExtract extends Extract {
    //reg ex pattern tracker for total citations extraction
    private static final Pattern numCitationsRegEx = Pattern.compile("<td "
        + "class=\"cit-borderleft cit-data\">([\\d]+?)</td>");
    //default constructor for testing
    public TotalCitationsExtract(){}

    /**
     * Extract the number of citations listed in the html page.
     * @param htmlContent - the string version of html
     * @return - the string of number of citations.
     * @throws MatchNotFoundException
     */
    public static String extract(String htmlContent) throws
        MatchNotFoundException{
        //match
        Matcher m = numCitationsRegEx.matcher(htmlContent);
        if(m.find()){
            return m.group(1);
        }else{
            throw new MatchNotFoundException("No Citations Found\n");
        }
    }

}
