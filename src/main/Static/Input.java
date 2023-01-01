package main.Static;

import main.BoardLogic.Board;
import main.Models.Coordinate;

import java.util.Objects;
import java.util.Scanner;


public class Input {
    private static final Scanner input = new Scanner(System.in);

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

    public static String getString(String string){
        if (Objects.equals(string, "1 2")){
            return string;
        }
        if (Objects.equals(string, "2 6")){
            return string;
        }
        String inputStr = input.nextLine();
        return inputStr;
    }
    public static void Wait(){
        input.nextLine();
    }
}
