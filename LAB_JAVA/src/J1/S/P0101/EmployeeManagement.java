package J1.S.P0101;

import java.util.*;

public class EmployeeManagement {

    private final List<Employee> list = new ArrayList<>();
    private final Inputter input = new Inputter();

    public EmployeeManagement() {

    }

    // add employee
    void AddEmployee() {
        String ID = input.InputStrNotEmpty("Enter ID:", "ID");
        Employee employee = getEmployeeFoundByID(ID);
        // if id input not exist in list
        if (employee == null) {
            String FirstName = input.InputName("Enter FirstName:");
            String LastName = input.InputName("Enter LastName:");
            String phone = input.InputPhone("Enter phone:");
            String email = input.InputEmail("Enter email:");
            String address = input.InputStrNotEmpty("Enter address:", "Address");
            String DOB = input.InputDOB("Enter DOB:");
            String sex = input.InputSex("Enter Sex(Male/Female):");
            double salary = input.InputSalary("Enter salary:");
            String agency = input.InputStrNotEmpty("Enter agency:", "Agency");
            employee = new Employee(ID, FirstName, LastName, phone, email, address, DOB, sex, salary, agency);
            list.add(employee);
            System.out.println("Add successfully!");
            DisplayList(list);
        } else {
            System.err.println("Duplicate ID");
        }
    }

    // get employee found by ID
    private Employee getEmployeeFoundByID(String ID) {
        // loop for traverse through list
        for (Employee employee : list) {
            // if ID exist in list
            if (ID.equalsIgnoreCase(employee.getID())) {
                return employee;
            }
        }
        return null;
    }

    // display list 
    private void DisplayList(List<Employee> list) {
        System.out.format("%-10s%-15s%-15s%-15s%-30s%-12s%-23s%-10s%-10s%-10s \n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "Date Of Birth", "Sex", "Salary", "Agency");
        // loop for traverse through list
        for (Employee employee : list) {
            System.out.format("%-10s%-15s%-15s%-15s%-30s%-15s%-20s%-10s%-10.1f%-10s \n", employee.getID(), employee.getFirstName(), employee.getLastName(), employee.getPhone(),
                    employee.getEmail(), employee.getAddress(), employee.getDOB(), employee.getSex(), employee.getSalary(), employee.getAgency());
        }
    }

    // update employee
    void UpdateEmployee() {
        String ID = input.InputStrNotEmpty("Enter ID:", "ID");
        Employee employee = getEmployeeFoundByID(ID);
        // if ID input not exist in list
        if (employee == null) {
            System.err.println("Not Found ID");
        } else {
            DisplayEmployee(employee);
            String NewID = input.InputStrNotEmpty("Enter New ID:", "ID");
            // if new ID input not exist in list
            if (getEmployeeFoundByID(NewID) == null) {
                String NewFirstName = input.InputName("Enter New FirstName:");
                String NewLastName = input.InputName("Enter New LastName:");
                String NewPhone = input.InputPhone("Enter New phone:");
                String NewEmail = input.InputEmail("Enter New email:");
                String NewAddress = input.InputStrNotEmpty("Enter New address:", "Address");
                String NewDOB = input.InputDOB("Enter New DOB:");
                String NewSex = input.InputSex("Enter New Sex:");
                double NewSalary = input.InputSalary("Enter New salary:");
                String NewAgency = input.InputStrNotEmpty("Enter New agency:", "Agency");
                employee.setID(NewID);
                employee.setFirstName(NewFirstName);
                employee.setLastName(NewLastName);
                employee.setPhone(NewPhone);
                employee.setEmail(NewEmail);
                employee.setAddress(NewAddress);
                employee.setDOB(NewDOB);
                employee.setSex(NewSex);
                employee.setSalary(NewSalary);
                employee.setAgency(NewAgency);
                DisplayList(list);
                System.out.println("Update successful");
            } else {
                System.err.println("You can't update because new ID you input exist in list");
            }
        }
    }

    // display employee
    private void DisplayEmployee(Employee employee) {
        System.out.format("%-10s%-15s%-15s%-15s%-30s%-12s%-23s%-10s%-10s%-10s \n", "ID", "First Name", "Last Name", "Phone", "Email", "Address", "Date Of Birth", "Sex", "Salary", "Agency");
        System.out.format("%-10s%-15s%-15s%-15s%-30s%-15s%-20s%-10s%-10s%-10s \n", employee.getID(), employee.getFirstName(), employee.getLastName(), employee.getPhone(),
                employee.getEmail(), employee.getAddress(), employee.getDOB(), employee.getSex(), employee.getSalary(), employee.getAgency());
    }

    // remove employee
    void RemoveEmployee() {
        String ID = input.InputStrNotEmpty("Enter ID:", "ID");
        Employee employee = getEmployeeFoundByID(ID);
        // if ID input not exist in list
        if (employee == null) {
            System.err.println("Not found ID");
        } else {
            list.remove(employee);
            DisplayList(list);
            System.out.println("Remove successful");
        }
    }

    // search employee by name 
    void SearchEmployee() {
        String name = input.InputName("Enter name:");
        List<Employee> listName = getListEmployee(name);
        // if name input not exist
        if (listName.isEmpty()) {
            System.err.println("Not Found name");
        } else {
            DisplayList(listName);
        }
    }

    // get list employee found by name
    private List<Employee> getListEmployee(String name) {
        List<Employee> listName = new ArrayList<>();
        // loop for traverse through list
        for (Employee employee : list) {
            String FullName = employee.getFirstName() + " " + employee.getLastName();
            // if name exist in list 
            if (name.equalsIgnoreCase(employee.getFirstName()) || name.equalsIgnoreCase(employee.getLastName()) || name.equalsIgnoreCase(FullName.trim())) {
                list.add(employee);
            }

        }
        return listName;
    }

    // sort employee by salary
    void SortEmployee() {
        Collections.sort(list);
        // display list
        DisplayList(list);
    }
}
