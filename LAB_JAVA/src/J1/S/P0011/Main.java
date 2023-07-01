package J1.S.P0011;

import java.util.Scanner;

public class Main {

    // choose base number 
    private int ChooseBaseNumber(String message) {
        Scanner sc = new Scanner(System.in);
        // loop until return base number
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                try {
                    int BaseNumber = Integer.parseInt(input);
                    // if not 2,10,16
                    if (BaseNumber != 2 && BaseNumber != 10 && BaseNumber != 16) {
                        System.err.println("Base number only 2,10,16");
                    } else {
                        return BaseNumber;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input");
                }
            }

        }
    }

    // enter input value based on  input base
    private String EnterInputValue(int InputBase) {
        Inputter input = new Inputter();
        String InputValue = "";
        switch (InputBase) {
            // if base input is binary
            case 2:
                InputValue = input.InputBinaryValue();
                break;
            // if base input is demical 
            case 10:
                InputValue = input.InputDemicalValue();
                break;
            // if base input is hexademical 
            case 16:
                InputValue = input.InputHexadecimalValue();
                break;
            default:
                break;
        }
        return InputValue;
    }
    
    // convert input value of input base to value of output base
    private void ConvertInputValue(String InputValue, int InputBase, int OutputBase) {
        ConvertBaseNumber convert = new ConvertBaseNumber();
        // if user want convert from binary to demical
        if (InputBase == 2 && OutputBase == 10) {
            String demical = convert.ConvertBinaryToDemical(InputValue);
            System.out.println("=" + demical + "(DEC)");
            // if user want convert from demical to binary
        } else if (InputBase == 10 && OutputBase == 2) {
            String binary = convert.ConvertDemicalToBinary(InputValue);
            System.out.println("=" + binary + "(BIN)");
            // if user want convert from hexademical to demical
        } else if (InputBase == 16 && OutputBase == 10) {
            String demical = convert.ConvertHexademicalToDemical(InputValue);
            System.out.println("=" + demical + "(DEC)");
            // if user want convert from demical to hexademical  
        } else if (InputBase == 10 && OutputBase == 16) {
            String hexademical = convert.ConvertDemicalToHexademical(InputValue);
            System.out.println("=" + hexademical + "(HEX)");
            // if user want convert from binary to hexademical
        } else if (InputBase == 2 && OutputBase == 16) {
            String hexademical = convert.ConvertBinaryToHexademical(InputValue);
            System.out.println("=" + hexademical + "(HEX)");
            // if user want convert from hexademical to binary
        } else if (InputBase == 16 && OutputBase == 2) {
            String binary = convert.ConvertHexademicalToBinary(InputValue);
            System.out.println("=" + binary + "(BIN)");
        }

    }

    public static void main(String[] args) {
        Main main = new Main();
        //choose base number input
        int InputBase = main.ChooseBaseNumber("Choose base number input(2,10,16):");
        //choose base number output
        int OutputBase = main.ChooseBaseNumber("Choose base number output(2,10,16):");
        // enter input value based on choose input base
        String InputValue = main.EnterInputValue(InputBase);
        // convert input value of input base to value of output base
        main.ConvertInputValue(InputValue, InputBase, OutputBase);
    }
}
