package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandReader;
import com.toyrobot.interfaces.ICommandSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputStreamReader implements ICommandReader {

    private final Scanner inputScanner;

    public InputStreamReader(InputStream inputStream) {
        inputScanner = new Scanner(inputStream);
    }

    public String readCommand() throws IOException {
        return inputScanner.nextLine();
    }

    public ArrayList<String> readCommands() {
        ArrayList<String> results = new ArrayList<String>();
        while (inputScanner.hasNext()) {
            results.add(inputScanner.nextLine());
        }
        return results;
    }

    public ICommandSet getNextCommand() throws IOException, ToyRobotException {
        String commandString = this.readCommand();
        ICommandSet command = new Command();
        command.parseCommand(commandString);
        return command;
    }
}
