package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandReader;

public class Simulator {
    public Table table;
    public ToyRobot robot;

    public Simulator() {
        this.table = new Table(5);

        this.robot = new ToyRobot();
    }

    public Simulator(int size) {
        this.table = new Table(size);
        this.robot = new ToyRobot();
    }

    public Simulator(int size, ICommandReader input) {
        this.table = new Table(size);
        this.robot = new ToyRobot(input);
    }

    public Simulator(int width, int height) {
        this.table = new Table(width, height);
        this.robot = new ToyRobot();
    }

    public Simulator(int width, int height, ICommandReader input) {
        this.table = new Table(width, height);
        this.robot = new ToyRobot(input);
    }

    /**
     * Perform a single step in the simulation, results in the ToyRobot executing the next available command
     *
     * @throws ToyRobotException
     */
    public void simulationStep() throws ToyRobotException {
        Position nextPosition = robot.execNextCommand();
        if (table.positionIsValid(nextPosition)) robot.setPosition(nextPosition);
    }
}
