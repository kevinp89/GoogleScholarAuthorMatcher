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
package builder;

/**
 * Output builder for HTML files.
 */
public interface OutputBuilder {

    /**
     * Build and return output for the given HTML content.
     * @return - the built output.
     */
    public String getOutputForContent();
}
