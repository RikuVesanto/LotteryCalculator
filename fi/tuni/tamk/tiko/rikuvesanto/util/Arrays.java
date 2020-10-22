package fi.tuni.tamk.tiko.rikuvesanto.util;

/**
* The Array class contains methods that convert, compare, alter or create an array.
*
* @author Riku Vesanto
*/

public class Arrays {

   /**
    * changes a string array to an int array.
    * 
    * @param array a string array
    * @return an int array
    */       

    public static int [] toIntArray(String [] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = Integer.parseInt(array[i]);
        }
        return intArray;
    }

   /**
    * checks an array for a value
    * 
    * @param value what number needs to be searched
    * @param array the array that is searched
    * @return a boolean value that tells whether a matching value was found
    */       


    public static boolean contains(int value, int [] array) {
        boolean contains = false;
        for (int i = 0; i < array.length && !contains; i++) {
            if (value == array[i]) {
                contains = true;
            }
        }
        return contains;
    }

   /**
    * Compares two arrays and counts how many matching values they have.
    * 
    * @param array1 the first array that is to be compared
    * @param array2 the second array that is to be compared
    * @return the count of how many matching values the arrays had
    */ 

    public static int containsSameValues(int [] array1, int [] array2) { 
        int counter = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int x = 0; x < array2.length; x++) {
                if (array1[i] == array2[x]) {
                    counter++;
                }
            }
        }
        return counter;
    }

   /**
    * Takes an array and recreates it without a certain index.
    * 
    * @param original an array which will have an index taken out
    * @param index the placement of the index that is to be removed
    * @return an array with 1 index taken out
    */    

    public static int[] removeIndex(int [] original, int index) {
        int[] tempArray = new int[original.length -1];
        int reduction = 0;
        for (int i = 0; i < original.length; i++) {
            if (index == i) {
                reduction++;
            } else {
                tempArray[i - reduction] = original[i];
            }
        }
        return tempArray;
    }


    /**
    * Sorts an array from lowest to highest
    * 
    * @param array a number array that is to be sorted
    * @return a number array sorted from lowest to highest
    */

    public static int [] sort(int [] array) {
        int lowest = array[0];
        int lowestIndex = 0;
        int[] tempArray = new int[array.length];
        for (int i = 0; i < tempArray.length; i++) {
            for (int z = 0; z < array.length; z++) {
                if (lowest > array[z] || z == 0) {
                    lowest = array[z];
                    lowestIndex = z;    
                }
            }
            tempArray[i] = lowest;
            array = removeIndex(array, lowestIndex);
        }
        return tempArray;
    }

    
    /**
    * Returns an array with randomized numbers. 
    * 
    * @param amount the number of values to be randomized
    * @param min the lowest number that can be randomized
    * @param max the highest number that can be randomized
    * @return an array with randomized numbers
    */

    public static int[] randomizeArray(int amount, int min, int max) {
        int[] correctNumbers = new int[amount];
        int[] possibleNumbers = new int[max];
        for (int i = 0; i < max; i++) {
            possibleNumbers[i] = i + 1;
        }
        for (int i = 0; i < amount; i++) {
            int index = Math.getRandom(0, possibleNumbers.length - 1);
            int randomNumber = possibleNumbers[index];
            correctNumbers[i] = randomNumber;
            possibleNumbers = Arrays.removeIndex(possibleNumbers, index);
        }
        return correctNumbers;
    }    
}