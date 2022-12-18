package main.UILogic;

import main.CellLogic.Cell;

public interface UI {
    void update(Cell[][] map, int generationCount);
}
