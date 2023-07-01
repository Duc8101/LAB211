package J1.S.P0020;

import java.util.Scanner;

public class SelectionSort {

    // enter number of array
    int EnterNumberOfArray() {
        Scanner sc = new Scanner(System.in);
        // loop until user input true integer positive number
        while (true) {
            System.out.println("Enter number of array: ");
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

    // input value of element
    private int InputValueOfElement() {
        Scanner sc = new Scanner(System.in);
        // loop until user input true 
        while (true) {
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int value = Integer.parseInt(input);
                    return value;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input!!You must input integer number");
                }
            }

        }
    }

    // input array
    int[] InputArray(int number) {
        int array[] = new int[number];
        // loop for traverse through array
        for (int i = 0; i < number; i++) {
            array[i] = InputValueOfElement();
        }
        return array;
    }

    //display array 
    void DisplayArray(int array[], String message) {
        System.out.print(message);
        //  loop for traverse through array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print("\b\b]");
    }

    // sort array use selection sort
    void SelectionSort(int array[]) {
        //  loop for traverse through array all elements
        for (int i = 0; i < array.length; i++) {
            // initialize index of min element is index of current element
            int indexMin = i;
            //  loop for traverse through array unsorted elements
            for (int j = i + 1; j < array.length; j++) {
                // if index of unsorted element is smaller than index of min
                if (array[j] < array[indexMin]) {
                    indexMin = j;
                }
            }
            int temp = array[indexMin];
            array[indexMin] = array[i];
            array[i] = temp;
        }
    }
}
