package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, CommandException {
        Simulator simulator = new Simulator();
        while (true) {
            try {
                simulator.simulationStep();
            } catch (CommandException cEx) {
                System.out.println("Command format is invalid");
            }
        }
    }
}
