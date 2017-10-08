package com.xebia.mow_it_now;

import com.xebia.mow_it_now.model.*;
import com.xebia.mow_it_now.service.Lawnmover;
import com.xebia.mow_it_now.service.LawnmoverCommand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LawnmoverTest {
    private Lawnmover lawnmover ;
    @Before
    public void setUp(){
        lawnmover = new Lawnmover(new Position(0,0),new NorthDirection(),new Position(1,1));
    }
    @Test
    public void checkLawmMoverInitialPosition(){
        Assert.assertEquals(Integer.valueOf(0), lawnmover.getPosition().getX());
        Assert.assertEquals(Integer.valueOf(0), lawnmover.getPosition().getY());
        Assert.assertEquals(OrientationType.N, lawnmover.getDirection().getType());
    }
    @Test
    public void changeLawmmDirectionToTheEast(){
        lawnmover.rotate(LawnmoverCommand.D);
        Assert.assertEquals(OrientationType.E, lawnmover.getDirection().getType());
    }
    @Test
    public void changeLawmmDirectionToTheWest(){
        lawnmover.rotate(LawnmoverCommand.G);
        Assert.assertEquals(OrientationType.W, lawnmover.getDirection().getType());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromD(){
        lawnmover.rotate(LawnmoverCommand.D);
        lawnmover.rotate(LawnmoverCommand.D);
        Assert.assertEquals(OrientationType.S, lawnmover.getDirection().getType());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromG(){
        lawnmover.rotate(LawnmoverCommand.G);
        lawnmover.rotate(LawnmoverCommand.G);
        Assert.assertEquals(OrientationType.S, lawnmover.getDirection().getType());
    }
    @Test
    public void changeLawmmDirectionFromNorthToNorth(){
        lawnmover.rotate(LawnmoverCommand.G);
        lawnmover.rotate(LawnmoverCommand.G);
        lawnmover.rotate(LawnmoverCommand.G);
        lawnmover.rotate(LawnmoverCommand.G);
        Assert.assertEquals(OrientationType.N, lawnmover.getDirection().getType());
    }
    @Test
    public void moveYDirectionByOne(){
        lawnmover.move();
        Assert.assertEquals(Integer.valueOf(1), lawnmover.getPosition().getY());
    }
    @Test
    public void moveXDirectionByOne(){
        lawnmover.rotate(LawnmoverCommand.D);
        lawnmover.move();
        Assert.assertEquals(Integer.valueOf(1), lawnmover.getPosition().getX());
    }

    @Test
    public void lawnmoverOrientationSouthReachLimitStayInPosition(){
        lawnmover= new Lawnmover(new Position(0,0),new SouthDirection(),new Position(1,1));
        Assert.assertFalse(lawnmover.canMove());
    }
    @Test
    public void lawnmoverNorthSouthReachLimitStayInPosition(){
        lawnmover= new Lawnmover(new Position(1,1),new NorthDirection(),new Position(1,1));
        Assert.assertFalse(lawnmover.canMove());
    }
    @Test
    public void lawnmoverOrientationEastReachLimitStayInPosition(){
        lawnmover= new Lawnmover(new Position(1,1),new EastDirection(),new Position(1,1));
        Assert.assertFalse(lawnmover.canMove());
    }
    @Test
    public void lawnmoverOrientationWestReachLimitStayInPosition(){
        lawnmover= new Lawnmover(new Position(0,0),new WestDirection(),new Position(1,1));
        Assert.assertFalse(lawnmover.canMove());
    }
}
