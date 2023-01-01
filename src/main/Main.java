package main;

import main.Models.GameSettings;
import main.UILogic.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        GameSettings settings = new GameSettings();
        settings.setWidth(20);
        settings.setHeight(20);
        settings.setUi(new ConsoleUI());
        Game game = new Game(settings);
        game.Start();
    }
}