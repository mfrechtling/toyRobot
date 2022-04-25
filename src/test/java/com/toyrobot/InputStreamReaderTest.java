package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Unit test for simple App.
 */
public class InputStreamReaderTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InputStreamReaderTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InputStreamReaderTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testReadCommands() throws IOException {
        File path = new File(new File("").getAbsolutePath() + "/src/test/resources");
        for (File file : Objects.requireNonNull(path.listFiles())) {
            FileInputStream input = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(input);
            ArrayList<String> commands = reader.readCommands();
            assertEquals(Files.lines(Paths.get(file.getAbsolutePath())).count(), commands.size());
        }
    }

    public void testReadCommand() throws IOException, ToyRobotException {
        File path = new File(new File("").getAbsolutePath() + "/src/test/resources");
        for (File file : Objects.requireNonNull(path.listFiles())) {
            FileInputStream input = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(input);
            for (int i = 0; i < Files.lines(Paths.get(file.getAbsolutePath())).count(); i++) {
                assertNotNull(reader.getNextCommand());
            }
        }
    }
}
