package main.Static;

import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);
    public static String GetPlayerName(){

        boolean gotName = false;
        System.out.println("Enter player name:");
        String name="";
        while (!gotName) {
            try {
                name = input.nextLine();
                gotName=true;
                return name;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return name;
    }

    public static String GetPlayerSymbol(){
        boolean gotSymbol = false;
        System.out.println("Enter player symbol:");
        String symbol="";
        while (!gotSymbol) {
            try {
                symbol = input.nextLine();
                if(symbol.length() != 1)
                    throw new Exception("Symbol is not valid");
                gotSymbol=true;
                return symbol;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return symbol;
    }
}
