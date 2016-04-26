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

import OutputLogger.FileOutput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.assertEquals;

/**
 * Test for writing output into a file.
 */
public class FileOutputTest {
    FileOutput fileOutput1;
    FileOutput fileOutput2;
    @Before public void setUp() throws Exception {
        fileOutput1 = new FileOutput("out.txt", "1. Author Name:\n    "
            + "Kevin Patel\n");
        fileOutput2 = new FileOutput("out.txt", "no match found\n");
    }

    @After public void tearDown() throws Exception {
        fileOutput1 = null;
    }

    @Test
    public void testFileMake1()throws Exception{
        String out = fileOutput1.logOutput();
        File actual = new File("out.txt");
        assertEquals(true, actual.exists());
        assertEquals("Output written to out.txt successfully", out);
    }
    @Test
    public void testFileMake2()throws Exception{
        String out = fileOutput2.logOutput();
        File actual = new File("out.txt");
        assertEquals(true, actual.exists());
        assertEquals("Output written to out.txt successfully", out);

        String expected = "no match found";

        BufferedReader bufferedReader = new BufferedReader(new FileReader
            ("out.txt"));
        String line = bufferedReader.readLine();
        String newActual = "";
        while (line!=null){
            newActual += line;
            line= bufferedReader.readLine();
        }
        assertEquals(expected, newActual);
    }
}
