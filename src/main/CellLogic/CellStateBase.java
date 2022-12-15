package main.CellLogic;

public abstract class CellStateBase implements CellState{
    protected CellMark mark;
    public CellStateBase(CellMark mark){
        this.mark = mark;
    }
    public CellStateBase(){
        this.mark = CellMark.Empty;
    }
}
