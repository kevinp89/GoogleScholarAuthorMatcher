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
package tests;


import HtmlConverter.HTMLextract;
import java.io.IOException;

/**
 * Class for MOCK google scholar html link testing. A mock class
 */
public class MOCKGoogleScholarHtmlExtract implements HTMLextract {
    //tracker for url
    private String url;
    //default constructor
    public MOCKGoogleScholarHtmlExtract(){}
    //constructor with a file/url name.
    public MOCKGoogleScholarHtmlExtract(String filename){
        this.url = filename;
    }

    /**
     * Return the string version of html.
     * @return - the string version of html.
     * @throws Exception
     */
    @Override public String extract() throws Exception {
        if(url.equals("sample1.html")){
            return "<html><head><title>Kevin Patel Google Scholar "
                + "citations<title></head><body><span id=\"cit-name-display\" "
                + "class=\"cit-in-place-nohover\">KEVIN</span>\""
                + "<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">3</a>"
                +"<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">2</a>"
                + "<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">3</a>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">alpha</a>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">beta</a>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">charlie</a>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">400</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">80</td>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">Learn how to java</a>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">learn java</a>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">java learn</a>"
                + "</body"
                + "></html>";
        }
        else if(url.equals("sample2.html")){
            return "<html><head><title>Patel Google Scholar "
                + "citations<title></head><body><span id=\"cit-name-display\" "
                + "class=\"cit-in-place-nohover\">this name is "
                + "long but cool</span>"
                + "<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">10</a>"
                + "<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">10</a>"
                + "<a "
                + "class=\"cit-dark-link\" href=\"http://scholar.google"
                + ".ca/scholar?oi=bibs&hl=en&cites=(.*?)\">10</a>"
                + "<td>I-Index</td><tr>90</tr>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">mega</a>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">Omega</a>"
                + "<a "
                + "class=\"cit-dark-link\" "
                + "href=\"http://scholar.google.ca/citations?user=(.*?)"
                + "\" title=\"(.*?)\">theata</a>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">800</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">10</td>"
                + "<td "
                + "class=\"cit-borderleft cit-data\">90</td>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">Learn how to php</a>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">learn php</a>"
                + "<a href=\"http://scholar.google"
                + ".ca/citations?view_op=view_citation&hl=en&user=(.*?)\" "
                + "class=\"cit-dark-large-link\">php learn</a>"
                + "</body"
                + "></html>";
        }
        else if(url.equals("sample3.html")){
            return "just a random thing";
        }
        else{
            throw new IOException(url + " Not found");
        }
    }

}

