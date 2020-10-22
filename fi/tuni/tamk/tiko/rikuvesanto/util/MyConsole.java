package fi.tuni.tamk.tiko.rikuvesanto.util;

import java.io.Console;  

/**
* The class MyConsole has methods for reading user input from console.
*
* @author Riku Vesanto
*/

public class MyConsole {

    /**
    * takes a number from the user and returns it
    * 
    * @param errorMessage a message if inputted value is not a number
    * @return an int that the user inputted
    */

    public static int readInt(String errorMessage) {
        int input = 0;
        boolean notInt = true;
        Console c = System.console();
        while (notInt) {
            try {
                input = Integer.parseInt(c.readLine());
                notInt = false;
            } catch(NumberFormatException e) {
                notInt = true;
                System.out.println(errorMessage);
            }
        }
        return input;
    }

    /**
    * takes a number from the user and returns it
    * 
    * @param min the lowest value the user can give
    * @param max the highest value the user can give
    * @param errorMessageNonNumeric a message if inputted value is not a number
    * @param errorMessageNonMinAndMax a message if value within the range isn't given
    * @return an int that the user inputted
    */  

    public static int readInt(int min, int max, String errorMessageNonNumeric, String errorMessageNonMinAndMax) {
        int input = 0;
        boolean anotherNumber = true;
        Console c = System.console();
        while (anotherNumber) {
            try {
                input = Integer.parseInt(c.readLine());
                anotherNumber = false;
            } catch(NumberFormatException e) {
                anotherNumber = true;
                System.out.println(errorMessageNonNumeric);
            } 
            if (!anotherNumber && (input < min || input > max)) {
                anotherNumber = true;
                System.out.println(errorMessageNonMinAndMax);
            }
        }
        return input;
    }

    /**
    * prints the user a question and converts the answer into a boolean
    * 
    * @param message the message that is displayed to the user
    * @param errorMessage a message that is displayed if user gives incorrect input
    * @param yes a string that the user is expected to type to signify boolean value true
    * @param no a string that the user is expected to type to signify boolean value false    
    * @return a boolean based on user input
    */     

    public static boolean getBoolean(String message, String errorMessage, String yes, String no) {
        boolean badResponse = false;
        boolean response = false;
        System.out.println(message);
        Console c = System.console();
        do {
            if (badResponse) {
                System.out.println(errorMessage + message);
            }
            String input = c.readLine();
            if (input.equals(yes)) {
                response = true;
                badResponse = false;
            } else if (input.equals(no)) {
                response = false;
                badResponse = false;
            } else {
                badResponse = true;
            }
        } while (badResponse);
        return response;
    }
}