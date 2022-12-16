package main.UILogic;

import main.CellLogic.Cell;
import main.CellLogic.CellMark;

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
    }

    @Override
    public void update(Cell[][] map, int generationCount) {

    }
}
