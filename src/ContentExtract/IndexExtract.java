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
 * Extract the i-Index.
 */
public class IndexExtract extends Extract{
    //reg ex tracker for i-index extraction.
    private static final Pattern indexRegEx = Pattern.compile("<td "
        + "class=\"cit-borderleft cit-data\">([\\d]+?)</td>");

    public static String extract(String htmlContent) throws
        MatchNotFoundException{
        //match
        Matcher m = indexRegEx.matcher(htmlContent);
        //build up string
        String output = "";
        int i =1;
        //skip all the table entries for citations and h-index.
        while (i != 7 && m.find()){
            output = m.group(1);
            i++;
        }
        if(output.equals("")){
            throw new MatchNotFoundException("No i-Index since 2009 "
                + "found\n");
        }
        else{
            return output;
        }


    }
}
