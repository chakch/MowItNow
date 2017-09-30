import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroudTest {
    Position maxPosition ;
    Lawnmover lawnmoverOne;
    Lawnmover lawnmoverTwo;
    String[] lawnmoverOneInstruction = "GAGAGAGAA".split("");
    String[] lawnmoverTwoInstruction = "AADAADADDA".split("");


    @Before
    public void GroudTest(){
        maxPosition = new Position(5,5);
        lawnmoverOne = new Lawnmover(new Position(1,2),new NorthDirection(),maxPosition);
        lawnmoverTwo = new Lawnmover(new Position(3,3),new EastDirection(),maxPosition);
    }
    @Test
    public void test(){


        applyInstructionToLawnMover(lawnmoverOne,lawnmoverOneInstruction);
        Assert.assertEquals(Integer.valueOf(3),lawnmoverOne.getPosition().getY());
        Assert.assertEquals(Integer.valueOf(1),lawnmoverOne.getPosition().getX());
        Assert.assertEquals(OrientationType.N,lawnmoverOne.getOrientation().getType());

    }
    @Test
    public void test1(){

        applyInstructionToLawnMover(lawnmoverTwo,lawnmoverTwoInstruction);
        Assert.assertEquals(Integer.valueOf(1),lawnmoverTwo.getPosition().getY());
        Assert.assertEquals(Integer.valueOf(5),lawnmoverTwo.getPosition().getX());
        Assert.assertEquals(OrientationType.E,lawnmoverTwo.getOrientation().getType());

    }

    private void applyInstructionToLawnMover(Lawnmover lawnmover,String[] instruction) {
        for(String s:instruction ){
            System.out.println(s);
            if(s.equals("D")|| s.equals("G")){
                lawnmover.rotate(s);
            }else if(s.equals("A")&&lawnmover.canMove()){
                lawnmover.move();
            }
            lawnmover.printInfo();
        }
    }
}
