package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.io.InputDevice;
import xyz.trinitygames.Terfarmer.io.OutputDevice;

public class Game {
    private final InputDevice id;
    private final OutputDevice od;

    public Game(InputDevice id, OutputDevice od) {
        this.id = id;
        this.od = od;
    }

    public void start(){
        od.writeLine("Welcome to Terfarmer!");

        boolean nameRead = false;
        String name = "";
        do {
            try {
                od.write("Please enter your name: ");
                name = id.getName();
                nameRead = true;
            } catch (IllegalArgumentException e) {
                od.writeLine(e.getMessage());
            }
        } while(!nameRead);
        

        od.writeLine("Hi " + name + "!");
    }
}
