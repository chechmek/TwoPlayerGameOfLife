package main.CellLogic;

public class Cell {
    private CellState state;


    public Cell(CellState state){
        this.setState(state);
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
