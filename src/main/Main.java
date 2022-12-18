package main;

import main.Models.GameSettings;
import main.UILogic.ConsoleUI;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GameSettings settings = new GameSettings();
        settings.width = 20;
        settings.height = 20;
        settings.ui = new ConsoleUI();
        Game game = new Game(settings);
        game.Start();
    }
}