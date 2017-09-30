public abstract class Orientation {

    protected  String code;

    public Orientation(String code){
        this.code = code;
    }
    public abstract Orientation turnRight();
    public abstract Orientation turnLeft();

    public abstract Position move(Position position);
    public String getCode(){
        return code;
    }


}
