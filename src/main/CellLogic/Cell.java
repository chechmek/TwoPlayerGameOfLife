package main.CellLogic;

import java.util.List;

public class Cell {
    public CellState state;
    public Cell(){
        state = new DeadCellState();
    }

    public void Handle(List<Cell> neighbours){
        state = state.getNewState(neighbours);
    }
}
