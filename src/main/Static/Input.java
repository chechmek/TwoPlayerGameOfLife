package main.Static;

import main.BoardLogic.Board;
import main.Models.Coordinate;

import java.util.Scanner;

public class Input {
    private static final Scanner input = new Scanner(System.in);


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
                    coord.setX(Integer.parseInt(numbersStr[0]) - 1);
                    coord.setY(Integer.parseInt(numbersStr[1]) - 1);
                    if(coord.getX() >= board.getWidth() || coord.getY() >= board.getHeight())
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
            coord.setX(Integer.parseInt(numbersStr[0]) - 1);
            coord.setY(Integer.parseInt(numbersStr[1]) - 1);
            if (coord.getX() >= board.getWidth() || coord.getY() >= board.getHeight())
                throw new Exception("Not valid coordinates!");
            return coord;
        }
        throw new Exception("Enter only two numbers");
    }

    public static void Wait(){
        input.nextLine();
    }
}
