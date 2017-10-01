
import java.text.MessageFormat;

public class Lawnmover {

    public static final String LAWNMOVER_INFORMATION = "Position (x:{0},y:{1}), Orientation:{2}";
    private Position position;
    private IDirection direction;

    private Position lowerLimit = new Position(0,0) ;
    private Position upperLimit ;


    public  Lawnmover(Position position, IDirection direction, Position upperLimit){
        this.position =position;
        this.direction = direction;
        this.upperLimit =upperLimit;
    }

    public Integer getXPosition(){
        return position.getX();
    }
    public Integer getYPosition(){
        return position.getY();
    }
    public IDirection getDirection(){
        return direction;
    }

    public void rotate(InputCommand inputCommand) {
        if (InputCommand.D.equals(inputCommand)){
           direction = direction.turnRight();
        }else if (InputCommand.G.equals(inputCommand)){
            direction = direction.turnLeft();
        }
    }

    public void move(){
        position = direction.move(position);
    }

    public void command(InputCommand inputCommand){
        if (inputCommand.equals(inputCommand.A)) {
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
        System.out.println(MessageFormat.format(LAWNMOVER_INFORMATION,position.getX(),getYPosition(), direction.getType()));
    }


}
