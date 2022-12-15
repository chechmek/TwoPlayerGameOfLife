package main.CellLogic;

import java.util.List;

public class DeadCellState extends CellStateBase{
    public DeadCellState(){
        mark = CellMark.Empty;
    }

    @Override
    public CellState getNewState(List<Cell> neighbours) {
        // if 3 neighbours set alive state of player
        return null;
    }
}
