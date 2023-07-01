package J1.S.P0063;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);

    public Inputter() {

    }

    //  input name
    String InputName() {
        // create regex name contain only character in alphabet and space
        String regex = "^[a-zA-Z ]+$";
        /*
        ^ : start the regex
        [a-zA-Z ] regex contain all character lowercase and uppercase and space in alphabet 
        $ : end of regex
         */
        // loop until name is correct
        while (true) {
            System.out.print("Please input name:");
            String name = scanner.nextLine().trim();
            // if name empty
            if (name.isEmpty()) {
                System.err.println("Name not empty");
                // if name input match regex name
            } else if (name.matches(regex)) {
                return name;
            } else {
                System.err.println("Invalid name");
            }

        }

    }

    //  input address
    String InputAddress() {
        // loop until return address
        while (true) {
            System.out.print("Please input address:");
            String address = scanner.nextLine().trim();
            if (address.isEmpty()) {
                System.err.println("Address not empty");
            } else {
                return address;
            }

        }
    }

    // input salary
    double InputSalary() {
        // loop until user input true salary
        while (true) {
            System.out.print("Please input salary:");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    double salary = Double.parseDouble(input);
                    if (salary > 0) {
                        return salary;
                    } else {
                        System.err.println("Salary is greater than zero");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must input number");
                }
            }

        }
    }
}
