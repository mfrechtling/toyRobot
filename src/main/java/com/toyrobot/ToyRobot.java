package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandReader;
import com.toyrobot.interfaces.ICommandSet;

import java.io.IOException;
import java.io.InputStream;

public class ToyRobot {
    public Position position;
    public ICommandReader commandReader;

    public ToyRobot() {
        this.commandReader = new InputStreamReader(System.in);
    }

    public ToyRobot(InputStream input) {
        this.commandReader = new InputStreamReader(input);
    }

    public Position execNextCommand() throws IOException, ToyRobotException {
        ICommandSet command = commandReader.getNextCommand();
        Position currPosition = this.position == null ? null : new Position(this.position);
        return command.executeCommand(currPosition);
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}
