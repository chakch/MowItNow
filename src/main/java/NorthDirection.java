public class NorthDirection extends Direction {


    public NorthDirection() {
        super(OrientationType.N);
    }

    public Direction turnRight() {
        return new EastDirection();
    }

    public Direction turnLeft() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()),position.getY()+1);
    }

}
