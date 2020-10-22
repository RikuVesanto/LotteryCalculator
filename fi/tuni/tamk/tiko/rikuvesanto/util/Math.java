package fi.tuni.tamk.tiko.rikuvesanto.util;


/**
* The class Math contains methods for performing basic math related operations.
*
* @author Riku Vesanto
*/

public class Math {

    /**
    * generates a random number in a range.
    * 
    * @param min the lowest number that can be generated
    * @param max the highest number that can be generated    
    * @return a randomly generated number
    */  

    public static int getRandom(int min, int max) {
        return min + (int) (java.lang.Math.random() * ((max - min) + 1));
    }
}