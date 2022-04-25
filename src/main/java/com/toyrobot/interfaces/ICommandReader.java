package com.toyrobot.interfaces;

import com.toyrobot.exception.ToyRobotException;

import java.io.IOException;
import java.util.ArrayList;

public interface ICommandReader {
    public String readCommand() throws IOException;

    public ArrayList<String> readCommands();

    public ICommandSet getNextCommand() throws IOException, ToyRobotException;
}
