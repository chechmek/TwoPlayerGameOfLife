package main.BoardLogic;

import main.CellLogic.Cell;
import main.CellLogic.CellMark;
import main.Models.Pair;

import java.util.ArrayList;
import java.util.List;

public class BoardHelper {
    private final List<Pair> neighboursOffsets;
    public BoardHelper(){
        neighboursOffsets = new ArrayList<>();
        neighboursOffsets.add(new Pair(-1, 0));
        neighboursOffsets.add(new Pair(-1, 1));
        neighboursOffsets.add(new Pair(-1, -1));
        neighboursOffsets.add(new Pair(1, 0));
        neighboursOffsets.add(new Pair(1, 1));
        neighboursOffsets.add(new Pair(1, -1));
        neighboursOffsets.add(new Pair(0, 1));
        neighboursOffsets.add(new Pair(0, -1));
    }

    public List<Cell> getNeighbours(int i, int j, Cell[][] map){
        List<Cell> neighbours = new ArrayList<>();

        for(Pair p : neighboursOffsets){
            try {
                if(map[i + p.a][j + p.b].state.isAlive()){
                    neighbours.add(map[i + p.a][j + p.b]);
                }
            }
            catch (Exception ex){}
        }

        return neighbours;
    }

    public Pair calculateNumberOfCells(Cell[][] map){
        int counterPlayerOne = 0;
        int counterPlayerTwo = 0;

        for (Cell[] cells : map) {
            for (int j = 0; j < cells.length; j++) {
                if (cells[j].state.getMark() == CellMark.PlayerOne) {
                    counterPlayerOne++;
                } else if (cells[j].state.getMark() == CellMark.PlayerTwo) {
                    counterPlayerTwo++;
                }
            }
        }

        return new Pair(counterPlayerOne, counterPlayerTwo);
    }
}
