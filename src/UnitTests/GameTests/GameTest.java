package GameTests;

import main.Models.GameSettings;
import main.UILogic.ConsoleUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void start() {
        GameSettings gameSettings = new GameSettings();
        gameSettings.height = 10;
        gameSettings.width = 10;
        gameSettings.ui = new ConsoleUI();
        assertEquals(10,gameSettings.height);
        assertEquals(10,gameSettings.width);
    }
}