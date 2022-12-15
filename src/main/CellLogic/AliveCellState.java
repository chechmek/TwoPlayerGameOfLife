package main.CellLogic;

import java.util.List;

public class AliveCellState extends CellStateBase{
    public AliveCellState(CellMark playerMark){
        mark = playerMark;
    }

    @Override
    public CellState getNewState(List<Cell> neighbours) {
        // if 2 or 3 neighbours stay alive
        return null;
    }
}
