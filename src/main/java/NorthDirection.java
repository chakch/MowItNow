public class NorthDirection extends Orientation {


    public NorthDirection() {
        super("N");
    }

    public Orientation turnRight() {
        return new EastDirection();
    }

    public Orientation turnLeft() {
        return new WestDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()),position.getY()+1);
    }

}
