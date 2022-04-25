package com.toyrobot.interfaces;

import com.toyrobot.Position;
import com.toyrobot.exception.ToyRobotException;

public interface ICommandSet {
    
    public void parseCommand(String command) throws ToyRobotException;

    public Position executeCommand(Position currentPosition) throws ToyRobotException;
}
