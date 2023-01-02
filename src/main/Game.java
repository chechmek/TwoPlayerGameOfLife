package main;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Models.GameSettings;
import main.Models.Player;
import main.Static.Input;
import main.UILogic.ConsoleUI;
import main.UILogic.UI;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final Board board;
    private Player curPlayer;

    private final UI ui;

    public Game(GameSettings settings){
        board = new Board(settings.getWidth(), settings.getHeight());
        board.addUI(settings.getUi());
        ui = settings.getUi();
    }

    public void Start() {
        players.add(new Player(CellMark.PlayerOne));
        players.add(new Player(CellMark.PlayerTwo));
        // to delete
        players.get(0).setName("PlayerA");
        players.get(0).setSymbol("A");
        players.get(1).setName("PlayerB");
        players.get(1).setSymbol("B");
        //
        // sort players
        players.sort((o1, o2) -> {
            if (o1.getName().equals(o2.getName()))
                return 0;
            return o1.getName().compareTo(o2.getName());
        });

        try{
            ConsoleUI cui = (ConsoleUI)ui;
            cui.setSymbols(players.get(0).getSymbol(), players.get(1).getSymbol());
        }
        catch(Exception ex){
            System.out.println("Ui is not a console");
        }

        board.setUp(Boolean.FALSE);
        while (true){
            nextPlayer();
            board.render(curPlayer);

            try{
                if(checkIfWin())
                    break;
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
                break;
            }


            curPlayer.play(board);
            board.render(curPlayer);

            System.out.println("Press ENTER to see new generation!");
            Input.Wait();
            board.nextGeneration();
        }
    }

    private boolean checkIfWin() throws Exception {
        CellMark playerMark = board.getMarkOfWinningPlayer();
        if(playerMark == null)
            return false;

        for(var p : players)
            if(p.getPlayerMark() == playerMark){
                showWinningScreen(p);
                break;
            }

        return true;
    }

    private void nextPlayer(){
        if(curPlayer == null)
            curPlayer = players.get(0);
        else if(curPlayer == players.get(0))
            curPlayer = players.get(1);
        else if(curPlayer == players.get(1))
            curPlayer = players.get(0);
    }

    private void showWinningScreen(Player winningPlayer){
        System.out.println("=================================================");
        System.out.println("=================== " + winningPlayer.getName().toUpperCase() + " WON" + " ==================");
        System.out.println("=================================================");

    }
}
