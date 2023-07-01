package J1.S.P0101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);
    private final static String SEX_MALE = "Male";
    private final static String SEX_FEMALE = "Female";
    private final static String FORMAT_DATE = "dd/MM/yyyy";

    // input option
    int InputOption(int min, int max) {
        // loop until input true option
        while (true) {
            System.out.print("Input option:");
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int option = Integer.parseInt(input);
                    // if option out of range
                    if (option < min || option > max) {
                        System.err.println("Out of range input!! The range input is [" + min + "," + max + "]");
                    } else {
                        return option;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input");
                }
            }
        }
    }

    //input string not empty
    String InputStrNotEmpty(String message, String obj) {
        // loop until true
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println(obj + " not empty");
            } else {
                return input;
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

    // input phone
    String InputPhone(String message) {
        String regexPhone = "^[0-9]{10}+$";
        /*
        ^ start regex
        [0-9] regex contain only number 0 to 9 
        {10} quantity of  number in phone 
        $ end of regex
         */
        // loop until phone is correct
        while (true) {
            System.out.print(message);
            String phone = scanner.nextLine().trim();
            if (phone.isEmpty()) {
                System.err.println("Phone not empty");
                // if phone valid
            } else if (phone.matches(regexPhone)) {
                return phone;
            } else {
                System.err.println("Invalid phone!! Phone contains only digit and length of phone must be 10");
            }
        }
    }

    String InputEmail(String message) {
        String regex = "^[a-zA-Z][\\w]+@[a-zA-Z]+.[a-zA-Z]{2,}+.[a-zA-Z]{2,}+$";
        /*
         ^: start regex
          - start with letter
          - contain @
          - domain name : domain.xxx.yyy, xxx and yyy are letters with length >=2
         $: end regex
         */
        // loop until return email
        while (true) {
            System.out.print(message);
            String email = scanner.nextLine().trim();
            // if input empty
            if (email.isEmpty()) {
                System.err.println("Email not empty");
                // if input valid
            } else if (email.matches(regex)) {
                return email;
            } else {
                System.err.println("Invalid email");
            }
        }
    }

    // input  salary
    double InputSalary(String message) {
        // loop until  input true salary
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    double salary = Double.parseDouble(input);
                    if (salary > 0) {
                        return salary;
                    }
                    System.err.println("Salary is greater than zero");
                } catch (NumberFormatException e) {
                    System.err.println("You must input number");
                }
            }

        }
    }

    // input sex
    String InputSex(String message) {
        // loop until input true sex
        while (true) {
            System.out.print(message);
            String sex = scanner.nextLine().trim();
            // if input empty
            if (sex.isEmpty()) {
                System.err.println("Not empty");
                // if wrong sex
            } else if (!sex.equalsIgnoreCase(SEX_MALE) && !sex.equalsIgnoreCase(SEX_FEMALE)) {
                System.err.println("Sex only male or female");
            } else {
                return sex;
            }

        }
    }

    String InputDOB(String message) {
        Scanner sc = new Scanner(System.in);
        // initialize format date
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        Date now = new Date();
        //loop until return date
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Date not empty");
            } else {
                try {
                    Date date = sdf.parse(input);
                    // if date input after now
                    if (date.after(now)) {
                        System.err.println("Date not in the future");
                        //if date exist 
                    } else if (isExist(input, date)) {
                        return input;
                    } else {
                        System.err.println("Date not exist");
                    }
                } catch (ParseException e) {
                    System.err.println("Wrong format!!! format is " + FORMAT_DATE);
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
}
