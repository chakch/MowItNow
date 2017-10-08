package com.xebia.mow_it_now.model;

public interface IDirection {
    IDirection turnRight();
    IDirection turnLeft();
    Position move(Position position);
    OrientationType getType();

}
