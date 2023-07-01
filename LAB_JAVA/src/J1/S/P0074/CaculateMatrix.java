package J1.S.P0074;

public class CaculateMatrix {

    private final Inputter input = new Inputter();

    // display matrix
    private void DisplayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        // loop for traverse through row of matrix
        for (int i = 0; i < row; i++) {
            // loop for traverse through column of matrix
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    // addition matrix
    void additionMatrix() {
        System.out.println("-------- Addition --------");
        int row1 = input.InputValueOfRowColumn("Row", 1);
        int column1 = input.InputValueOfRowColumn("Column", 1);
        int matrix1[][] = input.InputMatrix(row1, column1, 1);
        int row2;
        int column2;
        // loop until input true row of matrix 2
        do {
            row2 = input.InputValueOfRowColumn("Row", 2);
            // if row 1 not equal to row 2
            if (row2 != row1) {
                System.err.println("Row of matrix 2 must be equal to row of matrix 1");
            }
        } while (row2 != row1);
        // loop until input true column of matrix 2
        do {
            column2 = input.InputValueOfRowColumn("Column", 2);
            // if column 1 not equal to column 2
            if (column2 != column1) {
                System.err.println("Column of matrix 2 must be equal to column of matrix 1");
            }
        } while (column2 != column1);
        int matrix2[][] = input.InputMatrix(row2, column2, 2);
        System.out.println("-------- Result --------");
        // display matrix 1
        DisplayMatrix(matrix1);
        System.out.println("+");
        // display matrix 2
        DisplayMatrix(matrix2);
        System.out.println("=");
        int MatrixResult[][] = new int[row1][column1];
        // loop for travese through row of matrix
        for (int i = 0; i < row1; i++) {
            // loop for travese through column of matrix
            for (int j = 0; j < column1; j++) {
                MatrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        DisplayMatrix(MatrixResult);
    }

    // subtraction matrix
    void subtractionMatrix() {
        System.out.println("-------- Subtraction --------");
        int row1 = input.InputValueOfRowColumn("Row", 1);
        int column1 = input.InputValueOfRowColumn("Column", 1);
        int matrix1[][] = input.InputMatrix(row1, column1, 1);
        int row2;
        int column2;
        // loop until input true row of matrix 2
        do {
            row2 = input.InputValueOfRowColumn("Row", 2);
            // if row 1 not equal to row 2
            if (row2 != row1) {
                System.err.println("Row of matrix 2 must be equal to row of matrix 1");
            }
        } while (row2 != row1);
        // loop until input true column of matrix 2
        do {
            column2 = input.InputValueOfRowColumn("Column", 2);
            // if column 1 not equal to column 2
            if (column2 != column1) {
                System.err.println("Column of matrix 2 must be equal to column of matrix 1");
            }
        } while (column2 != column1);
        int matrix2[][] = input.InputMatrix(row2, column2, 2);
        System.out.println("-------- Result --------");
        // display matrix 1
        DisplayMatrix(matrix1);
        System.out.println("-");
        DisplayMatrix(matrix2);
        System.out.println("=");
        int MatrixResult[][] = new int[row1][column1];
        // display matrix result
        // loop for travese through row of matrix
        for (int i = 0; i < row1; i++) {
            // loop for travese through column of matrix
            for (int j = 0; j < column1; j++) {
                MatrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }

        }
        DisplayMatrix(MatrixResult);
    }

    // multiplication matrix 
    protected void multiplicationMatrix() {
        System.out.println("-------- Multiplication --------");
        int row1 = input.InputValueOfRowColumn("Row", 1);
        int column1 = input.InputValueOfRowColumn("Column", 1);
        int matrix1[][] = input.InputMatrix(row1, column1, 1);
        // if multiplication, the row of matrix2 must be equal to column of matrix 1
        // loop until input true row of matrix 2
        int row2;
        int column2;
        // loop until input true row of matrix 2
        do {
            row2 = input.InputValueOfRowColumn("Row", 2);
            // if row2 not equal to column 1
            if (column1 != row2) {
                System.err.println("To multiply, the row of matrix 2 must be equal to column of matrix 1");
            }
        } while (column1 != row2);
        column2 = input.InputValueOfRowColumn("Column", 2);
        int matrix2[][] = input.InputMatrix(row2, column2, 2);
        System.out.println("-------- Result --------");
        // display matrix 1
        DisplayMatrix(matrix1);
        System.out.println("*");
        // display matrix 2
        DisplayMatrix(matrix2);
        System.out.println("=");
        // after multiply, the matrix result have size :row of matrix 1,column of matrix 2
        int MatrixResult[][] = new int[row1][column2];
        int i, j, k;
        // loop for traverse through row of matrix result
        for (i = 0; i < row1; i++) {
            // loop for traverse through column of matrix result
            for (j = 0; j < column2; j++) {
                MatrixResult[i][j] = 0;
                // loop for traverse through row of matrix 2 and column of matrix 1
                for (k = 0; k < row2; k++) {
                    MatrixResult[i][j] = MatrixResult[i][j] + matrix1[i][k] * matrix2[k][j];
                }
            }

        }
        // display matrix result
        DisplayMatrix(MatrixResult);
    }
}
