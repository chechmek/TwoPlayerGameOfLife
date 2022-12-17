package main.Models;

import main.CellLogic.CellMark;
import main.Static.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {
    public String name;
    public String symbol;
    // TODO What is first, delete or add?
    // also need to check if playermark is correct
    public void play(Board board, CellMark playerMark){
        System.out.println("Create cell:");
        int[] coord = Input.GetPlayerCoord();
        board.aliveCell(coord[0],coord[1],playerMark);
        System.out.println("Delete cell:");
        coord = Input.GetPlayerCoord();
        board.killCellOn(coord[0],coord[1]);

    }
}
