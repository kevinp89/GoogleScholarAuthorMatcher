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
package OutputLogger;

/**
 * Console outputter.
 */
public class ConsoleOutput implements OutputWriter {
    //tracker for output string.
    private String output;
    //default constructor for testing.
    public ConsoleOutput(){}

    //constructor with output initializer.
    public ConsoleOutput(String output){
        this.output = output;
    }

    /**
     * Return the output.
     * @return - the output.
     */
    @Override public String logOutput() {
        return this.output;
    }
}
