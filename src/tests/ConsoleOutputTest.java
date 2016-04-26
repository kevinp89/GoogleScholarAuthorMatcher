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

import OutputLogger.ConsoleOutput;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for Console Output.
 */
public class ConsoleOutputTest {
    ConsoleOutput consoleOutput1;
    ConsoleOutput consoleOutput2;
    ConsoleOutput consoleOutput3;
    @Before public void setUp() throws Exception {
        consoleOutput1 = new ConsoleOutput("1. The author name is:\n    Kevin "
            + "Patel");
        consoleOutput2 = new ConsoleOutput("");
        consoleOutput3 = new ConsoleOutput("Output for file exported "
            + "successfully");
    }

    @After public void tearDown() throws Exception {
        consoleOutput1 = null;
    }

    @Test
    public void testgeOutput1()throws Exception{
        String expected = "1. The author name is:\n    Kevin "
            + "Patel";
        String actual = consoleOutput1.logOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testgeOutput2()throws Exception{
        String expected = "";
        String actual = consoleOutput2.logOutput();
        assertEquals(expected, actual);
    }

    @Test
    public void testgeOutput3()throws Exception{
        String expected = "Output for file exported "
            + "successfully";
        String actual = consoleOutput3.logOutput();
        assertEquals(expected, actual);
    }
}
