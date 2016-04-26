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

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

/**
 * TESTS FOR HTML EXTRACTION.
 */
public class GoogleScholarHtmlExtractTest {


    private MOCKGoogleScholarHtmlExtract extract;

    @org.junit.Before public void setUp() throws Exception {
    }

    @org.junit.After public void tearDown() throws Exception {
        extract = null;
    }

    @Test
    public void testextract1() throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String actual = extract.extract();
        String expected = "<html><head><title>Kevin Patel Google Scholar "
            + "citations<title></head><body><td>Citations</td><tr>900</tr>"
            + "</body"
            + "></html>";
        assertEquals(expected, actual);
    }

    @Test
    public void testExtract2()throws Exception{
        String expected = "<html><head><title>Patel Google Scholar "
            + "citations<title></head><body><td>I-Index</td><tr>90</tr>"
            + "</body"
            + "></html>";
        extract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        assertEquals(expected, extract.extract());
    }

    @Test(expected = IOException.class)
    public void testExtractErr()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample091283.html");
        extract.extract();
    }
}
