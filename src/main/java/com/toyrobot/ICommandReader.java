package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.io.IOException;

public interface ICommandReader {
    public String readCommand() throws IOException;

    public String[] readCommands();

    public ICommandSet getNextCommand() throws IOException, CommandException;
}
