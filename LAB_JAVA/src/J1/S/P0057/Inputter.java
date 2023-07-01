package J1.S.P0057;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);
    private final static String FORMAT_USERNAME = "^[a-zA-Z]{5,}+$";
    private final static String FORMAT_PASSWORD = "^[a-zA-Z]{6,}+$";

    public Inputter() {

    }

    // input option 
    public int InputOption(int min, int max) {
        //loop until user input true option
        while (true) {
            System.out.print("> Choose:");
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

    // input username
    String InputUsername() {
        // loop until input true username
        while (true) {
            System.out.print("Enter Username: ");
            String username = scanner.nextLine().trim();
            // if input true format
            if (username.matches(FORMAT_USERNAME)) {
                return username;
            }
            System.err.println("You must enter at least at 5 character, and no space!");
        }
    }

    // input password
    String InputPassword() {
        // loop until input true password
        while (true) {
            System.out.print("Enter Password: ");
            String password = scanner.nextLine().trim();
            // if input true format
            if (password.matches(FORMAT_PASSWORD)) {
                return password;
            }
            System.err.println("You must enter at least at 6 character, and no space!");
        }
    }
}
