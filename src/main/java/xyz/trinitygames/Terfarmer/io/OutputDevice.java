package xyz.trinitygames.Terfarmer.io;

public interface OutputDevice {
    /**
     * Outputs given text, without any formatting.
     * @param text string to output
     */
    void write(String text);

    /**
     * Outputs given text, followed by a newline.
     * @param line string to output
     */
    void writeLine(String line);
}
