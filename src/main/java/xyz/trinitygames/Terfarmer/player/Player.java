package xyz.trinitygames.Terfarmer.player;

import xyz.trinitygames.Terfarmer.animals.Animal;
import xyz.trinitygames.Terfarmer.exceptions.NotEnoughMoneyException;

import java.util.List;

public interface Player {

    /**
     * Get the name of the player.
     * @return string name of the player
     */
    String getName();

    /**
     * Set the name of the player.
     * Name must already be validated.
     * @param name string to set as name
     */
    void setName(String name);

    /**
     * Adds an animal to the player's inventory.
     * @param animal Animal object to add
     */
    void addAnimal(Animal animal);

    /**
     * Remove an animal from the player's inventory.
     * @param index index of the animal to remove
     */
    void removeAnimal(int index);

    /**
     * Get all the animals in the player's inventory.
     * @return list of Animal objects
     */
    List<Animal> getAnimals();

    /**
     * Get the amount of animals, without having to get all the animals
     * @return int of the amount of animals
     */
    int getAnimalsCount();

    /**
     * Get the money of the Player
     * @return int money
     */
    int getMoney();

    /**
     * Add money to the player
     * @param money amount of money to add
     */
    void addMoney(int money);

    /**
     * Remove money from the player
     * @param money amount of money to remove
     * @throws NotEnoughMoneyException throws if the user doesn't have enough money
     */
    void removeMoney(int money);

    /**
     * Get the current day of the farm
     * @return int day
     */
    int getDay();

    /**
     * Increment the current day by 1
     */
    void incrementDay();

    void save();
}
