package main.UILogic;

import main.BoardLogic.BoardHelper;
import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.Models.Pair;

import java.util.HashMap;

public class ConsoleUI implements UI{
    private final HashMap<CellMark, String> playerSymbols;
    private BoardHelper helper = new BoardHelper();

    public ConsoleUI(){
        playerSymbols = new HashMap<>();
        playerSymbols.put(CellMark.Empty, ".");
        playerSymbols.put(CellMark.PlayerOne, "1");
        playerSymbols.put(CellMark.PlayerTwo, "2");
    }

    public void setSymbols(String s1, String s2){
        playerSymbols.put(CellMark.PlayerOne, s1);
        playerSymbols.put(CellMark.PlayerTwo, s2);
    }
    @Override
    public void update(Cell[][] map, int generationCount) { //TODO number of cells

        System.out.println("Generations made:" + generationCount);
        Pair playersCellsCounts = helper.calculateNumberOfCells(map);
        System.out.println("Num of cells Player 1: " + playersCellsCounts.a + "\nNum of cells Player 2: " + playersCellsCounts.b);
        System.out.println("\n===== "  + "PlayerName(ToBeChanged)" + " =====");
        System.out.print("   ");
        for (int i = 0; i < map.length; i++){
            writeIndex(i);
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            writeIndex(i);
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(playerSymbols.get(map[i][j].state.getMark()) + "  ");
            }
        }
        System.out.println();
    }

    private void writeIndex(int i){
        if(i < 9)
            System.out.print(i + 1 + "  ");
        else
            System.out.print(i + 1 + " ");
    }
}
