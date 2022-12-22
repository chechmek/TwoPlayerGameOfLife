package main.Models;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Static.Input;

import java.util.Scanner;

public class Player {
    public String name;
    public String symbol;
    private final Scanner input = new Scanner(System.in);
    public CellMark playerMark;
    public Player(CellMark mark){
        playerMark = mark;
    }
    public void play(Board board){
        System.out.println("Type coordinate in one line: a, b  \nExample: 11, 14");
        System.out.println("Create cell:");
        boolean got = false;
        while (!got) {
            try {
                Coordinate coord = Input.getCoordinate(board);
                board.aliveCell(coord.x, coord.y, playerMark);
                got = true;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        got = false;

        System.out.println("Delete cell:");
        while (!got) {
            try {
                Coordinate coord = Input.getCoordinate(board);
                board.killCellOn(coord.x, coord.y, playerMark);
                got = true;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
