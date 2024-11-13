package xyz.trinitygames.Terfarmer.io;

import xyz.trinitygames.Terfarmer.exceptions.InvalidChoiceException;
import xyz.trinitygames.Terfarmer.exceptions.InvalidNameException;

public interface InputDevice {
    /**
     * Reads text from the user
     * The text must be at most 16 characters
     * The text must only contain letters and spaces
     * The text must not start or end with a space
     * The text must not contain adjacent spaces
     * @return string containing the text
     * @throws InvalidNameException if the above conditions are not met
     */
    String getName();

    /**
     * Reads an integer from the user, between the given bounds
     * @param min lower bound (inclusive)
     * @param max upper bound (inclusive)
     * @return int between min and max
     * @throws InvalidChoiceException if the choice is out of range
     * @throws IllegalArgumentException if the input is not a number
     */
    int getChoice(int min, int max);
}
