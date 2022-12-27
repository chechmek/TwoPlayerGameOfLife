package main;

import main.Models.GameSettings;
import main.UILogic.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        GameSettings settings = new GameSettings();
        settings.width = 21;
        settings.height = 17;
        settings.ui = new ConsoleUI();
        Game game = new Game(settings);
        game.Start();
    }
}