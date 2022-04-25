package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;

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
        Simulator simulator = new Simulator(5, new InputStreamReader(System.in));
        while (true) {
            try {
                simulator.simulationStep();
            } catch (ToyRobotException e) {
                System.out.println("Error occurred in current simulation step:");
                e.printStackTrace();
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
