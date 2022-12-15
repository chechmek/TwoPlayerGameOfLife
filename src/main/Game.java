package main;

import main.CellLogic.Cell;
import main.Models.Board;
import main.Models.GameSettings;
import main.Models.Player;
import main.UILogic.UI;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;

    public Game(GameSettings settings){
        board = new Board(settings.width, settings.height);
        board.addUI(settings.ui);
        player1 = new Player();
        player2 = new Player();
    }

    public void Start(){
        //ask player names
        // which symbol will be used
        // ui.setSymbols
        // sort players on alphabetical order
        //board.setUp() probably will make random
        while (true){
            board.render();

            //for both players
            // player.play // choose one to add, one to destroy
            board.nextGeneration();
            // board.checkIfWon

        }
    }
}
