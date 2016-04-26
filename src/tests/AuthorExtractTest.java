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

import ContentExtract.AuthorExtract;
import Exceptions.MatchNotFoundException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AuthorExtractTest {
    private MOCKGoogleScholarHtmlExtract htmlExtract;

    @After public void tearDown() throws Exception {
         htmlExtract = null;
    }

    @Test
    public void testExtract1()throws Exception{
        String expected = "KEVIN";
        htmlExtract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String actual = AuthorExtract.extract(htmlExtract.extract());
        assertEquals(expected, actual);
    }

    @Test
    public void testExtract2()throws Exception{
        String expexted = "this name is long but cool";
        htmlExtract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        String actual = AuthorExtract.extract(htmlExtract.extract());
        assertEquals(expexted, actual);
    }

    @Test (expected = MatchNotFoundException.class)
    public void testExtractErr()throws Exception{
        String actual = AuthorExtract.extract("NO NAME");
    }
}
