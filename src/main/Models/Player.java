package main.Models;

import main.BoardLogic.Board;
import main.CellLogic.CellMark;

import java.util.Scanner;

public class Player {
    public String name;
    public String symbol;
    private final Scanner input = new Scanner(System.in);
    public CellMark playerMark;
    // TODO What is first, delete or add?
    // also need to check if playermark is correct
    public Player(CellMark mark){
        playerMark = mark;
    }
    public void play(Board board){
        System.out.println("Create cell:");
        boolean got = false;
        try{
            while (!got) {
                Coordinate coord = GetCoordFromPlayer(board);
                board.aliveCell(coord.x, coord.y, playerMark);
                got = true;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        got = false;

        System.out.println("Delete cell:");
        try{
            while (!got) {
                Coordinate coord = GetCoordFromPlayer(board);
                board.killCellOn(coord.x,coord.y);
                got = true;
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }

    public Coordinate GetCoordFromPlayer(Board board){
        Coordinate coord = new Coordinate();
        while (true) {
            try {
                String inputStr = input.nextLine();

                String[] numbersStr = inputStr.split(" ");
                if(inputStr.replace(',', ' ').split(" ").length == 2)
                    numbersStr = inputStr.split(" ");
                else if(inputStr.split(", ").length == 2)
                    numbersStr = inputStr.split(", ");

                if (numbersStr.length==2){
                        coord.x = Integer.parseInt(numbersStr[0]) - 1;
                        coord.y = Integer.parseInt(numbersStr[1]) - 1;
                        if(coord.x >= board.width || coord.y >= board.height)
                            throw new Exception("Not valid coordinates!");
                    return coord;
                }
                else {
                    System.out.println("Enter only two numbers");
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }
}
