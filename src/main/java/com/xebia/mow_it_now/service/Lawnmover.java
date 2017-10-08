package com.xebia.mow_it_now.service;

import com.xebia.mow_it_now.model.IDirection;
import com.xebia.mow_it_now.model.OrientationType;
import com.xebia.mow_it_now.model.Position;

import java.text.MessageFormat;

public class Lawnmover {

    private static final String LAWNMOVER_INFORMATION = "com.xebia.mow_it_now.model.Position (x:{0},y:{1}), Orientation:{2}";
    private Position position;
    private IDirection direction;

    private final Position lowerLimit = new Position(0,0) ;
    private final Position upperLimit ;


    public  Lawnmover(Position position, IDirection direction, Position upperLimit){
        this.position =position;
        this.direction = direction;
        this.upperLimit =upperLimit;
    }

    public IDirection getDirection(){
        return direction;
    }

    public void rotate(LawnmoverCommand inputCommand) {
        if (LawnmoverCommand.D.equals(inputCommand)){
           direction = direction.turnRight();
        }else if (LawnmoverCommand.G.equals(inputCommand)){
            direction = direction.turnLeft();
        }
    }

    public void move(){
        position = direction.move(position);
    }

    public void command(LawnmoverCommand inputCommand){
        if (inputCommand.equals(LawnmoverCommand.A)) {
            if(canMove()){
                move();
            }
        }else{
            rotate(inputCommand);
        }
    }

    public Boolean canMove(){
        if(direction.getType().equals(OrientationType.S)){
            return position.getY()> lowerLimit.getY();
        }
        if(direction.getType().equals(OrientationType.N)){
            return position.getY()< upperLimit.getY();
        }
        if(direction.getType().equals(OrientationType.W)){
            return position.getX()> lowerLimit.getX();
        }
        if(direction.getType().equals(OrientationType.E)){
            return position.getX()< upperLimit.getX();
        }
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public void  printInfo(){
        System.out.println(MessageFormat.format(LAWNMOVER_INFORMATION,position.getX(),position.getY(), direction.getType()));
    }


}
