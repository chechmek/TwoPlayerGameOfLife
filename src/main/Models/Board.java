package main.Models;

import main.CellLogic.Cell;

public class Board {
    private Cell[][] map;
    public Board(int width, int height){
        map = new Cell[height][width];
    }
}
