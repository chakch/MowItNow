public class WestDirection extends Direction {


    public WestDirection() {
        super(OrientationType.W);
    }

    public Direction turnRight() {
        return new NorthDirection();
    }

    public Direction turnLeft() {
        return new SouthDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()-1),position.getY());
    }
}
