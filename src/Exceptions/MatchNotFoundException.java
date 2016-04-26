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
package Exceptions;

/**
 * Thrown when regular expression does not find any matches in the given
 * content.
 */
public class MatchNotFoundException extends Exception {

    // constructor with no arguments.
    public MatchNotFoundException(){
        super("Match not found");
    }

    //constructor with msg parameter.
    public MatchNotFoundException(String msg){
        super(msg);
    }
}
