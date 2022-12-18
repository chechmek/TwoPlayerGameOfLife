package main.UILogic;

import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.Models.Board;
import main.Models.Player;

import java.util.HashMap;

public class ConsoleUI implements UI{
    private HashMap<String, String> playerSymbols;

    public ConsoleUI(){
        playerSymbols = new HashMap<>();
        playerSymbols.put(CellMark.Empty.toString(), "0");
        playerSymbols.put(CellMark.PlayerOne.toString(), "1");
        playerSymbols.put(CellMark.PlayerTwo.toString(), "2");
    }

    public void setSymbols(String s1, String s2){
        playerSymbols.put(CellMark.PlayerOne.toString(), s1);
        playerSymbols.put(CellMark.PlayerTwo.toString(), s2);
        System.out.println(playerSymbols.get(CellMark.Empty.toString()));
        System.out.println(playerSymbols.get(CellMark.PlayerOne.toString()));
        System.out.println(playerSymbols.get(CellMark.PlayerTwo.toString()));
    }
    @Override
    public void updateUI(Cell[][] map, int generationCount, Board board) { //TODO number of cells
        System.out.println("Generations made:" + generationCount);
        int Cells[]=board.calculateCells(map);
        System.out.println("Num of cells Player1" + Cells[0] + "Num of cells Player2" + Cells[1]);
        System.out.print("\n===== "  + "PlayerName(ToBeChanged)" + " =====\n");
        for (int i = 0; i < map.length; i++){
            System.out.print(" " + i + " ");
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println();
            System.out.print(i + " ");
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].state.getMark() == CellMark.Empty) {
                    System.out.println(playerSymbols.get(CellMark.Empty.toString()));
                } else if (map[i][j].state.getMark() == CellMark.PlayerOne) {
                    System.out.println(playerSymbols.get(CellMark.PlayerOne.toString()));
                } else if (map[i][j].state.getMark() == CellMark.PlayerTwo) {
                    System.out.println(playerSymbols.get(CellMark.PlayerTwo.toString()));
                }
            }
        }
    }
}
