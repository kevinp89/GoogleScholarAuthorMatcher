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
 * Extract first n number of publications.
 */
public class PublicationsExtract extends Extract {

    //reg ex pattern tracker for publications.
    //include some of href link such that reg ex does not match any other
    // href link and <a> tag on the page.
    private static final Pattern publicationRegEx = Pattern.compile(""
        + "<a href=\"http://scholar\\.google"
        + "\\.ca/citations\\?view_op=view_citation&hl=en&user=(.*?)\" "
        + "class=\"cit-dark-large-link\">(.*?)</a>");

    /**
     * Extract the first 3 titles of publications from the html content.
     * @param htmlContent - String version of html content
     * @return - the first 3 titles of publications.
     * @throws MatchNotFoundException
     */
    public static String extract(String htmlContent, int n)throws
        MatchNotFoundException{
        //match
        Matcher m = publicationRegEx.matcher(htmlContent);
        //build up string
        String output = "";
        int i = 1;
        while (i <= n && m.find()){
            output += "    " + Integer.toString(i) + "- " + m.group(2) + "\n";
            i++;
        }
        if(output.equals("")){
            throw new MatchNotFoundException("No publications found \n");
        }
        else if(i < n){
            String exceptionBuild = output + "    only first " + Integer
                .toString(i - 1) + " publications found\n";
            throw new MatchNotFoundException(exceptionBuild);
        }
        else{
            return output.substring(0, output.length()-1);
        }

    }

}
