package main.BoardLogic;

import main.CellLogic.*;
import main.Models.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
                if(map[i + p.getA()][j + p.getB()].getState().isAlive()){
                    neighbours.add(map[i + p.getA()][j + p.getB()]);
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
                if (cells[j].getState().getMark() == CellMark.PlayerOne) {
                    counterPlayerOne++;
                } else if (cells[j].getState().getMark() == CellMark.PlayerTwo) {
                    counterPlayerTwo++;
                }
            }
        }

        return new Pair(counterPlayerOne, counterPlayerTwo);
    }

    public Cell[][] mirrorMapHorizontally(Cell[][] initMap) throws Exception {
        if(initMap == null)
            throw new Exception("Cannot mirror, the map is null");
        if(initMap.length == 0)
            throw new Exception("Cannot mirror, the map is empty");
        if(initMap.length % 2 != 0)
            throw new Exception("Cannot mirror, the map width is not even");

        Stack<Cell> buffer = new Stack<>();
        Cell[][] mirroredMap = new Cell[initMap.length][initMap[0].length];
        int mirrorLineIndex = initMap[0].length / 2;

        for(int i = 0; i < initMap.length; i++){
            for(int j = 0; j < initMap[i].length; j++){
                if(j < mirrorLineIndex){
                    buffer.push(initMap[i][j]);
                    mirroredMap[i][j] = new Cell(initMap[i][j].getState());
                }
                else {
                    CellState newState = buffer.pop().getState();
                    if(newState.isAlive()){
                        AliveCellState aliveCellState = (AliveCellState)newState;
                        mirroredMap[i][j] = new Cell(aliveCellState.getOppositePlayerState());
                    }
                    else{
                        mirroredMap[i][j] = new Cell(new DeadCellState());
                    }
                }
            }
        }

        return  mirroredMap;
    }
}
