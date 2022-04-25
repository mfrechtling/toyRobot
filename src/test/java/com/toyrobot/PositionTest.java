package com.toyrobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PositionTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PositionTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PositionTest.class);
    }

    public void testGetX() {
        Position position = new Position(2, 4, Direction.SOUTH);
        assertEquals(position.getX(), 2);
    }

    public void testGetY() {
        Position position = new Position(4, 7, Direction.SOUTH);
        assertEquals(position.getY(), 7);
    }

    public void testGetDirection() {
        Position position = new Position(4, 7, Direction.EAST);
        assertEquals(position.getDirection(), Direction.EAST);
    }

    public void testTurnLeft() {
        Position position = new Position(0, 0, Direction.NORTH);
        position.turnLeft();
        position.turnLeft();
        position.turnLeft();
        position.turnLeft();
        assertEquals(position.getDirection(), Direction.NORTH);
    }

    public void testTurnRight() {
        Position position = new Position(0, 0, Direction.NORTH);
        position.turnRight();
        position.turnRight();
        position.turnRight();
        position.turnRight();
        assertEquals(position.getDirection(), Direction.NORTH);
    }

    public void testMove() {
        Position position = new Position(0, 0, Direction.NORTH);
        position.move();
        position.move();
        position.move();
        position.move();
        position.turnRight();
        position.move();
        position.move();
        position.move();
        position.move();
        assertEquals(position.getX(), 4);
        assertEquals(position.getY(), 4);
    }

    public void testBigMoves() {
        Position position = new Position(0, 0, Direction.NORTH);
        position.move(4);
        position.move(3);
        position.move(2);
        position.move(1);
        position.turnRight();
        position.move(-1);
        position.move(-2);
        position.move(-3);
        position.move(-4);
        assertEquals(position.getX(), -10);
        assertEquals(position.getY(), 10);
    }
}
