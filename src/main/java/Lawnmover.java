import java.text.MessageFormat;

public class Lawnmover {

    private Position position;
    private Direction orientation;

    private Position lowerLimit = new Position(0,0) ;
    private Position upperLimit ;


    public  Lawnmover(Position position, Direction orientation, Position upperLimit){
        this.position =position;
        this.orientation = orientation;
        this.upperLimit =upperLimit;
    }

    public Integer getXPosition(){
        return position.getX();
    }
    public Integer getYPosition(){
        return position.getY();
    }
    public Direction getOrientation(){
        return orientation;
    }

    public void rotate(String d) {
        if ("D".equals(d)){
           orientation= orientation.turnRight();
        }else if ("G".equals(d)){
            orientation= orientation.turnLeft();
        }
    }

    public void move(){
        position =orientation.move(position);
    }

    public Boolean canMove(){
        if(orientation.getType().equals(OrientationType.S)){
            return position.getY()> lowerLimit.getY();
        }
        if(orientation.getType().equals(OrientationType.N)){
            return position.getY()< upperLimit.getY();
        }
        if(orientation.getType().equals(OrientationType.W)){
            return position.getX()> lowerLimit.getX();
        }
        if(orientation.getType().equals(OrientationType.E)){
            return position.getX()< upperLimit.getX();
        }
        return true;
    }

    public Position getPosition() {
        return position;
    }

    public void  printInfo(){
        System.out.println(MessageFormat.format("Position (x:{0},y:{1}), Direction:{2}",position.getX(),getYPosition(),orientation.getType()));
    }
}
