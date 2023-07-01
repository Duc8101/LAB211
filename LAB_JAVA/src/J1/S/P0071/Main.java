package J1.S.P0071;

public class Main {

    // display menu
    private void DisplayMenu() {
        System.out.println("========= Task program ===========");
        System.out.println("  .  Add Task");
        System.out.println("  .  Delete Task");
        System.out.println("  .  Display Task");
        System.out.println("  .  Exit");
    }

    // select option
    private int SelectOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 4, "Your option:");
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        TaskManagement management = new TaskManagement();
        int ID = 1;
        // loop until exit program
        while (true) {
            // display menu 
            main.DisplayMenu();
            // select option
            int option = main.SelectOption();
            switch (option) {
                case 1:
                    // add task
                    ID = management.addTask(ID);
                    break;
                case 2:
                    // delete task
                    management.deleteTask();
                    break;
                case 3:
                    // get data task
                    management.getDataTasks();
                    break;
                case 4:
                    return;
            }
        }

    }
}
