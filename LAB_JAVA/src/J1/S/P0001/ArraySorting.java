package J1.S.P0001;

import java.util.Random;
import java.util.Scanner;

public class ArraySorting {

    // enter number of array
    int EnterNumberOfArray() {
        Scanner sc = new Scanner(System.in);
        // loop until user input true integer positive number
        while (true) {
            System.out.println("Enter number of array:");
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int number = Integer.parseInt(input);
                    if (number > 0) {
                        return number;
                    }
                    System.err.println("You must input integer positive number");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input!!You must input integer positive number");
                }
            }
        }
    }

    // generate random element
    int[] GenerateRandomElement(int number) {
        int array[] = new int[number];
        Random random = new Random();
        // loop for traverse through array
        for (int i = 0; i < number; i++) {
            //random int number from 0 to maxNumber-1
            array[i] = random.nextInt(number);
        }
        return array;
    }

    //display array 
    void DisplayArray(int array[], String message1, String message2) {
        System.out.print(message1);
        //  loop for traverse through array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
//            System.out.print(arrayInt[i] + " ");
        }
        System.out.print("\b\b]");
//        System.out.println(message2);
    }

    // swap element in array
    private void SwapElement(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // sort array use bubble sort
    void BubbleSort(int array[]) {
        // loop for traverse through array
//        for (int i = 0; i < arrayInt.length; i++) {
//            System.out.print(array[i] + " ");
//        }
        // loop for traverse through array all elements
        for (int i = 0; i < array.length; i++) {
            //loop traverse the array of unsorted elements
            for (int j = 0; j < array.length - i - 1; j++) {
                // check if the element is bigger than the following adjacent element 
                if (array[j] > array[j + 1]) {
//                    System.out.println("\t" + array[j] + " > " + array[j + 1] + ",swap");
                    SwapElement(array, j, j + 1);

                } else {
//                    System.out.println("\t" + array[j] + " < " + array[j + 1] + ",ok");
                }
//                // the final iteration,after check 2 adjacent numbers
//                // stop display array
                if (i == array.length - 2) {
                    break;
                }

//                //display array after each time check 2 adjacent elements 
//                //they need to be swapped or not
//                // loop for traverse through array all elements
//                for (int k = 0; k < array.length; k++) {
//                    System.out.print(array[k] + " ");
//                }
            }
        }
    }
}
