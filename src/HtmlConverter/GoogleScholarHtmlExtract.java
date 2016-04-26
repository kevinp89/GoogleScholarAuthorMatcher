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
package HtmlConverter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Html to string of html content class..
 */
public class GoogleScholarHtmlExtract implements HTMLextract{
    //Storage of htmlUrl
    private String htmlUrl;
    //Storage of html
    private String html;
    //Default constructor
    public GoogleScholarHtmlExtract(){}

    //constructor with htmlUrl.
    public GoogleScholarHtmlExtract(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }

    @Override
    /**
     * Extract the html content from the html url and store in html.
     * @throws Exception
     */
    public String extract() throws Exception{
        // create object to store html source text as it is being collected
        StringBuilder html = new StringBuilder();
        // open connection to given url
        URL url = new File(this.htmlUrl).toURI().toURL();
        // create BufferedReader to buffer the given url's HTML source
        BufferedReader htmlbr =
            new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        // read each line of HTML code and store in StringBuilder
        while ((line = htmlbr.readLine()) != null) {
            html.append(line);
        }
        htmlbr.close();
        // convert StringBuilder into a String and return it
        this.html = html.toString();
        return html.toString();
    }

    /**
     * Return the html content stored in class.
     * @return - the html content stored in class.
     */
    public String getHtml(){
        return this.html;
    }

}
