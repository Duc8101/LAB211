package J1.S.P0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);
    private static final String FORMAT_DATE = "dd-MM-yy";

    public Inputter() {

    }

    // input requirement name 
    String InputRequirementName() {
        // loop until true requirement name
        while (true) {
            System.out.print("Requirement Name: ");
            String RequirementName = scanner.nextLine().trim();
            // if name empty
            if (RequirementName.isEmpty()) {
                System.err.println("Name not empty");
            } else {
                return RequirementName;
            }
        }
    }

    // input option
    int InputOption(int min, int max, String message) {
        // loop until input true in [min,max]
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int option = Integer.parseInt(input);
                    // if input out or range
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

    // input task type 
    String InputTaskType() {
        int TaskType = InputOption(1, 4, "Task Type: ");
        String result = "";
        switch (TaskType) {
            case 1:
                result = "Code";
                break;
            case 2:
                result = "Test";
                break;
            case 3:
                result = "Design";
                break;
            case 4:
                result = "Review";
                break;
        }
        return result;

    }

    // input date
    String InputDate() {
        //initialize format date
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        Date DateCurrent = new Date();
        //loop until return date
        while (true) {
            System.out.print("Date: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Date not empty");
            } else {
                try {
                    Date date = sdf.parse(input);
                    // if date not in the future
                    if (date.before(DateCurrent)) {
                        System.err.println("Date must be in the future");
                        //  if date exist   
                    } else if (isExist(input, date)) {
                        return input;
                    } else {
                        System.err.println("Date not exist");

                    }
                } catch (ParseException e) {
                    System.err.println("Wrong format!!! format is [" + FORMAT_DATE + "]");
                }
            }

        }
    }

    // check date exist
    private boolean isExist(String input, Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        String str = sdf.format(date);
        return input.equals(str);
    }

    // input true format
    String InputTrueFormat(String obj) {
        // create regex contain only character in alphabet and space
        String format = "^[a-zA-Z ]+$";
        /*
        ^ : start the regex
        [a-zA-Z ] regex contain all character lowercase and uppercase in alphabet 
        $ : end of regex
         */
        // loop until input true format
        while (true) {
            System.out.print(obj + ": ");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println(obj + " not empty");
                // if true format
            } else if (input.matches(format)) {
                return input;
            } else {
                System.err.println("Invalid " + obj.substring(0, 1).toLowerCase() + obj.substring(1));
            }
        }
    }

    // input plan 
    double InputPlan() {
        // loop until input true plan 
        while (true) {
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    double plan = Double.parseDouble(input);
                    if (plan >= 8.0 && plan < 17.5 && plan % 0.5 == 0) {
                        return plan;
                    } else {
                        System.err.println("Plan within 8 h-17 h 30 > 8.0, 8.5, 9.0, ⇔ 9.5 ...-> 17.5");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("You must input number");
                }
            }

        }
    }

    // input ID
    int InputID() {
        // loop until user input true ID
        while (true) {
            System.out.print("ID: ");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int ID = Integer.parseInt(input);
                    if (ID > 0) {
                        return ID;
                    }
                    System.err.println("The number input must be integer positive number");
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input!!You must input integer positive number");
                }
            }

        }
    }

}
