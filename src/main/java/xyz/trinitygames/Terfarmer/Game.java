package xyz.trinitygames.Terfarmer;

import xyz.trinitygames.Terfarmer.animals.Animal;
import xyz.trinitygames.Terfarmer.exceptions.NotEnoughMoneyException;
import xyz.trinitygames.Terfarmer.io.InputDevice;
import xyz.trinitygames.Terfarmer.io.OutputDevice;
import xyz.trinitygames.Terfarmer.player.LocalPlayer;
import xyz.trinitygames.Terfarmer.player.Player;

import java.util.NoSuchElementException;

public class Game {
    private final InputDevice id;
    private final OutputDevice od;
    private Player player;
    private Store store;

    private void ShowMenu(){
        od.writeLine("1. View animals");
        od.writeLine("2. Buy a new animal");
        od.writeLine("3. Remove dead animals");
        od.writeLine("4. Sleep until tomorrow");
        od.writeLine("5. Save");
        od.writeLine("6. Exit");
    }

    public Game(InputDevice id, OutputDevice od) {
        this.id = id;
        this.od = od;
        this.store = new Store();
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
            } catch (Exception e) {
                od.writeLine(e.getMessage());
            }
        } while(!nameRead);

        // initialize that player
        player = new LocalPlayer(name);

        // main game loop
        boolean running = true;
        do {
            // Show the menu
            od.writeLine("");
            od.writeLine("Your farm has " + player.getMoney() + " money and " + player.getAnimalsCount() + " animals!");
            od.writeLine("What would you like to do?");
            this.ShowMenu();

            // get the user's choice
            boolean validChoice = false;
            int choice = 0;
            do {
                try {
                    choice = id.getChoice(1, 6);
                    validChoice = true;
                } catch (Exception e) {
                    od.writeLine(e.getMessage());
                    od.write("Please try again: ");
                }
            } while (!validChoice);

            switch (choice) {
                case 1:
                    if(player.getAnimalsCount() == 0){
                        od.writeLine("You don't have any animals!");
                        break;
                    }
                    for(Animal a : player.getAnimals()){
                        od.writeLine(a.toString());
                    }
                    break;
                case 2:
                    // show the player the shop
                    od.writeLine("The following animals are available in the daily shop:");
                    for(int i=0; i<store.getStock().size(); i++){
                        od.writeLine((i+1) + " " + store.getStock().get(i));
                    }
                    od.writeLine("Which animal would you like to buy? (Enter 0 to cancel)");

                    // get the animal to buy
                    int subchoice = 0;
                    boolean validSubchoice = false;
                    do {
                        try {
                            subchoice = id.getChoice(0, store.getStock().size());
                            validSubchoice = true;
                        } catch (Exception e) {
                            od.writeLine(e.getMessage());
                            od.write("Please try again: ");
                        }
                    } while (!validSubchoice);

                    if(subchoice == 0) break;

                    // try to remove the money from the player
                    try {
                        player.removeMoney(store.getStock().get(subchoice - 1).getValue());
                    } catch (NotEnoughMoneyException e) {
                        od.writeLine("Cannot buy the animal. " + e.getMessage());
                        break;
                    }

                    // if the transaction worked, transfer the animal
                    player.addAnimal(store.getStock().get(subchoice - 1));
                    store.removeAnimal(subchoice - 1);

                    // notify the player
                    od.writeLine("Animal purchased!");

                    break;
                case 3:
                    int removed = 0;
                    int ac = player.getAnimalsCount();
                    for(int i=ac-1; i>=0; i--){
                        if(player.getAnimals().get(i).getLifetime() == 0){
                            player.removeAnimal(i);
                            removed++;
                        }
                    }
                    od.writeLine("You removed " + removed + " animals!");
                    break;
                case 4:
                    // get income from all animals and age them up
                    for(Animal a : player.getAnimals()){
                        if(a.getLifetime() == 0){ continue; }
                        player.addMoney(a.getIncome());
                        od.writeLine(a.getName() + " has made you " + a.getIncome() + " money!");
                        a.age();
                        if(a.getLifetime() == 0 ){
                            od.writeLine(a.getName() + " has died :(");
                        }
                    }
                    // refresh the shop
                    store.refresh();
                    break;
                case 6:
                    running = false;
                    break;
            }
        } while (running);
    }
}
