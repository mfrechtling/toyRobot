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

    /**
     * Return the current X value of the position
     *
     * @return Integer value of X
     */
    public int getX() {
        return this.x;
    }

    /**
     * Return the current Y value of the position
     *
     * @return Integer value of Y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Return the current Direction of the position
     *
     * @return Direction
     */
    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Rotate the position left
     */
    public void turnLeft() {
        this.direction = this.direction.left();
    }

    /**
     * Rotate the position right
     */
    public void turnRight() {
        this.direction = this.direction.right();
    }

    /**
     * Move the position one unit in the current direction
     */
    public void move() {
        this.move(1);
    }

    /**
     * Move the position in the current direction
     *
     * @param movement the amount to move the position
     */
    public void move(int movement) {
        switch (this.direction) {
            case NORTH:
                changePosition(0, movement);
                break;
            case EAST:
                changePosition(movement, 0);
                break;
            case SOUTH:
                changePosition(0, -movement);
                break;
            case WEST:
                changePosition(-movement, 0);
                break;
        }
    }

    private void changePosition(int shiftX, int shiftY) {
        this.x += shiftX;
        this.y += shiftY;
    }
}
