package main.CellLogic;

import java.util.List;

public interface CellState {
    CellState getNewState(List<Cell> neighbours);
    CellMark getMark();
    boolean isAlive();
}
