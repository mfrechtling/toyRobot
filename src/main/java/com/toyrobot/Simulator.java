package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.io.IOException;

public class Simulator {
    public Table table;
    public ToyRobot robot;

    public Simulator() {
        this.table = new Table(5);
        this.robot = new ToyRobot();
    }

    public void simulationStep() throws IOException, CommandException {
        Position nextPosition = robot.execNextCommand();
        if (table.positionIsValid(nextPosition)) robot.setPosition(nextPosition);
    }
}
