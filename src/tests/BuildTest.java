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

import builder.GoogleScholarOutputBuilder;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Build output test.
 */
public class BuildTest {
    GoogleScholarOutputBuilder build;
    MOCKGoogleScholarHtmlExtract extract;
    @After public void tearDown() throws Exception {
        build = null;
    }

    @Test
    public void testBuild1()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample1.html");
        build = new GoogleScholarOutputBuilder.Build(extract.extract())
                    .author()
                    .totalCitations()
                    .build();
        String actual = build.getOutputForContent();
        String expected =
            "---------------------------------------------------\n1. Name of "
                + "Author:\n    KEVIN\n" + "2. Number of "
            + "all citations:\n    400\n"
            + "---------------------------------------------------\n";
        assertEquals(expected, actual);
    }

    @Test
    public void testBuild2()throws Exception{
        extract = new MOCKGoogleScholarHtmlExtract("sample2.html");
        build = new GoogleScholarOutputBuilder.Build(extract.extract())
            .author()
            .build();
        String actual = build.getOutputForContent();
        String expected =
            "---------------------------------------------------\n1. Name of "
                + "Author:\n    KEVIN\n" + "2. Number of "
                + "all citations:\n    400\n"
                + "---------------------------------------------------\n" +
                "1. Name of Author:\n    this name is long but cool\n" +
                "---------------------------------------------------\n";
        assertEquals(expected, actual);
    }
}
