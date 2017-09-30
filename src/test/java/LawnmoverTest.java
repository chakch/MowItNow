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
        Assert.assertEquals("N", lawnmover.getOrientation().getCode());
    }
    @Test
    public void changeLawmmDirectionToTheEast(){
        lawnmover.rotate("D");
        Assert.assertEquals("E", lawnmover.getOrientation().getCode());
    }
    @Test
    public void changeLawmmDirectionToTheWest(){
        lawnmover.rotate("G");
        Assert.assertEquals("W", lawnmover.getOrientation().getCode());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromD(){
        lawnmover.rotate("D");
        lawnmover.rotate("D");
        Assert.assertEquals("S", lawnmover.getOrientation().getCode());
    }
    @Test
    public void changeLawmmDirectionToTheSouthFromG(){
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        Assert.assertEquals("S", lawnmover.getOrientation().getCode());
    }
    @Test
    public void changeLawmmDirectionFromNorthToNorth(){
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        lawnmover.rotate("G");
        Assert.assertEquals("N", lawnmover.getOrientation().getCode());
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
