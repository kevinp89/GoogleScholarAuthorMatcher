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

import ContentExtract.CoAuthorsNamesExtract;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * tests for Co-authors name extraction
 */
public class CoAuthorsNamesExtractTest {
    MOCKGoogleScholarHtmlExtract extract;

    @After public void tearDown() throws Exception {
        extract = null;
    }

    @Test
    public void testExtract1()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        String expected = "alpha\nbeta\ncharlie";
        String actual = CoAuthorsNamesExtract.extract(extract.extract());
        assertEquals(expected, actual);
    }

    @Test
    //output will be combined from the previous test.
    public void testExtract2()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        String expected = "Omega\n" + "alpha\n" + "beta\n" + "charlie\n"
            + "mega\n" + "theata";
        String actual = CoAuthorsNamesExtract.extract(extract.extract());
        assertEquals(expected, actual);
    }
}
