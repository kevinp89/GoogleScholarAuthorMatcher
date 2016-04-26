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
package ContentExtract;

import Exceptions.MatchNotFoundException;

/**
 * Extractor abstract Class
 */
public abstract class Extract {

    /**
     * Extract the content based on the class. The parameters can be
     * changed/added in the subclasses.
     */
    public static String extract(String htmlContent) throws
        MatchNotFoundException{
        return "Illegal call inside Super class\n";
    }

}
