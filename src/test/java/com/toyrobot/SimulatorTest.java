package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class SimulatorTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SimulatorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SimulatorTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testExampleData() throws IOException, ToyRobotException {
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));

        File path = new File(new File("").getAbsolutePath() + "/src/test/resources");
        for (File file : Objects.requireNonNull(path.listFiles())) {
            FileInputStream input = new FileInputStream(file);
            Simulator simulator = new Simulator(5, input);
            String result = out.toString();
            while (result.equals("")) {
                simulator.simulationStep();
                result = out.toString();
            }
            String fileName = file.getName().split("\\.")[0];
            assertEquals(result.replaceAll("\\P{Print}", ""), fileName.replaceAll("\\P{Print}", ""));
        }
    }
}
