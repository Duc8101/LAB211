package J1.S.P0102;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        DetermineDayOfWeek determine = new DetermineDayOfWeek();
        // enter date
        Date date = determine.EnterDate("Please enter date with format [dd/mm/yyyy]: ");
        // determine day of week
        determine.DetermineDayOfWeek(date);
    }

}
