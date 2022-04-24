package com.toyrobot;

import com.toyrobot.exception.CommandException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CommandTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CommandTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CommandTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testPlace() throws CommandException {
        Command command = new Command();
        command.parseCommand("PLACE 2,2,EAST");
        assertEquals(command.type, CommandType.PLACE);
        assertEquals(command.params.length, 3);
        assertEquals(command.params[0], 2);
        assertEquals(command.params[1], 2);
        assertEquals(command.params[2], Direction.EAST);
    }

    public void testMove() throws CommandException {
        Command command = new Command();
        command.parseCommand("MOVE");
        assertEquals(command.type, CommandType.MOVE);
    }

    public void testLeft() throws CommandException {
        Command command = new Command();
        command.parseCommand("LEFT");
        assertEquals(command.type, CommandType.LEFT);
    }

    public void testRight() throws CommandException {
        Command command = new Command();
        command.parseCommand("RIGHT");
        assertEquals(command.type, CommandType.RIGHT);
    }

    public void testReport() throws CommandException {
        Command command = new Command();
        command.parseCommand("REPORT");
        assertEquals(command.type, CommandType.REPORT);
    }

    public void testWeirdFormat() throws CommandException {
        Command command = new Command();
        command.parseCommand("pLaCe    7 , -2           ,SoUtH");
        assertEquals(command.type, CommandType.PLACE);
        assertEquals(command.params.length, 3);
        assertEquals(command.params[0], 7);
        assertEquals(command.params[1], -2);
        assertEquals(command.params[2], Direction.SOUTH);
    }

    public void testBadCommand() throws CommandException {
        try {
            Command command = new Command();
            command.parseCommand("BadCommand");
        } catch (CommandException ex) {
            assertEquals(ex.getMessage(), "FAILED TO CONVERT STRING COMMAND");
        }
    }
}
