package J1.S.P0055;

public class Main {

    // display menu 
    private void DisplayMenu() {
        System.out.println("========= Doctor Management ==========");
        System.out.println("\t1. Add Doctor");
        System.out.println("\t2. Update Doctor");
        System.out.println("\t3. Delete Doctor");
        System.out.println("\t4. Search Doctor");
        System.out.println("\t5. Exit");
    }

    //  choose option
    private int ChooseOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 5);
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ManagerDoctor manage = new ManagerDoctor();
        // loop until exit program
        while (true) {
            // display menu
            main.DisplayMenu();
            // choose option
            int option = main.ChooseOption();
            switch (option) {
                case 1:// add doctor
                    manage.addDoctor();
                    break;
                case 2:// update doctor
                    manage.updateDoctor();
                    break;
                case 3:// delete doctor
                    manage.deleteDoctor();
                    break;
                case 4:// search doctor
                    manage.searchDoctor();
                    break;
                case 5:// exit program
                    return;
            }
        }

    }
}
