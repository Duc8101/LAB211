package J1.S.P0057;

public class Main {

    // display GUI
    private void DisplayGUI() {
        System.out.println("===== USER MANAGEMENT SYSTEM =====");
    }

    // display menu
    private void DisplayMenu() {
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }

    // select option
    private int SelectOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 3);
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        UserManagementSystem management = new UserManagementSystem();
        // loop until exit program
        while (true) {
            // display GUI 
            main.DisplayGUI();
            // display menu
            main.DisplayMenu();
            // select option
            int option = main.SelectOption();
            switch (option) {
                case 1:// create account
                    management.CreateAccount();
                    break;
                case 2: // login system
                    management.LoginSystem();
                    break;
                case 3:  // exit program  
                    return;
            }
        }

    }

}
