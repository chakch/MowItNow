package com.xebia.mow_it_now;

public class EastDirection extends Direction {


    public EastDirection() {
        super(OrientationType.E);
    }

    public IDirection turnRight() {
        return new SouthDirection();
    }

    public IDirection turnLeft() {
        return  new NorthDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX()+1,position.getY());
    }

}
