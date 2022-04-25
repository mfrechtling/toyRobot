package com.toyrobot;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class TableTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public TableTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TableTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testNullPosition() {
        Table table = new Table(10);
        assertFalse(table.positionIsValid(null));
    }

    public void testBadPosition() {
        Table table = new Table(7);
        assertFalse(table.positionIsValid(new Position(7, 6, Direction.NORTH)));
        assertFalse(table.positionIsValid(new Position(6, 7, Direction.NORTH)));
        assertFalse(table.positionIsValid(new Position(-1, 6, Direction.NORTH)));
        assertFalse(table.positionIsValid(new Position(6, -1, Direction.NORTH)));
    }

    public void testGoodPositions() {
        int tableSize = 10;
        Table table = new Table(tableSize);
        for (int x = 0; x < tableSize; x++) {
            for (int y = 0; y < tableSize; y++) {
                assertTrue(table.positionIsValid(new Position(x, y, Direction.NORTH)));
            }
        }
    }

    public void testBadTableSize() {
        int tableSize = 5;
        try {
            Table table = new Table(-tableSize);
            fail("Table succesfully created with bad table size");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "Size of table must be greater than zero");
        }
        try {
            Table table = new Table(tableSize, -tableSize);
            fail("Table succesfully created with bad table size");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "Size of table must be greater than zero");
        }
        try {
            Table table = new Table(-tableSize, tableSize);
            fail("Table succesfully created with bad table size");
        } catch (IllegalArgumentException ex) {
            assertEquals(ex.getMessage(), "Size of table must be greater than zero");
        }
    }
}
