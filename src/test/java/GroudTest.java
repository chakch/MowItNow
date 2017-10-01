
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroudTest {
    private Position maxPosition ;
    private Lawnmover lawnmoverOne;
    private Lawnmover lawnmoverTwo;
    private char[] lawnmoverOneInstruction = "GAGAGAGAA".toCharArray();
    private char[] lawnmoverTwoInstruction = "AADAADADDA".toCharArray();



    @Test
    public void mowItNowGlobalTest(){
        maxPosition = new Position(5,5);
        lawnmoverOne = new Lawnmover(new Position(1,2),new NorthDirection(),maxPosition);
        lawnmoverTwo = new Lawnmover(new Position(3,3),new EastDirection(),maxPosition);

        applyInstructionToLawnMover(lawnmoverOne,lawnmoverOneInstruction);
        Assert.assertEquals(Integer.valueOf(3),lawnmoverOne.getPosition().getY());
        Assert.assertEquals(Integer.valueOf(1),lawnmoverOne.getPosition().getX());
        Assert.assertEquals(OrientationType.N,lawnmoverOne.getDirection().getType());

        applyInstructionToLawnMover(lawnmoverTwo,lawnmoverTwoInstruction);
        Assert.assertEquals(Integer.valueOf(1),lawnmoverTwo.getPosition().getY());
        Assert.assertEquals(Integer.valueOf(5),lawnmoverTwo.getPosition().getX());
        Assert.assertEquals(OrientationType.E,lawnmoverTwo.getDirection().getType());

    }

    private void applyInstructionToLawnMover(Lawnmover lawnmover,char[] instruction) {
        for(char s:instruction ){
            lawnmover.command(InputCommand.valueOf(String.valueOf(s)));
        }
        lawnmover.printInfo();
    }
}
