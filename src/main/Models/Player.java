package main.Models;

import main.CellLogic.CellMark;
import main.Static.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public String symbol;
    public void play(Board board, CellMark playerMark){ // TODO What is first, delete or add?
        System.out.println("Create cell:");
        int[] coord = Input.GetPlayerCoord();
        board.aliveCell(coord[0],coord[1],playerMark);
        System.out.println("Delete cell:");
        coord = Input.GetPlayerCoord();
        board.killCellOn(coord[0],coord[1]);

    }
}
