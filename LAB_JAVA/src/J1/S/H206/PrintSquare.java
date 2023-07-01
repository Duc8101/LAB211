package J1.S.H206;

import java.util.Scanner;

public class PrintSquare {

    // input number
    int InputNumber(String message) {
        Scanner sc = new Scanner(System.in);
        // loop until input true number
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int number = Integer.parseInt(input);
                    if (number >= 0) {
                        return number;
                    }
                    System.err.println("You must input integer number>=0");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input!!You must input integer number>=0");
                }
            }
        }
    }

    // check input
    boolean CheckInput(int min, int max) {
        if (max < min) {
            System.err.println("Max must be equal or greater than min");
            return false;
        }
        return true;
    }

    void PrintSquare(int min, int max) {
        // loop for traverse through all numbers from min to max
        for (int i = min; i <= max; i++) {
            // loop for traverse through all number from current number to max of each row
            for (int j = i; j <= max; j++) {
                System.out.print(j);
            }
            // loop for traverse first numbers of each above row
            for (int k = min; k < i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

}
