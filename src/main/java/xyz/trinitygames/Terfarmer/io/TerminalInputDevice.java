package xyz.trinitygames.Terfarmer.io;

import xyz.trinitygames.Terfarmer.exceptions.InvalidChoiceException;
import xyz.trinitygames.Terfarmer.exceptions.InvalidNameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalInputDevice implements InputDevice {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Reads text from the user from keyboard
     * The text must be at most 16 characters, and cannot be empty
     * The text must only contain letters and spaces
     * The text must not start or end with a space
     * The text must not contain adjacent spaces
     * @return string containing the text
     */
    @Override
    public String getName() {
        String text = scanner.nextLine();

        if(text.isEmpty()) throw new InvalidNameException("Names can't be empty.");
        if(text.length() > 16) throw new InvalidNameException("Names can be at most 16 characters long.");

        for(char l : text.toCharArray()) {
            if(l >= 'A' && l <= 'Z') continue;
            if(l >= 'a' && l <= 'z') continue;
            if(l == ' ') continue;

            throw new InvalidNameException("Names cannot contain the character \"" + l + "\". Please stick to letters and spaces.");
        }

        if(text.charAt(0) == ' ') throw new InvalidNameException("Names can't start with spaces.");
        if(text.charAt(text.length() - 1) == ' ') throw new InvalidNameException("Names can't end with spaces.");

        if(text.contains("  ")) throw new InvalidNameException("Names can't contain multiple adjacent spaces.");

        return text;
    }

    /**
     * Reads an integer from the user from keyboard, between the given bounds
     *
     * @param min lower bound (inclusive)
     * @param max upper bound (inclusive)
     * @return int between min and max
     */
    @Override
    public int getChoice(int min, int max) {
        int choice;
        try {
            choice = scanner.nextInt();
        } catch(InputMismatchException e) {
            scanner.next(); // fixes infinite loop thingy
            throw new InvalidChoiceException("Choice must be an integer.");
        }
        if(choice < min || choice > max){
            throw new InvalidChoiceException("Choice must be between " + min + " and " + max + ".");
        }
        return choice;
    }
}
