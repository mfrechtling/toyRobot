package com.toyrobot;

public interface ICommander {
    public void readCommand();

    public void readCommands();

    public Command getNextCommand();
}
