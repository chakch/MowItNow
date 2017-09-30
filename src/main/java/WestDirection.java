public class WestDirection extends Orientation {


    public WestDirection() {
        super("W");
    }

    public Orientation turnRight() {
        return new NorthDirection();
    }

    public Orientation turnLeft() {
        return new SouthDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()-1),position.getY());
    }
}
