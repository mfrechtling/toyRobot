package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.io.IOException;

public class ToyRobot {
    public Position position;
    public ICommandReader commandReader;

    public ToyRobot() {
        this.commandReader = new ConsoleReader();
    }

    public Position execNextCommand() throws IOException, CommandException {
        ICommandSet command = commandReader.getNextCommand();
        Position currPosition = this.position == null ? null : new Position(this.position);
        return command.executeCommand(currPosition);
    }

    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}
