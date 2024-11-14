package xyz.trinitygames.Terfarmer;

import org.apache.commons.cli.*;
import xyz.trinitygames.Terfarmer.io.*;

import java.io.File;

public class main {
    public static void main(String[] args) {
        // initialize devices
        InputDevice id = new TerminalInputDevice();
        OutputDevice od = null;

        // read command line options
        Options options = new Options();
        Option OutputDeviceOption = new Option("o", "outputDevice", true, "Output device. \nMust be one of: \"terminal\", \"terminal_log\"");
        OutputDeviceOption.setRequired(true);
        options.addOption(OutputDeviceOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;//not a good practice, it serves it purpose

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        switch (cmd.getOptionValue("outputDevice")) {
            case "terminal":
                od = new TerminalOutputDevice();
                break;
            case "terminal_log":
                od = new TerminalWithLogOutputDevice();
                break;
            default:
                System.out.println("Unknown output device: " + cmd.getOptionValue("outputDevice"));
                System.exit(1);
        }

        // create main folder if it doesn't exist
        File folder = new File(System.getProperty("user.home") + File.separator + "Terfarmer");
        if(!folder.exists()) {
            boolean folderCreated = folder.mkdir();
        }

        // create save folder if it doesn't exist
        folder = new File(System.getProperty("user.home") + File.separator + "Terfarmer" + File.separator + "saves");
        if(!folder.exists()) {
            boolean folderCreated = folder.mkdir();
        }

        // create log folder if it doesn't exist
        folder = new File(System.getProperty("user.home") + File.separator + "Terfarmer" + File.separator + "logs");
        if(!folder.exists()) {
            boolean folderCreated = folder.mkdir();
        }

        Game app = new Game(id, od);
        app.start();
    }
}
