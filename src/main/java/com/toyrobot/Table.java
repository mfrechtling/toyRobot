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

    /**
     * Test if a position is within the boundary of the current table configuration
     *
     * @param position the position to test
     * @return True if the position is valid, otherwise false
     */
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
