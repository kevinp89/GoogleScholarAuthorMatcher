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

public class AuthorExtract extends Extract {
    //html content holder
    private String htmlContent;
    //author name holder
    private String authorName;
    // regEx pattern for extraction.
    //match only words, since names have only letters no numbers, thus ignore
    // numbers, also html code may have spaces before, after or in the middle
    private static final Pattern regExAuthor=Pattern.compile("<span "
        + "id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">([\\s\\w'.-]+?)</span>");

    //default constructor
    public AuthorExtract(){}
    //constructor with html string content.
    public AuthorExtract(String html){
        this.htmlContent = html;
    }

    /**
     * Extract the author name from the html string content and return the name.
     * @throws MatchNotFoundException
     */
    public static String extract(String html)throws
        MatchNotFoundException{
        //match the reg ex with html string.
        Matcher m = regExAuthor.matcher(html);

        if (m.find()){
            return m.group(1);
        }
        else{
            throw new MatchNotFoundException("No Author name Found\n");
        }
    }

    //instance methods:
    // can be used when needed.

    /**
     * Get the author name.
     * @return - the author name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Set the author name.
     * @param authorName - name of author.
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
