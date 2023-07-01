package J1.S.P0057;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserManagementSystem {

    private final Inputter input = new Inputter();

    // create account
    void CreateAccount() {
        String username = input.InputUsername();
        String password = input.InputPassword();
        File file = new File("user.txt");
        // if file not exist
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        // if username exist
        if (isExist(username)) {
            System.err.println("Username existed!!");
        } else {
            AddAccount(username, password);
        }
    }

    // add account
    private void AddAccount(String username, String password) {
        File file = new File("user.txt");
        try {
            FileWriter myWriter = new FileWriter(file, true);
            myWriter.write(username + ";" + password + "\n");
            myWriter.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // check username exist
    private boolean isExist(String username) {
        File file = new File("user.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            // loop for reading all line
            while (line != null) {
                String account[] = line.split(";");
                // if username exist
                if (username.equalsIgnoreCase(account[0])) {
                    return true;
                }
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    // login system
    protected void LoginSystem() {
        String username = new Inputter().InputUsername();
        String password = new Inputter().InputPassword();
        File file = new File("user.txt");
        boolean check = false;// check if username and password valid or not
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // loop for reading line by line
            while ((line = bufferedReader.readLine()) != null) {
                String account[] = line.split(";");
                // if username and password correct
                if (username.equalsIgnoreCase(account[0]) && password.equalsIgnoreCase(account[1])) {
                    check = true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        // if username or password incorrect
        if (check == false) {
            System.err.println("Invalid user name or password");
        } else {
            System.out.println("Login successful!");
        }

    }

}
