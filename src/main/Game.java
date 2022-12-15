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
        //board.setUp()
        while (true){


            board.render();
        }
    }
}
