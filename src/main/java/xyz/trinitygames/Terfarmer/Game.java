package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.io.InputDevice;
import xyz.trinitygames.Terfarmer.io.OutputDevice;
import xyz.trinitygames.Terfarmer.player.LocalPlayer;
import xyz.trinitygames.Terfarmer.player.Player;

public class Game {
    private final InputDevice id;
    private final OutputDevice od;
    private Player player;

    private void ShowMenu(){
        od.writeLine("1. View animals");
        od.writeLine("2. Buy a new animal");
        od.writeLine("3. Exit");
    }

    public Game(InputDevice id, OutputDevice od) {
        this.id = id;
        this.od = od;
    }

    public void start(){
        od.writeLine("Welcome to Terfarmer!");

        // read the name of the user player
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

        // initialize that player
        player = new LocalPlayer(name);

        // main game loop
        boolean running = true;
        do {
            // Show the menu
            od.writeLine("Your farm has " + player.getMoney() + " money and " + player.getAnimalsCount() + " animals!");
            od.writeLine("What would you like to do?");
            this.ShowMenu();

            // get the user's choice
            boolean validChoice = false;
            int choice = 0;
            do {
                try {
                    choice = id.getChoice(1, 3);
                    validChoice = true;
                } catch (IllegalArgumentException e) {
                    od.writeLine(e.getMessage());
                }
            } while (!validChoice);

            switch (choice) {
                case 1, 2:
                    od.writeLine("Not yet");
                    break;
                case 3:
                    running = false;
                    break;
            }
        } while (running);
    }
}
