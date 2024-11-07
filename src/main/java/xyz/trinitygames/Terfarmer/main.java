package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.io.OutputDevice;
import xyz.trinitygames.Terfarmer.io.TerminalOutputDevice;

public class main {
    public static void main(String[] args) {
        OutputDevice out = new TerminalOutputDevice();

        Store store = new Store();

        out.write(store.toString());
    }
}
