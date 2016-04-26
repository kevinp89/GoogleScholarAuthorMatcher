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
import OutputLogger.ConsoleOutput;
import OutputLogger.OutputWriter;
import org.junit.After;
import org.junit.Test;
import runner.Runner;
import java.io.File;
import static org.junit.Assert.assertTrue;


/**
 * Tests for Runner.
 */
public class RunnerTest {
    Runner run;
    @After public void tearDown() throws Exception {
        run = null;
    }

    @Test
    public void testRunOneHtmlFile()throws Exception{
        HTMLextract[] html = new HTMLextract[1];
        MOCKGoogleScholarHtmlExtract extract = new
            MOCKGoogleScholarHtmlExtract("sample1.html");
        html[0] = extract;
        run = new Runner(html, "");
        OutputWriter output = run.act();
        assertTrue(output instanceof ConsoleOutput);
    }

    @Test
    public void testRunWithTwoHTML()throws Exception{
        HTMLextract[] html = new HTMLextract[2];
        MOCKGoogleScholarHtmlExtract extract = new
            MOCKGoogleScholarHtmlExtract("sample1.html");
        MOCKGoogleScholarHtmlExtract extract2 = new
            MOCKGoogleScholarHtmlExtract("sample2.html");
        html[0] = extract;
        html[1] = extract2;
        run = new Runner(html, "");
        OutputWriter output = run.act();
        assertTrue(output instanceof ConsoleOutput);
    }

    @Test
    public void testRunWithOutFile()throws Exception{
        HTMLextract[] html = new HTMLextract[1];
        MOCKGoogleScholarHtmlExtract extract = new
            MOCKGoogleScholarHtmlExtract("sample1.html");
        html[0] = extract;
        run = new Runner(html, "outFile.txt");
        OutputWriter output = run.act();
        assertTrue(output instanceof ConsoleOutput);

        File file = new File("outFile.txt");
        assertTrue(file.exists());
    }

}
