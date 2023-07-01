package J1.S.P0011;

import java.util.Scanner;

public class Inputter {

    private final Scanner scanner = new Scanner(System.in);

    // input binary value
    String InputBinaryValue() {
        String binary;
        boolean check;
        // loop until user input true binary number
        do {
            System.out.print("Enter value(BIN):");
            binary = scanner.nextLine().trim();
            check = isBinaryValue(binary);
        } while (check == false);
        return binary;
    }

    // input demical value
    String InputDemicalValue() {
        String demical;
        boolean check;
        // loop until user input true demical number
        do {
            System.out.print("Enter value(DEC):");
            demical = scanner.nextLine().trim();
            check = isDemicalValue(demical);
        } while (check == false);
        return demical;
    }

    //input hexademical value
    String InputHexadecimalValue() {
        String hexademical;
        boolean check;
        // loop until user input true hexademical number
        do {
            System.out.print("Enter  value(HEX):");
            hexademical = scanner.nextLine().trim();
            check = isHexademicalValue(hexademical);
        } while (check == false);
        return hexademical;
    }

    // check input value binary number
    private boolean isBinaryValue(String binary) {
        if (binary.isEmpty()) {
            System.err.println("Not empty");
            return false;
        }
        char character[] = binary.toCharArray();
        // loop for traverse through array
        for (int i = 0; i < character.length; i++) {
            if (character[i] != '0' && character[i] != '1') {
                System.err.println("Only digit 0,1");
                return false;
            }
        }
        return true;
    }

    // check input demical value number
    private boolean isDemicalValue(String demical) {
        if (demical.isEmpty()) {
            System.err.println("Not empty");
            return false;
        }
        char character[] = demical.toCharArray();
        // loop for traverse through all characters
        for (int i = 0; i < character.length; i++) {
            if (character[i] < '0' || character[i] > '9') {
                System.err.println("Only digit 0->9");
                return false;
            }
        }
        return true;
    }

    // check  input hexademical value number
    private boolean isHexademicalValue(String hexademical) {
        if (hexademical.isEmpty()) {
            System.err.println("Not empty");
            return false;
        }
        char character[] = hexademical.toCharArray();
        // loop for traverse through all characters
        for (int i = 0; i < character.length; i++) {
            if ((character[i] < '0' || character[i] > '9') && (character[i] < 'A' || character[i] > 'F')) {
                System.err.println("Only digit 0->9 and character A->F");
                return false;
            }
        }
        return true;
    }
}
