package J1.S.P0101;

public class Main {
    // show menu

    private void ShowMenu() {
        System.out.println("Main menu");
        System.out.println("1. Add employees ");
        System.out.println("2. Update employees ");
        System.out.println("3. Remove employees ");
        System.out.println("4. Search employees ");
        System.out.println("5. Sort employees by salary ");
        System.out.println("6. Exit");
    }

    // select option
    private int SelectOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 6);
        return option;

    }

    public static void main(String[] args) {
        Main main = new Main();
        EmployeeManagement management = new EmployeeManagement();
        // loop until exit program
        while (true) {
            // show menu
            main.ShowMenu();
            int option = main.SelectOption();
            switch (option) {
                case 1:// add employee
                    management.AddEmployee();
                    break;
                case 2:// update employee
                    management.UpdateEmployee();
                    break;
                case 3:// remove employee
                    management.RemoveEmployee();
                    break;
                case 4:// search employee by name
                    management.SearchEmployee();
                    break;
                case 5:// sort employee by salary
                    management.SortEmployee();
                    break;
                case 6:// exit program
                    return;
            }
        }
    }

}
