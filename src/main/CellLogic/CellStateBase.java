package main.CellLogic;

public class CellStateBase implements CellState{
    protected CellMark mark;
    public CellStateBase(CellMark mark){
        this.mark = mark;
    }
    public CellStateBase(){
        this.mark = CellMark.Empty;
    }

    @Override
    public void setPlayerOne() {
        mark = CellMark.PlayerOne;
    }

    @Override
    public void setPlayerTwo() {
        mark = CellMark.PlayerTwo;
    }

    @Override
    public void setEmpty() {
        mark = CellMark.Empty;
    }

    @Override
    public CellMark getMark() {
        return mark;
    }
}
