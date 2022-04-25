package com.toyrobot;

public class Table {
    public int height;
    public int width;

    public Table(int width, int height) {
        if (width < 0 || height < 0) throw new IllegalArgumentException("Size of table must be greater than zero");
        this.width = width;
        this.height = height;
    }

    public Table(int size) {
        if (size < 0) throw new IllegalArgumentException("Size of table must be greater than zero");
        this.width = size;
        this.height = size;
    }

    public boolean positionIsValid(Position position) {
        if (position == null) return false;
        if (position.getX() < minWidth() || position.getX() > maxWidth()) return false;
        return position.getY() >= minHeight() && position.getY() <= maxHeight();
    }

    private int maxWidth() {
        return this.width - 1;
    }

    private int minWidth() {
        return 0;
    }

    private int maxHeight() {
        return this.height - 1;
    }

    private int minHeight() {
        return 0;
    }
}
