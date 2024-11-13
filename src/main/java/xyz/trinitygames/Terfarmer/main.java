package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.io.InputDevice;
import xyz.trinitygames.Terfarmer.io.OutputDevice;
import xyz.trinitygames.Terfarmer.io.TerminalInputDevice;
import xyz.trinitygames.Terfarmer.io.TerminalOutputDevice;

import java.io.File;

public class main {
    public static void main(String[] args) {
        // initialize devices
        InputDevice id = new TerminalInputDevice();
        OutputDevice od = new TerminalOutputDevice();

        // create save folder if it doesn't exist
        File saveFolder = new File(System.getProperty("user.home") + File.separator + "Terfarmer");
        if(!saveFolder.exists()) {
            boolean folderCreated = saveFolder.mkdir();
        }

        Game app = new Game(id, od);
        app.start();
    }
}
