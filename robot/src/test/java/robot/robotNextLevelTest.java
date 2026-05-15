package robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class robotNextLevelTest {

    @Test
    void stepBackTest() {
        var chatGpt = new robotNextLevel();
         chatGpt.stepBack();

         assertEquals(0, chatGpt.getX());
         assertEquals(-1, chatGpt.getY());

    }


    @Test
    void turnLeftTest() {
        var chatGpt = new robotNextLevel();
        chatGpt.turnLeft();

        assertEquals(3, chatGpt.getDirection());
    }
}