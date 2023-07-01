package J1.S.H206;

public class Main {

    public static void main(String[] args) {
        PrintSquare square = new PrintSquare();
        // input min
        int min = square.InputNumber("Input min:");
        // input max
        boolean check;
        int max;
        // loop until input max equal or greater than min
        do {
            max = square.InputNumber("Input max:");
            check = square.CheckInput(min, max);
        } while (check == false);
        // print all numbers from min to max
        square.PrintSquare(min, max);
    }
}
