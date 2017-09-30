public class EastDirection extends Direction {


    public EastDirection() {
        super(OrientationType.E);
    }

    public Direction turnRight() {
        return new SouthDirection();
    }

    public Direction turnLeft() {
        return  new NorthDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()+1),position.getY());
    }

}
