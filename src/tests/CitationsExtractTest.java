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

import ContentExtract.CitationsExtract;
import Exceptions.MatchNotFoundException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CitationsExtractTest {
    MOCKGoogleScholarHtmlExtract extract;

    @After public void tearDown() throws Exception {
        extract = null;
    }

    @Test
    public void testExtract1()throws Exception{
        String expected = "8";
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String actual = CitationsExtract.extract(extract.extract(), 3);
        assertEquals(expected, actual);
    }

    @Test
    public void testExtract2()throws Exception{
        String expected = "30";
        extract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        String actual = CitationsExtract.extract(extract.extract(), 3);
        assertEquals(expected, actual);

    }

    @Test(expected = MatchNotFoundException.class)
    public void testExtractErr()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String actual = CitationsExtract.extract(extract.extract(), 0);
    }

}
