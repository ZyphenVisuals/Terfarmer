package xyz.trinitygames.Terfarmer.io;

public class TerminalOutputDevice implements OutputDevice {
    /**
     * Outputs given text, without any formatting.
     *
     * @param text string to output
     */
    @Override
    public void write(String text) {
        System.out.print(text);
    }

    /**
     * Outputs given text, followed by a newline.
     *
     * @param line string to output
     */
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

}
