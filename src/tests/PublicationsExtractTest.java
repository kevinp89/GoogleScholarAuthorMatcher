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

import ContentExtract.PublicationsExtract;
import Exceptions.MatchNotFoundException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for publication.
 */
public class PublicationsExtractTest {
    MOCKGoogleScholarHtmlExtract extract;
    @After public void tearDown() throws Exception {
        extract = null;
    }

    @Test
    public void testExtract1() throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String expexted = "    1- Learn how to java\n    2- learn java\n    "
            + "3- java learn";
        String actual = PublicationsExtract.extract(extract.extract(), 3);
        assertEquals(expexted, actual);
    }

    @Test
    public void testExtract2() throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        String expexted = "    1- Learn how to php\n    2- learn php\n    "
            + "3- php learn";
        String actual = PublicationsExtract.extract(extract.extract(), 3);
        assertEquals(expexted, actual);
    }

    @Test (expected = MatchNotFoundException.class)
    public void testExtractNotEnough()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String expected = "    1- Learn how to java\n    2- learn java\n    "
            + "3- java learn" + "only first 3 publications found";
        String actual = PublicationsExtract.extract(extract.extract(), 10);
        assertEquals(expected, actual);
    }

    @Test(expected = MatchNotFoundException.class)
    public void testExtractErr()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample3.html");
        String actual = PublicationsExtract.extract(extract.extract(), 3);
    }

}
