package fi.tuni.tamk.tiko.rikuvesanto;

/**
* The Main class asks for lottery numbers 
* and calculates the time it would take to win the lottery.
*
* @author Riku Vesanto
*/

import fi.tuni.tamk.tiko.rikuvesanto.util.Math;
import fi.tuni.tamk.tiko.rikuvesanto.util.Arrays;
import fi.tuni.tamk.tiko.rikuvesanto.util.MyConsole;

public class Main {

   /**
    * asks for lottery numbers and randomizes lottery numbers 
    * until a full match of numbers is gotten.
    * 
    * @param args an array for the user to quickly input lottery numbers to
    */

    public static void main(String [] args) {
        int tempNumber = 0;
        int[] lotteryNumbers = new int[7];
        boolean numbersGiven = false;
        if (args.length == 7) {
            lotteryNumbers = Arrays.toIntArray(args);
            int validNumbers = 0;
            for (int i = 0; i < 7; i++) {
                if (!(lotteryNumbers[i] > 40 || lotteryNumbers[i] < 1)) {
                    validNumbers++;
                }
            }
            if (validNumbers == 7) {
                numbersGiven = true;
            } else {
                lotteryNumbers = new int [7];
            }
        }
        if (!numbersGiven) {
            for (int i = 0; i < 7; i++) {
                System.out.println("Please give unique number between [1, 40]");
                tempNumber = MyConsole.readInt(1,40,"You didn't give a number", "give a value between [1, 40]");
                if(!Arrays.contains(tempNumber,lotteryNumbers)) {
                    lotteryNumbers[i] = tempNumber;
                } else {
                    System.out.println("Not unique numbers!");
                    i--;
                }
            }
        }
        boolean extraInfo = MyConsole.getBoolean("Do you want the lottery numbers printed every time? y/n", "Incorrect input given. ","y", "n");
        boolean incorrectLotto = true;
        int yearCount = 0;
        int weekCount = 0;
        int highestAmount = 0;
        while (incorrectLotto) {
            weekCount++;
            if (weekCount == 52) {
                yearCount++;
                weekCount = 0;    
            }
            int[] result = Arrays.randomizeArray(7, 1, 40);
            if (extraInfo) {
                lotteryNumbers = Arrays.sort(lotteryNumbers);
                result = Arrays.sort(result);
                System.out.print("User lotto:   ");
                displayLotto(lotteryNumbers);
                System.out.print("Random lotto:   ");
                displayLotto(result);
            }
            int amount = Arrays.containsSameValues(lotteryNumbers,result);
            if (amount > highestAmount) {
                int amountDifference = amount - highestAmount;
                for (int i = 0; i < amount - highestAmount; i++) {
                    System.out.println("You got " + (amount - amountDifference + 1) + " right! It took you " + yearCount + " years.");
                    amountDifference--;
                }
                highestAmount = amount;
            }
            if (amount == 7) {
                System.out.println("You won!");
                if (yearCount < 120) {
                    incorrectLotto = false;
                } else {
                    System.out.println("But it took more than a lifetime, let's try it again.");
                    yearCount = 0;
                    weekCount = 0;
                    highestAmount = 0;
                }
            }      
        }
    }

   /**
    * displays a lottery line.
    * 
    * @param array an array of lottery numbers
    */

    private static void displayLotto(int[] array) {
        String currentNumber;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 10) {
                currentNumber = "0" + String.valueOf(array[i]);
            } else {
                currentNumber = String.valueOf(array[i]);
            }
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(currentNumber);
            if (i + 1 == array.length) {
                System.out.println("]");
            } else {
                System.out.print(", ");
            }
        }
    }
}