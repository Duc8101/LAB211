package J1.S.P0074;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);

    // input option
    int InputOption(int min, int max) {
        // loop until input true option
        while (true) {
            System.out.print("Your choice:");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int option = Integer.parseInt(input);
                    if (option < min || option > max) {
                        System.err.println("Please input number in range [" + min + ", " + max + "]");
                    } else {
                        return option;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must input integer number");
                }
            }

        }
    }

    // input value of row column
    int InputValueOfRowColumn(String obj, int number) {
        int value;
        // loop until input true row
        while (true) {
            System.out.print("Enter " + obj + " Matrix " + number + ":");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    value = Integer.parseInt(input);
                    if (value < 1) {
                        System.err.println("The " + obj.substring(0, 1).toLowerCase() + obj.substring(1) + " of matrix at least 1");
                    } else {
                        return value;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input");
                }
            }
        }
    }

    // input value of element
    int InputValueOfElement(int number, int i, int j) {
        int value;
        // loop until input true  value of matrix
        while (true) {
            System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]" + ":");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    value = Integer.parseInt(input);
                    return value;
                } catch (NumberFormatException e) {
                    System.err.println("Value of matrix is digit");
                }
            }
        }
    }

    // input matrix
    int[][] InputMatrix(int row, int column, int number) {
        int matrix[][] = new int[row][column];
        // loop for travese through row of matrix
        for (int i = 0; i < row; i++) {
            // loop for travese through coloumn of matrix   
            for (int j = 0; j < column; j++) {
                matrix[i][j] = InputValueOfElement(number, i, j);
            }
        }
        return matrix;
    }
}
