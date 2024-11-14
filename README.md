# Terfarmer

Terframer is a ter(minal) farming simulator... sort of.

In reality, terframer is my midterm project for the Java course from the West University of Timisoara. I've only been learning Java for about 6 weeks now, so don't take this too seriously.

## Usage

The easiest way to run the project is to clone the entire repository and open it in InteliJ (community edition is fine).

## Features

- Players can buy animals that make them money
- The animals' lifespam is randomly generated (within some bounds) in their constructor
- While they are alive, the animals will make the player money each day
- Progress is saved by using the players' name
- Logging can be enabled with the `-o terminal_log` argument

## Dependencies

The project only depends on `commons-cli`, which it uses for parsing the command arguments. This should be automatically installed by Maven.

The project requires a Java 23 JDK. Any JDK should work, but I personally use `graalvm-ce-23` and tested `openjdk-23`.
