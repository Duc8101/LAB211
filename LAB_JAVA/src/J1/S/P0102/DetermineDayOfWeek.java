package J1.S.P0102;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DetermineDayOfWeek {

    private final static String FORMAT_DATE = "dd/MM/yyyy";

    Date EnterDate(String message) {
        Scanner sc = new Scanner(System.in);
        //initialize format date
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
        //loop until return date
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    Date date = sdf.parse(input);
                    if (isExist(input, date)) {
                        return date;
                    }
                    System.err.println("Date not exist");
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

    // determine day of week 
    void DetermineDayOfWeek(Date date) {
        // get day of week
        int day = date.getDay();
        switch (day) {
            case 0:
                System.out.println("Your day is Sunday");
                break;
            case 1:
                System.out.println("Your day is Monday");
                break;
            case 2:
                System.out.println("Your day is Tuesday");
                break;
            case 3:
                System.out.println("Your day is Wednesday");
                break;
            case 4:
                System.out.println("Your day is Thursday");
                break;
            case 5:
                System.out.println("Your day is Friday");
                break;
            case 6:
                System.out.println("Your day is Saturday");
                break;
        }
    }
}
