package main.Static;

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

    public static void Wait(){
        input.nextLine();
    }
}
