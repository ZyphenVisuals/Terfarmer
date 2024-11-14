package xyz.trinitygames.Terfarmer.io;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TerminalWithLogOutputDevice implements OutputDevice {
    FileWriter fw;

    public TerminalWithLogOutputDevice() {
        // get the current time
        Calendar currentTime = new GregorianCalendar();

        int year = currentTime.get(Calendar.YEAR);
        int month = currentTime.get(Calendar.MONTH);
        int day = currentTime.get(Calendar.DAY_OF_MONTH);
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);
        int second = currentTime.get(Calendar.SECOND);

        String currentTimeString = "";
        currentTimeString += year;
        currentTimeString += "-";
        currentTimeString += month >= 10 ? month : "0" + month;
        currentTimeString += "-";
        currentTimeString += day >= 10 ? day : "0" + day;
        currentTimeString += " ";
        currentTimeString += hour >= 10 ? hour : "0" + hour;
        currentTimeString += "-";
        currentTimeString += minute >= 10 ? minute : "0" + minute;
        currentTimeString += "-";
        currentTimeString += second >= 10 ? second : "0" + second;

        // get the filename of the current log
        String filename = System.getProperty("user.home") + File.separatorChar + "Terfarmer"
                + File.separatorChar + "logs" + File.separatorChar + currentTimeString + ".log";

        // create the file
        File file = new File(filename);
        try {
            boolean fileCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            this.fw = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Outputs given text, without any formatting.
     *
     * @param text string to output
     */
    @Override
    public void write(String text) {
        System.out.print(text);
        try {
            fw.write(text);
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Outputs given text, followed by a newline.
     *
     * @param line string to output
     */
    @Override
    public void writeLine(String line) {
        System.out.println(line);
        try {
            fw.write(line);
            fw.write(System.lineSeparator());
            fw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
