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

import java.io.*;

/**
 * Write output to outFile.
 */
public class FileOutput implements OutputWriter {
    //tracker for file name
    private String fileName;
    //tracker for output string.
    private String output;
    //default constructor for testing.
    public FileOutput(){}
    //Constructor with filename (name of outFile) and output initializer
    public FileOutput(String filename, String output){
        this.fileName = filename;
        this.output = output;
    }

    /**
     * Write the output to a file provided
     */
    @Override public String logOutput(){

        try{
            //construct a file
            File file = new File(fileName);
            //if file does not exist, create it
            if (!file.exists()) {
                file.createNewFile();
            }
            //write to the file
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(this.output);
            //close the file
            bw.close();
            //return a message
            return "Output written to " + fileName + " successfully";

        }catch (IOException e){
            return e.getMessage();
        }
    }
}
