package com.toyrobot;

import com.toyrobot.exception.CommandException;

import java.util.StringTokenizer;

public class Command {
    public CommandType type;
    public Object[] params;

    public Command(String command) throws CommandException {
        StringTokenizer stringTokenizer = new StringTokenizer(command, ":, ");
        try {
            this.type = CommandType.valueOf(stringTokenizer.nextToken().toUpperCase());
            if (type == CommandType.PLACE) {
                params = new Object[3];
                params[0] = Integer.parseInt(stringTokenizer.nextToken());
                params[1] = Integer.parseInt(stringTokenizer.nextToken());
                params[2] = Direction.valueOf(stringTokenizer.nextToken().toUpperCase());
            }
        } catch (IllegalArgumentException e) {
            throw new CommandException("FAILED TO CONVERT STRING COMMAND");
        }
    }
}
