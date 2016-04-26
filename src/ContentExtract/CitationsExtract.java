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
 * Extract citations.
 */
public class CitationsExtract extends Extract{

    //reg ex for n number of citations match.
    private static final Pattern nCitationsRegEx = Pattern.compile("<a "
        + "class=\"cit-dark-link\" href=\"http://scholar\\.google"
        + "\\.ca/scholar\\?oi=bibs&hl=en&cites=(.*?)\">([\\d]+?)</a>");

    //default constructor for testing..
    public CitationsExtract(){}

    /**
     * Extract the number of citations in each article listed and return
     * total.
     * @param htmlContent - String version of html.
     * @return - the total number of citations in the first five articles
     * @throws MatchNotFoundException
     */
    public static String extract(String htmlContent, int n) throws
        MatchNotFoundException{
        //match
        Matcher m = nCitationsRegEx.matcher(htmlContent);
        //initialize a counter.
        int counter = 0;
        int output = 0;
        //build up output
        while (counter < n && m.find()){
            output += Integer.parseInt(m.group(2));
            counter++;
        }
        if(output == 0){
            throw new MatchNotFoundException("No citations listed\n");
        }
        else if(counter < n){
            throw new MatchNotFoundException(Integer.toString(output) +
                " only first " + Integer.toString(counter) + " citations "
                + "found\n");
        }
        else{
            return Integer.toString(output);
        }
    }

}
