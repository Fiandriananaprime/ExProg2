package robot;


public class Robot {

    private int x;
    private int y;
    private int direction;

    public Robot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Robot() {
        this(0, 0, 0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) { //
        if (x < -7 || x > 7) {
            throw new IllegalArgumentException("x should be between 0 and 7");
        }
        this.x = x;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        if (direction < 0 || direction > 3){
            throw new IllegalArgumentException("direction should be between 0 and 3");
        }
        this.direction = direction;
    }

    public int getY() { //get
        return y;
    }
    public void setY(int y) { // setter
        if (y < -7 || y > 7) {
            throw new IllegalArgumentException("y should be between 0 and 7");
        }
    }
    public void turnRight() {
        direction = (direction + 1) % 4;
    }

    public void moveForward() {
        switch (this.direction) {
           case 0 -> y++;
           case 1 -> x++;
           case 2 -> y--;
           case 3 -> x--;
        }
    }

    public String showPosition(int x, int y) {
        return "Position:" + x + "," + y;
    }
}