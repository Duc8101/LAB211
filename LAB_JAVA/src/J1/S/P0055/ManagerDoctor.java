package J1.S.P0055;

import java.io.*;
import java.util.*;

public class ManagerDoctor {

    private final Map<String, Doctor> map = new HashMap<>();
    private final Inputter input = new Inputter();

    public ManagerDoctor() {

    }

    // add doctor
    void addDoctor() {
        ReadFromFile();
        System.out.println("--------- Add Doctor ----------");
        String code = input.InputStrNotEmpty("Code");
        // if code exist
        if (isExist(code)) {
            System.err.println("Code existed");
        } else {
            String name = input.InputName();
            String specialization = input.InputStrNotEmpty("Specialization");
            int availability = input.InputAvailability();
            Doctor doctor = new Doctor(code, name, specialization, availability);
            map.put(code, doctor);
            WriteToFile();
            System.out.println("Add Successful!!");
        }
    }

    // read from file
    private void ReadFromFile() {
        try {
            File file = new File("Doctor.txt");
            // if file not exist
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader reader = new FileReader("Doctor.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            // loop for reading all line
            while (line != null) {
                String Line[] = line.split(",");
                String code = Line[0];
                String name = Line[1];
                String specialization = Line[2];
                int availability = Integer.parseInt(Line[3]);
                Doctor doctor = new Doctor(code, name, specialization, availability);
                map.put(code, doctor);
                line = buffer.readLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // write to file
    private void WriteToFile() {
        // get all key in map
        Set<String> key = map.keySet();
        try {
            FileWriter writer = new FileWriter("Doctor.txt");
            // loop for traverse all code
            for (String code : key) {
                Doctor doctor = map.get(code);
                writer.write(doctor.getCode() + "," + doctor.getName() + "," + doctor.getSpecialization() + "," + doctor.getAvailability() + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    // check code exist
    private boolean isExist(String code) {
        // if map empty
        if (map.isEmpty()) {
            return false;
        }
        // get all key in map
        Set<String> key = map.keySet();
        // loop for traverse all code
        for (String Code : key) {
            // if code exist
            if (code.equalsIgnoreCase(Code)) {
                return true;
            }
        }
        return false;
    }

    void updateDoctor() {
        ReadFromFile();
        System.out.println("--------- Update Doctor ----------");
        // if map empty
        if (map.isEmpty()) {
            System.err.println("Can't update because there are not any doctors");
        } else {
            System.out.print("Enter Code: ");
            String code = input.InputStrNotEmpty("Code");
            // if code exist
            if (isExist(code)) {
                String name = input.InputName();
                String specialization = input.InputStrNotEmpty("Specialization");
                int availability = input.InputAvailability();
                Doctor doctor = new Doctor(code, name, specialization, availability);
                map.put(code, doctor);
                WriteToFile();
                System.out.println("Update Successful!!");
            } else {
                System.err.println("Doctor code does not exist");
            }
        }
    }

    void deleteDoctor() {
        ReadFromFile();
        System.out.println("--------- Delete Doctor ----------");
        // if map empty
        if (map.isEmpty()) {
            System.err.println("Can't delete because there are not any doctors");
        } else {
            System.out.print("Enter Code: ");
            String code = input.InputStrNotEmpty("Code");
            // if code exist
            if (isExist(code)) {
                map.remove(code);
                WriteToFile();
                System.out.println("Delete Successful!!");
            } else {
                System.err.println("code does not exist Doctor");
            }
        }
    }

    // search doctor
    void searchDoctor() {
        ReadFromFile();
        System.out.println("---------- Search Doctor ----------");
        // if map empty
        if (map.isEmpty()) {
            System.err.println("Can't search because there are not any doctors");
        } else {
            String text = input.InputStrNotEmpty("text");
            System.out.println("--------- Result ------------");
            System.out.format("%-6s%-12s%-20s%-15s\n", "Code", "Name", "Specialization", "Availability");
            // get list doctor by code
            List<Doctor> list = searchDoctor("code", text);
            // if not found by code
            if (list.isEmpty()) {
                // get list doctor by name
                list = searchDoctor("name", text);
                // if not found by name
                if (list.isEmpty()) {
                    // get list doctor by specialization
                    list = searchDoctor("specialization", text);
                }
            }
            // loop for traverse all doctor
            for (Doctor doctor : list) {
                System.out.format("%-6s%-12s%-20s%-15s\n", doctor.getCode(), doctor.getName(), doctor.getSpecialization(), doctor.getAvailability());
            }

        }
    }

    // search doctor by code , name or specialization
    private List<Doctor> searchDoctor(String choice, String text) {
        List<Doctor> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader("Doctor.txt");
            BufferedReader buffer = new BufferedReader(reader);
            String line = buffer.readLine();
            // loop for reading all line
            while (line != null) {
                String Line[] = line.split(",");
                String code = Line[0];
                String name = Line[1];
                String specialization = Line[2];
                int availability = Integer.parseInt(Line[3]);
                Doctor doctor = new Doctor(code, name, specialization, availability);
                switch (choice) {
                    case "code":
                        // if code contain text
                        if (code.toLowerCase().contains(text.toLowerCase())) {
                            list.add(doctor);
                        }
                        break;
                    case "name":
                        // if name contain text
                        if (name.toLowerCase().contains(text.toLowerCase())) {
                            list.add(doctor);
                        }
                        break;
                    case "specialization":
                        // if specialization contain text
                        if (specialization.toLowerCase().contains(text.toLowerCase())) {
                            list.add(doctor);
                        }
                        break;
                }
                line = buffer.readLine();
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
}
