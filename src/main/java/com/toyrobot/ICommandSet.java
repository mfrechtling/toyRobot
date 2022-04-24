package com.toyrobot;

import com.toyrobot.exception.CommandException;

public interface ICommandSet {
    public void parseCommand(String command) throws CommandException;

    public Position executeCommand(Position currentPosition);
}
