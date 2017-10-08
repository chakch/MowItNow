package com.xebia.mow_it_now.model;

public class NorthDirection extends Direction {


    public NorthDirection() {
        super(OrientationType.N);
    }

    public IDirection turnRight() {
        return new EastDirection();
    }

    public IDirection turnLeft() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX(),position.getY()+1);
    }

}
