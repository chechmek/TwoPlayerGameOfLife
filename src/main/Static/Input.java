package main.Static;

import java.util.Arrays;
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
    public static int[] GetPlayerCoord(){
        boolean gotPlayerChoice = false;
        int[] coordinates= new int[10];
        while (!gotPlayerChoice) {
            try {
                String Input = input.nextLine();
                String[] numbers = Input.split(" ");
                if (numbers.length==2){
                    for (int i=0;i<numbers.length;i++){
                        coordinates = new int[]{Integer.parseInt(Arrays.toString(numbers))};
                    }
                    gotPlayerChoice=true;
                }
                else {
                    System.out.println("Enter only two numbers");
                }
                return coordinates;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Try again");
            }
        }
        return coordinates;
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
