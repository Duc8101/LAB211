package J1.S.P0103;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CompareDate {

    private final static String FORMAT_DATE = "dd/MM/yyyy";

    // enter date
    Date EnterDate(String message) {
        Scanner sc = new Scanner(System.in);
        // initialize format date
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
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
                    //if date exist 
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

    //compare and display
    void CompareAndDisplay(Date date1, Date date2) {
        if (date1.before(date2)) {
            System.out.println("\nDate1 is before Date2");
        } else if (date1.after(date2)) {
            System.out.println("\nDate1 is after Date2");
        } else {
            System.out.println("\nDate1 is the same Date2");
        }
    }
}
