package J1.S.P0052;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);

    public Inputter() {

    }

    // input option
    int InputOption(int min, int max) {
        //loop until user input true option
        while (true) {
            System.out.print("Enter your choice:");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("You must not input empty");
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

    // input string not empty
    String InputStrNotEmpty(String message, String obj) {
        //loop until user input correct
        while (true) {
            System.out.println(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println(obj + " not empty");
            } else {
                return input;
            }
        }
    }

    // input country name
    String InputName(String message) {
        // create regex name contain only character in alphabet and space
        String regexName = "^[a-zA-Z ]+$";
        /*
        ^ : start the regex
        [a-zA-Z ]+ regex contain all character lowercase and uppercase in alphabet and space
        $ : end of regex
         */
        // loop until name is correct
        while (true) {
            System.out.println(message);
            String name = scanner.nextLine().trim();
            // if name user input is empty
            if (name.isEmpty()) {
                System.err.println("Name not empty");
                // if name input match regex name
            } else if (name.matches(regexName)) {
                return name;
            } else {
                System.err.println("Invalid name");
            }

        }
    }

    // input total area
    float InputTotalArea() {
        // loop until input true total area
        while (true) {
            System.out.println("Enter total Area: ");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("You must not input empty");
            } else {
                try {
                    float TotalArea = Float.parseFloat(input);
                    if (TotalArea > 0) {
                        return TotalArea;
                    }
                    System.err.println("Total area must be greater than 0");
                } catch (NumberFormatException e) {
                    System.err.println("You must input number");
                }
            }

        }
    }

}
