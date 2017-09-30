public abstract class Direction {

    protected  OrientationType type;

    public Direction(OrientationType type){
        this.type = type;
    }
    public abstract Direction turnRight();
    public abstract Direction turnLeft();

    public abstract Position move(Position position);
    public OrientationType getType(){
        return type;
    }

}
