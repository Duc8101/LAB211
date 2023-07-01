package J1.L.P0021;

public class Main {

    // show menu to main screen//
    private void ShowMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
    }

    //  choose option
    private int ChooseOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 5, "Choose option:");
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        StudentManagement manage = new StudentManagement();
        // loop until exit program
        while (true) {
            // show menu
            main.ShowMenu();
            // choose option
            int option = main.ChooseOption();
            switch (option) {
                case 1:// create student
                    manage.CreateStudent();
                    break;
                case 2:// find and sort
                    manage.FindAndSortStudentByName();
                    break;
                case 3:// Update/Delete
                    manage.UpdateOrDeleteStudent();
                    break;
                case 4:// report
                    manage.ReportStudent();
                    break;
                case 5:// Exit program
                    return;
            }

        }

    }
}
