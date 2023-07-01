package J1.S.P0074;

public class Main {
    // display menu

    private void DisplayMenu() {
        System.out.println("======Caculator Program======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
    }

    // select option
    private int SelectOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 4);
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        CaculateMatrix caculate = new CaculateMatrix();
        // display menu
        main.DisplayMenu();
        // loop until stop select option
        while (true) {
            // select option
            int option = main.SelectOption();
            // caculate matrix based on option selected
            switch (option) {
                // addition matrix
                case 1:
                    caculate.additionMatrix();
                    break;
                // subtraction matrix
                case 2:
                    caculate.subtractionMatrix();
                    break;
                // multiplication matrix
                case 3:
                    caculate.multiplicationMatrix();
                    break;
                // Exit program
                case 4:
                    return;
            }
        }

    }
}
