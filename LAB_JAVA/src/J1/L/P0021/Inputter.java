package J1.L.P0021;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);
    private static final String[] COURSE = {"Java", ".Net", "C/C++"};

    public Inputter() {

    }

    // input option
    int InputOption(int min, int max, String message) {
        //loop until user input true option
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int option = Integer.parseInt(input);
                    if (option < min || option > max) {
                        System.err.println("Please input integer number in range [" + min + ", " + max + "]");
                    } else {
                        return option;
                    }

                } catch (NumberFormatException e) {
                    System.err.println("You must input integer number");
                }
            }

        }
    }

    // input id
    String InputID(String message) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String ID = scanner.nextLine().trim();
            if (ID.isEmpty()) {
                System.err.println("ID not empty");
            } else {
                return ID;
            }
        }
    }

    // input name
    String InputName(String message) {
        // create regex name contain only character in alphabet and space
        String regexName = "^[a-zA-Z ]+$";
        /*
        ^ : start the regex
        [a-zA-Z ] regex contain all character lowercase and uppercase in alphabet and space
        $ : end of regex
         */
        // loop until name is correct
        while (true) {
            System.out.print(message);
            String name = scanner.nextLine().trim();
            // if name user input is empty
            if (name.isEmpty()) {
                System.err.println("Name not empty");
                // if name input match patternName
            } else if (name.matches(regexName)) {
                return name;
            } else {
                System.err.println("Invalid name");
            }

        }
    }

    // input semester
    String InputSemester(String message) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String semester = scanner.nextLine().trim();
            if (semester.isEmpty()) {
                System.err.println("Semester not empty");
            } else {
                return semester;
            }
        }
    }

    // input course
    String InputCourse(String message) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String course = scanner.nextLine().trim();
            if (course.isEmpty()) {
                System.err.println("Course not empty");
            } else {
                if (course.equalsIgnoreCase(COURSE[0]) || course.equalsIgnoreCase(COURSE[1]) || course.equalsIgnoreCase(COURSE[2])) {
                    return course;
                } else {
                    System.err.println("There are only three courses: Java, .Net, C/C++");
                }

            }

        }
    }

    //  input yes/no
    String InputYesNo(String message) {
        // loop until input yes or no
        while (true) {
            System.out.print(message);
            String choice = scanner.nextLine().trim();
            // if input y/Y or n/N
            if (choice.equalsIgnoreCase("Y") || choice.equalsIgnoreCase("N")) {
                return choice;
            }
            System.err.println("Please input y/Y or n/N");
        }

    }

    //input u/d
    String InputUD(String message) {
        //loop until user input correct
        while (true) {
            System.out.print(message);
            String choice = scanner.nextLine().trim();
            // if input empty
            if (choice.isEmpty()) {
                System.err.println("Not empty");
            } else if (choice.equalsIgnoreCase("U") || choice.equalsIgnoreCase("D")) {
                return choice;
            } else {
                System.err.println("Please input u/U or d/D.");
            }
        }
    }

}
