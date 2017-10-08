package com.xebia.mow_it_now.model;

public abstract class Direction implements IDirection {

    private final OrientationType type;

    public Direction(OrientationType type){
        this.type = type;
    }
    public abstract IDirection turnRight();
    public abstract IDirection turnLeft();

    public abstract Position move(Position position);
    public OrientationType getType(){
        return type;
    }

}
