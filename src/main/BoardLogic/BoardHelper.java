package main.BoardLogic;

import main.CellLogic.Cell;
import main.Models.Pair;

import java.util.ArrayList;
import java.util.List;

public class BoardHelper {
    private List<Pair> neighboursOffsets;
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
}
