package OutputLogger;

/**
 * Interface for writing outputs.
 */
public interface OutputWriter {
    /**
     * log Output.
     * @return - a string of output if output is generated, otherwise log a
     * message.
     * @throws Exception
     */
    public String logOutput() throws Exception;
}
