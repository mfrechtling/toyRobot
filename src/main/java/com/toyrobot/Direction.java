package com.toyrobot;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);

    Direction(int index) {
        this.index = index;
    }

    private final int index;
    private static final Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    static {
        for (Direction direction : Direction.values()) {
            map.put(direction.index, direction);
        }
    }

    public Direction left() {
        return rotate(-1);
    }

    public Direction right() {
        return rotate(1);
    }

    private Direction rotate(int shift) {
        int index = (this.index + shift) < 0 ? map.size() - 1 : (this.index + shift) % map.size();
        return map.get(index);
    }

}
