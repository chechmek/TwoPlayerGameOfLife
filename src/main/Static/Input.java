package main.Static;

import main.BoardLogic.Board;
import main.Models.Coordinate;

import java.util.Scanner;

public class Input {
    private static final Scanner input = new Scanner(System.in);
    public static String GetPlayerName(){
        System.out.println("Enter player name:");
        while (true) {
            try {
                String name = input.nextLine().trim();
                return name;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }


    public static String GetPlayerSymbol(){
        System.out.println("Enter player symbol:");

        while (true) {
            try {
                String symbol = input.nextLine();
                if(symbol.length() != 1)
                    throw new Exception("Symbol is not valid");
                return symbol;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
    }

    public static Coordinate getCoordinate(Board board){
        Coordinate coord = new Coordinate();
        while (true) {
            try {
                String coordinateStr = input.nextLine();

                String[] numbersStr = coordinateStr.split(" ");
                if(coordinateStr.replace(',', ' ').split(" ").length == 2)
                    numbersStr = coordinateStr.split(" ");
                else if(coordinateStr.split(", ").length == 2)
                    numbersStr = coordinateStr.split(", ");

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

    public static Coordinate getCoordinateFromStr(String coordinateStr, Board board) throws Exception {
        Coordinate coord = new Coordinate();
        String[] numbersStr = coordinateStr.split(" ");
        if(coordinateStr.replace(',', ' ').split(" ").length == 2)
            numbersStr = coordinateStr.split(" ");
        else if(coordinateStr.split(", ").length == 2)
            numbersStr = coordinateStr.split(", ");

        if (numbersStr.length==2) {
            coord.x = Integer.parseInt(numbersStr[0]) - 1;
            coord.y = Integer.parseInt(numbersStr[1]) - 1;
            if (coord.x >= board.width || coord.y >= board.height)
                throw new Exception("Not valid coordinates!");
            return coord;
        }
        throw new Exception("Enter only two numbers");
    }

    public static void Wait(){
        input.nextLine();
    }
}
