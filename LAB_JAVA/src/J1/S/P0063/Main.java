package J1.S.P0063;

public class Main {

    public static void main(String[] args) {
        PersonManagement management = new PersonManagement();
        // display GUI
        management.DisplayGUI();
        // create  person  information 
        Person person[] = management.CreatePersonInformation();
        // sort person array by salary ascending  
        management.sortBySalary(person);
        // display information input person  
        management.displayPersonInfo(person);

    }
}
