package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements ICommandReader {

    private final BufferedReader consoleReader;

    public ConsoleReader() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readCommand() throws IOException {
        return consoleReader.readLine();
    }

    public String[] readCommands() {
        return new String[0];
    }

    public ICommandSet getNextCommand() throws IOException, CommandException {
        String commandString = this.readCommand();
        ICommandSet command = new Command();
        command.parseCommand(commandString);
        return command;
    }
}
