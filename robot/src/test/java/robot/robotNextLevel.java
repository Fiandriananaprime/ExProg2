package robot;

public class robotNextLevel  extends Robot { //Heritage
    
    private boolean turbo;

    public robotNextLevel(int x, int y, int direction) {
        super(x, y, direction);
    }
    robotNextLevel() {
        super();
        this.turbo = true;
    }
    public void stepBack(){
        turnRight();
        turnRight();
        moveForward();
        turnRight();
        turnRight();
    }

    public void turnLeft(){
        turnRight();
        turnRight();
        turnRight();
    }
}
