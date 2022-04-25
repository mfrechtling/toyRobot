package com.toyrobot;

import com.toyrobot.exception.ToyRobotException;
import com.toyrobot.interfaces.ICommandSet;

import java.util.StringTokenizer;

public class Command implements ICommandSet {
    public CommandType type;
    public Object[] params;

    public Position executeCommand(Position position) {
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
    }

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
            throw new ToyRobotException("FAILED TO CONVERT STRING COMMAND");
        }
    }
}
