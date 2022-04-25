package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;

import java.io.IOException;
import java.io.InputStream;

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

    public Simulator(int size, InputStream input) {
        this.table = new Table(size);
        this.robot = new ToyRobot(input);
    }

    public Simulator(int width, int height) {
        this.table = new Table(width, height);
        this.robot = new ToyRobot();
    }

    public Simulator(int width, int height, InputStream input) {
        this.table = new Table(width, height);
        this.robot = new ToyRobot(input);
    }

    public void simulationStep() throws IOException, ToyRobotException {
        Position nextPosition = robot.execNextCommand();
        if (table.positionIsValid(nextPosition)) robot.setPosition(nextPosition);
    }
}
