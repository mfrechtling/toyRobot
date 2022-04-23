package com.toyrobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DirectionTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DirectionTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DirectionTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testRotation() {
        Direction direction = Direction.NORTH;
        direction = direction.left();
        assertEquals(direction, Direction.WEST);
        direction = direction.left();
        assertEquals(direction, Direction.SOUTH);
        direction = direction.left();
        assertEquals(direction, Direction.EAST);
        direction = direction.left();
        assertEquals(direction, Direction.NORTH);
        direction = direction.right();
        assertEquals(direction, Direction.EAST);
        direction = direction.right();
        assertEquals(direction, Direction.SOUTH);
        direction = direction.right();
        assertEquals(direction, Direction.WEST);
        direction = direction.right();
        assertEquals(direction, Direction.NORTH);
    }
}
