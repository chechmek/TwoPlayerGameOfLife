package main.CellLogic;

public interface CellState {
    void setPlayerOne();
    void setPlayerTwo();
    void setEmpty();
    CellMark getMark();
}
