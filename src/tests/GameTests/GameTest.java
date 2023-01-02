package tests.GameTests;

import main.Models.GameSettings;
import main.UILogic.ConsoleUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void start() {
        GameSettings gameSettings = new GameSettings();
        gameSettings.setHeight(10);
        gameSettings.setWidth(10);
        gameSettings.setUi(new ConsoleUI());
        assertEquals(10, gameSettings.getHeight());
        assertEquals(10, gameSettings.getWidth());
    }
}