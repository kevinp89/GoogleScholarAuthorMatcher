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

import format.Formatter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * test for Formatting.
 */
public class FormatterTest {

    @Test
    public void testFormatAuthor(){
        String expected = "Name of Author:\n    Kevin Patel\n";
        String actual = Formatter.authorFormat("Kevin Patel");
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatTotalCitations(){
        String expected = "Number of all citations:\n    900\n";
        String actual = Formatter.numberOfCitations("900");
        assertEquals(expected, actual);
    }

    @Test
    public void testFormatFirstnCitations(){
        String expected = "Total paper citations (first 5 papers):\n    90\n";
        String actual = Formatter.firstnCitations("90", 5);
        assertEquals(expected, actual);
    }

}
