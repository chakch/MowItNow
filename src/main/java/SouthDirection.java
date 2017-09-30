public class SouthDirection extends Orientation {


    public SouthDirection() {
        super("S");
    }

    public Orientation turnLeft() {
        return new EastDirection();
    }

    public Orientation turnRight() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(position.getX(),Integer.valueOf(position.getY()-1));
    }
}
