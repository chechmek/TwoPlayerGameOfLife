package main;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Models.GameSettings;
import main.Models.Player;
import main.Static.Input;
import main.UILogic.ConsoleUI;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private Board board;
    private Player curPlayer;

    private UI ui;

    public Game(GameSettings settings){
        board = new Board(settings.width, settings.height);
        board.addUI(settings.ui);
        ui = settings.ui;
    }

    public void Start() {
        players.add(new Player(CellMark.PlayerOne));
        players.add(new Player(CellMark.PlayerTwo));
        for(Player p : players){
            //p.name = Input.GetPlayerName();
            //p.symbol = Input.GetPlayerSymbol();
        }
        // to delete
        players.get(0).name = "PlayerA";
        players.get(0).symbol = "A";
        players.get(1).name = "PlayerB";
        players.get(1).symbol = "B";
        //
        // sort players
        players.sort(new Comparator<>() {
            public int compare(Player o1, Player o2) {
                if (o1.name.equals(o2.name))
                    return 0;
                return o1.name.compareTo(o2.name);
            }
        });

        try{
            ConsoleUI cui = (ConsoleUI)ui;
            cui.setSymbols(players.get(0).symbol, players.get(1).symbol);
        }
        catch(Exception ex){
            System.out.println("Ui is not a console");
        }

        board.setUp(); //probably will make random//TODO
        while (true){
            nextPlayer();


            // player.play // choose one to add, one to destroy
            board.render();
            curPlayer.play(board);
            //TimeUnit.MILLISECONDS.sleep(50);

            board.render();
            System.out.println("Press ENTER to see new generation!");
            Input.Wait();

            board.nextGeneration();
            // board.checkIfWon//TODO

        }
    }

    private void nextPlayer(){
        if(curPlayer == null)
            curPlayer = players.get(0);
        else if(curPlayer == players.get(0))
            curPlayer = players.get(1);
        else if(curPlayer == players.get(1))
            curPlayer = players.get(0);
    }
}
