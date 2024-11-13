package xyz.trinitygames.Terfarmer.player;

import xyz.trinitygames.Terfarmer.animals.Animal;
import xyz.trinitygames.Terfarmer.exceptions.NotEnoughMoneyException;
import xyz.trinitygames.Terfarmer.exceptions.SaveFailedException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LocalPlayer implements Player, Serializable {
    String name;
    List<Animal> animals;
    int money;
    int day;

    private String getSaveName() {
        return System.getProperty("user.home") + File.separatorChar + "Terfarmer" + File.separatorChar + this.name + ".save";
    }

    public LocalPlayer(String name) {
        this.name = name;

        String saveName = getSaveName();
        File saveFile = new File(saveName);

        if(saveFile.exists()) {
            // load the object
            try {
                FileInputStream fileIn = new FileInputStream(saveName);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                LocalPlayer savedPlayer = (LocalPlayer) objectIn.readObject();
                this.animals = savedPlayer.animals;
                this.money = savedPlayer.money;
                this.day = savedPlayer.day;
                fileIn.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new SaveFailedException(e.getMessage());
            }
        } else {
            this.money = 300;
            this.animals = new ArrayList<>();
            this.day = 1;
        }
    }

    /**
     * Get the name of the player.
     *
     * @return string name of the player
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the player.
     * Name must already be validated.
     *
     * @param name string to set as name
     */
    @Override
    public void setName(String name) {
        this.name = name;
        // TODO rename save file
    }

    /**
     * Adds an animal to the player's inventory.
     *
     * @param animal Animal object to add
     */
    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    /**
     * Remove an animal from the player's inventory.
     *
     * @param index index of the animal to remove
     */
    @Override
    public void removeAnimal(int index) {
        if(animals.size() <= index){
            // shouldn't be possible if the choice is already validated
            throw new IndexOutOfBoundsException();
        }
        animals.remove(index);
    }

    /**
     * Get all the animals in the player's inventory.
     *
     * @return list of Animal objects
     */
    @Override
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Get the amount of animals, without having to get all the animals
     *
     * @return int of the amount of animals
     */
    @Override
    public int getAnimalsCount() {
        return animals.size();
    }

    /**
     * Get the money of the Player
     *
     * @return int money
     */
    @Override
    public int getMoney() {
        return this.money;
    }

    /**
     * Add money to the player
     *
     * @param money amount of money to add
     */
    @Override
    public void addMoney(int money) {
        this.money += money;
    }

    /**
     * Remove money from the player
     *
     * @param money amount of money to remove
     * @throws NotEnoughMoneyException throws if the user doesn't have enough money
     */
    @Override
    public void removeMoney(int money) {
        if(money > this.money){
            throw new NotEnoughMoneyException("You only have " + this.money + " money.");
        }
        this.money -= money;
    }

    /**
     * Get the current day of the farm
     *
     * @return int day
     */
    @Override
    public int getDay() {
        return this.day;
    }

    /**
     * Increment the current day by 1
     */
    @Override
    public void incrementDay() {
        this.day++;
    }

    @Override
    public void save() {
        String filename = this.getSaveName();
        System.out.println("Saving player " + this.name + " to " + filename);

        // create the file if it doesn't exist
        File file = new File(filename);
        if(!file.exists()){
            try{
                boolean fileCreated = file.createNewFile();
            } catch (IOException e) {
                throw new SaveFailedException(e.getMessage());
            }
        }

        // write the object to it
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            throw new SaveFailedException(e.getMessage());
        }
    }
}
