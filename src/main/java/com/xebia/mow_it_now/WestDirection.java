package com.xebia.mow_it_now;

public class WestDirection extends Direction {


    public WestDirection() {
        super(OrientationType.W);
    }

    public IDirection turnRight() {
        return new NorthDirection();
    }

    public IDirection turnLeft() {
        return new SouthDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX()-1,position.getY());
    }
}
