package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandReader;
import com.toyrobot.interfaces.ICommandSet;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputStreamReader implements ICommandReader {

    private final Scanner inputScanner;

    public InputStreamReader(InputStream inputStream) {
        inputScanner = new Scanner(inputStream);
    }

    /**
     * Read the next available command from the user input
     *
     * @return String contains text version of the next available command
     * @throws ToyRobotException
     */
    @Override
    public String readCommand() throws ToyRobotException {
        try {
            return inputScanner.nextLine();
        } catch (Exception ex) {
            throw new ToyRobotException("Failed to read from input");
        }
    }

    /**
     * Read all available commands from the user input
     *
     * @return ArrayList containing a set of text versions of commands
     * @throws ToyRobotException
     */
    @Override
    public ArrayList<String> readCommands() throws ToyRobotException {
        try {
            ArrayList<String> results = new ArrayList<>();
            while (inputScanner.hasNext()) {
                results.add(inputScanner.nextLine());
            }
            return results;
        } catch (Exception ex) {
            throw new ToyRobotException("Failed to read from input");
        }
    }

    /**
     * Read the next available command from the user input and convert into a command
     *
     * @return ICommandSet the next command
     * @throws ToyRobotException
     */
    @Override
    public ICommandSet getNextCommand() throws ToyRobotException {
        String commandString = this.readCommand();
        ICommandSet command = new Command();
        command.parseCommand(commandString);
        return command;
    }
}
