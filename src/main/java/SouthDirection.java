
public class SouthDirection extends Direction {


    public SouthDirection() {
        super(OrientationType.S);
    }

    public IDirection turnLeft() {
        return new EastDirection();
    }

    public IDirection turnRight() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX(),position.getY()-1);
    }
}
