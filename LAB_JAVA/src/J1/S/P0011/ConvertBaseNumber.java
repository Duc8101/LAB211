package J1.S.P0011;

import java.math.BigInteger;

public class ConvertBaseNumber {

    // convert binary number to demical number
    String ConvertBinaryToDemical(String binary) {
        BigInteger demical = new BigInteger("0");
        BigInteger two = new BigInteger("2");
        // get str array include all digit in binary
        String Binary[] = binary.split("");
        int index = Binary.length - 1;
        // loop for traverse through all digit in string binary
        for (String bin : Binary) {
            BigInteger value = new BigInteger(bin);
            demical = demical.add(value.multiply(two.pow(index)));
            index--;
        }
        return demical.toString();
    }

    // reverse string
    private String ReverseString(String string) {
        String reverse = "";
        // loop for traverse all character in string
        for (int i = string.length() - 1; i >= 0; i--) {
            reverse = reverse + string.charAt(i);
        }
        return reverse;
    }

    // convert demical number to binary number
    String ConvertDemicalToBinary(String demical) {
        BigInteger divisor = new BigInteger("2");
        BigInteger bigDemical = new BigInteger(demical);
        BigInteger remainder;
        String SetOfRemainder = "";
        // loop until bigDemical = 0
        while (bigDemical.compareTo(new BigInteger("0")) > 0) {
            remainder = bigDemical.mod(divisor);
            SetOfRemainder = SetOfRemainder + remainder;
            bigDemical = bigDemical.divide(divisor);
        }
        String binary = ReverseString(SetOfRemainder);
        return binary;
    }

    // convert demical number to hexademical number 
    String ConvertDemicalToHexademical(String demical) {
        //  in hexademical, just only digit from 0 to 9 and letter from A to F
        String HexStr[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        BigInteger remainder;
        String SetOfRemainder = "";
        BigInteger bigDemical = new BigInteger(demical);
        BigInteger divisor = new BigInteger("16");
        // loop until bigDemical = 0
        while (bigDemical.compareTo(new BigInteger("0")) > 0) {
            remainder = bigDemical.mod(divisor);
            SetOfRemainder = SetOfRemainder + HexStr[remainder.intValue()];
            bigDemical = bigDemical.divide(divisor);
        }
        String hexademical = ReverseString(SetOfRemainder);
        return hexademical;
    }

    // convert hexademical number to demical number 
    String ConvertHexademicalToDemical(String hexademical) {
        BigInteger demical = new BigInteger("0");
        BigInteger base = new BigInteger("16");
        // get all character in hexademical
        String Hexademical[] = hexademical.split("");
        int index = Hexademical.length - 1;
        // loop for traverse through all element in Hexademical
        for (int i = 0; i < Hexademical.length; i++) {
            // if letter A,B,C,D,E,F
            if (ConvertLetter(Hexademical[i]) != null) {
                Hexademical[i] = ConvertLetter(Hexademical[i]);
            }
            BigInteger value = new BigInteger(Hexademical[i]);
            demical = demical.add(value.multiply(base.pow(index)));
            index--;
        }
        return demical.toString();
    }

    // convert letter in hexademical to number in demical
    private String ConvertLetter(String letter) {
        String[] numbers = {"10", "11", "12", "13", "14", "15"};
        String letters[] = {"A", "B", "C", "D", "E", "F"};
        // loop for traverse through all element in letter
        for (int i = 0; i < letters.length; i++) {
            if (letter.equals(letters[i])) {
                return numbers[i];
            }
        }
        return null;
    }

    // convert binary to hexademical
    String ConvertBinaryToHexademical(String binary) {
        // convert from binary to demical first 
        String demical = ConvertBinaryToDemical(binary);
        // then convert demical value to hexademical
        String hexademical = ConvertDemicalToHexademical(demical);
        return hexademical;
    }

    // convert hexademical to binary
    String ConvertHexademicalToBinary(String hexademical) {
        // convert from hexademical to demical first
        String demical = ConvertHexademicalToDemical(hexademical);
        // then convert from demical to binary
        String binary = ConvertDemicalToBinary(demical);
        return binary;
    }
}
