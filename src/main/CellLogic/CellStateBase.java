package main.CellLogic;

import java.util.List;

public abstract class CellStateBase implements CellState{
    protected CellMark mark;

    @Override
    public CellMark getMark() {
        return mark;
    }
}
