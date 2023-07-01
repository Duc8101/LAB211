package J1.S.P0103;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        CompareDate compare = new CompareDate();
        //  enter first date
        Date date1 = compare.EnterDate("Please enter the first date: ");
        //  enter second date 
        Date date2 = compare.EnterDate("Please enter the second date: ");
        // compare and display 
        compare.CompareAndDisplay(date1, date2);
    }

}
