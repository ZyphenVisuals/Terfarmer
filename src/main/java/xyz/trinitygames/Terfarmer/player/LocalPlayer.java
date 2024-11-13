package xyz.trinitygames.Terfarmer.player;

import xyz.trinitygames.Terfarmer.animals.Animal;
import xyz.trinitygames.Terfarmer.exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class LocalPlayer implements Player {
    String name;
    List<Animal> animals;
    int money;

    public LocalPlayer(String name) {
        this.name = name;
        this.money = 300;
        this.animals = new ArrayList<>();
        // TODO check for saved data
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

    @Override
    public void save() {
        // TODO learn how to save a class to a file lol
    }
}
