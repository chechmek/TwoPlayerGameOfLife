package main.CellLogic;

import java.util.List;

public class Cell {
    public CellState state;
    public Cell(){
        state = new DeadCellState();
    }

    public Cell(CellState state){
        this.state = state;
    }
}
