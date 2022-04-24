package com.toyrobot;

public class Position {
    private int x;
    private int y;
    private Direction direction;

    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
        this.direction = position.direction;
    }

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void turnLeft() {
        this.direction = this.direction.left();
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public void move() {
        switch (this.direction) {
            case NORTH:
                changePosition(0, 1);
                break;
            case EAST:
                changePosition(1, 0);
                break;
            case SOUTH:
                changePosition(0, -1);
                break;
            case WEST:
                changePosition(-1, 0);
                break;
        }
    }

    private void changePosition(int shiftX, int shiftY) {
        this.x += shiftX;
        this.y += shiftY;
    }
}
