package J1.S.P0104;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FindWordInFile {

    // input directory of file
    File InputDirectoryOfFile() {
        Scanner sc = new Scanner(System.in);
        // loop until input true 
        while (true) {
            System.out.print("Please enter directory of file:  ");
            String input = sc.nextLine().trim();
            // if input empty
            if (input.isEmpty()) {
                System.err.println("Not empty");
            } else {
                File file = new File(input);
                // if file exist
                if (file.exists()) {
                    return file;
                }
                System.err.println("File not exist");
            }
        }
    }

    // input string to search
    String InputString() {
        Scanner sc = new Scanner(System.in);
        // loop until input string not empty
        while (true) {
            System.out.print("Please enter string to search: ");
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.err.println("Not empty");
            } else {
                return string;
            }
        }
    }

    // find strings or letter words contain the input string
    void FindStringOrLetterWords(File file, String string) {
        // check string or word contain string input or not
        boolean check = false;
        System.out.println("\nSearch results:");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            // loop for reading all line in file
            while (line != null) {
                String split[] = line.split(" ");
                // loop for traverse through all words
                for (String word : split) {
                    // if word contain string input
                    if (word.contains(string)) {
                        System.out.println("\t" + word.substring(0, 1).toUpperCase() + word.substring(1, word.length()));
                        check = true;
                    }
                }
                line = bufferedReader.readLine();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        // if not any word or string contain string input
        if (check == false) {
            System.err.println("Not found");
        }

    }
}
