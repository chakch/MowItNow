public class SouthDirection extends Direction {


    public SouthDirection() {
        super(OrientationType.S);
    }

    public Direction turnLeft() {
        return new EastDirection();
    }

    public Direction turnRight() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX(),Integer.valueOf(position.getY()-1));
    }
}
