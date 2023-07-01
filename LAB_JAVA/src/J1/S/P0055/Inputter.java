package J1.S.P0055;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);

    public Inputter() {

    }

    // input option
    int InputOption(int min, int max) {
        //loop until user input true option
        while (true) {
            System.out.print("Choose option:");
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

    // input string not empty
    String InputStrNotEmpty(String obj) {
        //loop until user input correct
        while (true) {
            System.out.print("Enter " + obj + ": ");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println(obj.substring(0, 1).toUpperCase() + obj.substring(1) + " not empty");
            } else {
                return input;
            }
        }
    }

    // input name
    String InputName() {
        // create regex name contain only character in alphabet and space
        String regexName = "^[a-zA-Z ]+$";
        /*
        ^ : start the regex
        [a-zA-Z ] regex contain all character lowercase and uppercase in alphabet and space
        $ : end of regex
         */
        // loop until name is correct
        while (true) {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine().trim();
            // if name empty
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

    // input availability
    int InputAvailability() {
        //loop until user input true 
        while (true) {
            System.out.print("Enter Availability: ");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Availability not empty");
            } else {
                try {
                    int availability = Integer.parseInt(input);
                    // if availability valid
                    if (availability >= 0) {
                        return availability;
                    }
                    System.err.println("Availability greater than or equal to 0");
                } catch (NumberFormatException e) {
                    System.err.println("You must input integer number");
                }
            }

        }
    }

}
