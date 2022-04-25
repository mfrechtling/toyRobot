package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandReader;
import com.toyrobot.interfaces.ICommandSet;

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

    public ToyRobot(ICommandReader reader) {
        this.commandReader = reader;
    }

    /**
     * Execute the next available command
     *
     * @return Updated position based on the exectued command
     * @throws ToyRobotException
     */
    public Position execNextCommand() throws ToyRobotException {
        ICommandSet command = commandReader.getNextCommand();
        Position currPosition = this.position == null ? null : new Position(this.position);
        return command.executeCommand(currPosition);
    }

    /**
     * Set the position of the robot
     *
     * @param newPosition the new position of the robot
     */
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }
}
