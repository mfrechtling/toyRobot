package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App implements Runnable {

    public static void main(String[] args) {
        addShutdownHook();
        Thread simulatorThread = new Thread(new App());
        System.out.println("*****************************************************************");
        System.out.println("*\tToyRobot simulator - enter commands to move the robot\t*");
        System.out.println("*****************************************************************\n");
        System.out.println("Use Ctrl-C to exit...\n");
        simulatorThread.start();
    }

    public void run() {
        Simulator simulator = new Simulator();
        while (true) {
            try {
                simulator.simulationStep();
            } catch (ToyRobotException | IOException cEx) {
                System.out.println("Command format is invalid");
            }
        }
    }

    private static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                try {
                    Thread.sleep(200);
                    System.out.println("\nShutting down simulator...");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        });
    }
}
