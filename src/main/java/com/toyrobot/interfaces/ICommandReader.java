package com.toyrobot.interfaces;

import com.toyrobot.exception.ToyRobotException;

import java.io.IOException;
import java.util.ArrayList;

public interface ICommandReader {
    public String readCommand() throws IOException, ToyRobotException;

    public ArrayList<String> readCommands() throws ToyRobotException;

    public ICommandSet getNextCommand() throws ToyRobotException;
}
