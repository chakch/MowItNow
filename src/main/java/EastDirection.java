import javafx.geometry.Pos;
import sun.tools.jconsole.InternalDialog;

public class EastDirection extends Orientation {


    public EastDirection() {
        super("E");
    }

    public Orientation turnRight() {
        return new SouthDirection();
    }

    public Orientation turnLeft() {
        return  new NorthDirection();
    }

    public Position move(Position position) {
        return new Position(Integer.valueOf(position.getX()+1),position.getY());
    }

}
