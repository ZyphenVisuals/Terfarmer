package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.io.InputDevice;
import xyz.trinitygames.Terfarmer.io.OutputDevice;
import xyz.trinitygames.Terfarmer.io.TerminalInputDevice;
import xyz.trinitygames.Terfarmer.io.TerminalOutputDevice;

public class main {
    public static void main(String[] args) {
        InputDevice id = new TerminalInputDevice();
        OutputDevice od = new TerminalOutputDevice();

        Game app = new Game(id, od);
        app.start();
    }
}
