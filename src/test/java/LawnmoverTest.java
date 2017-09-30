import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class LawnmoverTest {
    Lawnmover lawnmover ;
    @Before
    public void setUp(){
        lawnmover = new Lawnmover(new Position(0,0),new NorthDirection(),new Position(1,1));
    }
    @Test
    public void checkLawmMoverInitialPosition(){
        Assert.assertEquals(Integer.valueOf(0), lawnmover.getXPosition());
        Assert.assertEquals(Integer.valueOf(0), lawnmover.getYPosition());
        Assert.assertEquals(OrientationType.N, lawnmover.getOrientation().getType());
    }
    @Test
    public void changeLawmmDirectionToTheEast(){
        lawnmover.rotate("D");
        Assert.assertEquals(OrientationType.E, lawnmover.getOrientation().getType());
    }
    @Test
    public void changeLawmmDirectionToTheWest(){
        lawnmover.rotate("G");
        Assert.assertEquals(OrientationType.W, lawnmover.getOrientation().getType());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromD(){
        lawnmover.rotate("D");
        lawnmover.rotate("D");
        Assert.assertEquals(OrientationType.S, lawnmover.getOrientation().getType());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromG(){
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        Assert.assertEquals(OrientationType.S, lawnmover.getOrientation().getType());
    }
    @Test
    public void changeLawmmDirectionFromNorthToNorth(){
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        Assert.assertEquals(OrientationType.N, lawnmover.getOrientation().getType());
    }
    @Test
    public void moveYDirectionByOne(){
        lawnmover.move();
        Assert.assertEquals(Integer.valueOf(1), lawnmover.getYPosition());
    }
    @Test
    public void moveXDirectionByOne(){
        lawnmover.rotate("D");
        lawnmover.move();
        Assert.assertEquals(Integer.valueOf(1), lawnmover.getXPosition());
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
