package J1.S.P0104;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FindWordInFile find = new FindWordInFile();
        // input directory of file
        File file = find.InputDirectoryOfFile();
        // input string to search
        String string = find.InputString();
        // find strings or letter words contain the input string
        find.FindStringOrLetterWords(file, string);
    }
}
