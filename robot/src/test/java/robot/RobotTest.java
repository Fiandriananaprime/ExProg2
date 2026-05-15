package robot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    void testInitialPositionDefaultConstructor() {
        Robot robot = new Robot();

        assertEquals(0, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    void testInitialPositionCustomConstructor() {
        Robot robot = new Robot(5, 10, 0);

        assertEquals(5, robot.getX());
        assertEquals(10, robot.getY());
    }

    @Test
    void testMoveForwardNorth() {
        Robot robot = new Robot(0, 0, 0); // direction 0 = nord

        robot.moveForward();

        assertEquals(0, robot.getX());
        assertEquals(1, robot.getY());
    }

    @Test
    void testMoveForwardEast() {
        Robot robot = new Robot(0, 0, 1); // est

        robot.moveForward();

        assertEquals(1, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    void testMoveForwardSouth() {
        Robot robot = new Robot(0, 0, 2); // sud

        robot.moveForward();

        assertEquals(0, robot.getX());
        assertEquals(-1, robot.getY());
    }

    @Test
    void testMoveForwardWest() {
        Robot robot = new Robot(0, 0, 3); // ouest

        robot.moveForward();

        assertEquals(-1, robot.getX());
        assertEquals(0, robot.getY());
    }

    @Test
    void testTurnRight() {
        Robot robot = new Robot(0, 0, 0);

        robot.turnRight(); // 0 -> 1
        robot.turnRight(); // 1 -> 2

        robot.moveForward();

        // direction 2 = sud donc y diminue
        assertEquals(0, robot.getX());
        assertEquals(-1, robot.getY());
    }

    @Test
    void testShowPosition(){
        Robot robot = new Robot(0,0,0);

        robot.turnRight();
        robot.turnRight();
        robot.moveForward();

        String expectedOutput = "Position:0,-1";
        assertEquals(expectedOutput, robot.showPosition(robot.getX(),robot.getY()));
    }

    
}