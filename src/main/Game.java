package main;

import main.Models.Board;
import main.Models.GameSettings;
import main.Models.Player;
import main.Static.Input;
import main.UILogic.ConsoleUI;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Board board;
    private Player curPlayer;

    private UI ui;

    public Game(GameSettings settings){
        board = new Board(settings.width, settings.height);
        board.addUI(settings.ui);
        ui = settings.ui;
    }

    public void Start(){
        players.add(new Player());
        players.add(new Player());
        for(Player p : players){
            p.name = Input.GetPlayerName();
            p.symbol = Input.GetPlayerSymbol();
        }
        // sort players
        Collections.sort(players, new Comparator<Player>(){
            public int compare(Player o1, Player o2){
                if(o1.name == o2.name)
                    return 0;
                return o1.name.compareTo(o2.name);
            }
        });

        try{
            ConsoleUI cui = (ConsoleUI)ui;
            cui.setSymbols(players.get(0).symbol, players.get(1).symbol);
        }
        catch(Exception ex){}

        //board.setUp() probably will make random//TODO
        while (true){
            nextPlayer();
            board.render();//TODO

            // player.play // choose one to add, one to destroy
            curPlayer.play();//TODO

            board.nextGeneration();//TODO
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
