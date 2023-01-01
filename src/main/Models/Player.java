package main.Models;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;
import main.Static.Input;

import java.util.Scanner;

public class Player {
    private String name;
    private String symbol;
    private final Scanner input = new Scanner(System.in);
    private CellMark playerMark;
    public Player(CellMark mark){
        setPlayerMark(mark);
    }
    public void play(Board board){
        System.out.println("Type coordinate in one line: a, b  \nExample: 11, 14");
        System.out.println("Create cell:");
        boolean got = false;
        while (!got) {
            try {
                Coordinate coord = Input.getCoordinate(board);
                board.aliveCell(coord.getX(), coord.getY(), getPlayerMark());
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
                board.killCellOn(coord.getX(), coord.getY(), getPlayerMark());
                got = true;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public CellMark getPlayerMark() {
        return playerMark;
    }

    public void setPlayerMark(CellMark playerMark) {
        this.playerMark = playerMark;
    }
}
