package main.UILogic;

import main.CellLogic.Cell;
import main.Models.Player;

public interface UI {
    void update(Cell[][] map, int generationCount, Player player);
}
