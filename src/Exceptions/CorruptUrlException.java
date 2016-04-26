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
 * Thrown when the url is malfunctioning or not found.
 */

public class CorruptUrlException extends Exception{

    //default constructor with default msg.
    public CorruptUrlException(){
        super("Malformmated or currupt URL, please Try again");
    }

    //constructor with custom msg.
    public CorruptUrlException(String msg){
        super(msg);
    }

}
