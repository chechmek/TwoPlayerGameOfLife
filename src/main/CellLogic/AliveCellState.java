package main.CellLogic;

import java.util.List;

public class AliveCellState extends CellStateBase{
    public AliveCellState(CellMark playerMark){
        mark = playerMark;
    }

    @Override
    public CellState getNewState(List<Cell> neighbours) {
        // if 2 or 3 neighbours stay alive
        if(neighbours.size() == 2 || neighbours.size() == 3)
            return this;

        return new DeadCellState();
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}
