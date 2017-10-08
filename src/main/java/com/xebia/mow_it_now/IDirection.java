package com.xebia.mow_it_now;

public interface IDirection {
    IDirection turnRight();
    IDirection turnLeft();
    Position move(Position position);
    OrientationType getType();

}
