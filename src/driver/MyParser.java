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
package driver;

import Exceptions.CorruptUrlException;
import HtmlConverter.GoogleScholarHtmlExtract;
import HtmlConverter.HTMLextract;
import OutputLogger.ConsoleOutput;
import runner.Runner;

/**
 * Driver class. input html files (and or output file) and output content
 * extracted from html files (written to output file or console)
 */
public class MyParser {

    /**
    * @param args - file names.
    */
    public static void main(String[] args) {

        try{
            //split at , to get input html files
            String[] split = args[0].split(",");
            //initialize html array of split length.
            HTMLextract[] htmlArray = new HTMLextract[split.length];
            //populate html array
            for(int i=0;i<split.length;i++){
                htmlArray[i] = new GoogleScholarHtmlExtract(split[i]);
            }
            //if outfile is given initialize Runner with outfile, if not
            // initialize with empty.
            Runner run2 = (args.length == 2) ? new Runner(htmlArray, args[1]) :
                new Runner(htmlArray, "");
            // run the Runner.
            ConsoleOutput co = (ConsoleOutput) run2.act();
            // print out the ConsoleOutput.
            System.out.println(co.logOutput());


        }catch (CorruptUrlException e){
            System.out.println(e.getMessage());
        }


}
}
