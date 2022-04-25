package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandSet;

import java.util.StringTokenizer;

public class Command implements ICommandSet {
    public CommandType type;
    public Object[] params;

    public Command() {

    }

    public Command(String commandText) throws ToyRobotException {
        this.parseCommand(commandText);
    }

    /**
     * The execute function will perform any required actions of the command, and produce an updated
     * position if necessary
     *
     * @param position ToyRobot position
     * @return position updated ToyRobot position
     * @throws ToyRobotException
     */
    public Position executeCommand(Position position) throws ToyRobotException {
        try {
            switch (this.type) {
                case PLACE:
                    return new Position((int) params[0], (int) params[1], (Direction) params[2]);
                case MOVE:
                    if (position == null) return null;
                    position.move();
                    return position;
                case LEFT:
                    if (position == null) return null;
                    position.turnLeft();
                    return position;
                case RIGHT:
                    if (position == null) return null;
                    position.turnRight();
                    return position;
                case REPORT:
                    if (position == null) return null;
                    System.out.printf("%d, %d, %s\n", position.getX(), position.getY(), position.getDirection());
                    return position;
                default:
                    return position;
            }
        } catch (Exception ex) {
            throw new ToyRobotException("Failed to execute command: " + type.name());
        }
    }

    /**
     * Parse an input string to generate command type and parameters
     *
     * @param command String containing text of the command
     * @throws ToyRobotException
     */
    public void parseCommand(String command) throws ToyRobotException {
        StringTokenizer stringTokenizer = new StringTokenizer(command, ":, ");
        try {
            this.type = CommandType.valueOf(stringTokenizer.nextToken().toUpperCase());
            if (type == CommandType.PLACE) {
                params = new Object[3];
                params[0] = Integer.parseInt(stringTokenizer.nextToken());
                params[1] = Integer.parseInt(stringTokenizer.nextToken());
                params[2] = Direction.valueOf(stringTokenizer.nextToken().toUpperCase());
            }
        } catch (Exception ex) {
            throw new ToyRobotException("Failed to convert input string to valid command");
        }
    }
}
