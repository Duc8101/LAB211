package J1.S.P0063;

public class PersonManagement {

    private final Inputter input = new Inputter();
    private final static int MAX_PERSON = 3;

    void DisplayGUI() {
        System.out.println("=====Management Person programer=====");
    }

    // input information person
    private Person inputPersonInfo() {
        System.out.println("Input information of person");
        String name = input.InputName();
        String address = input.InputAddress();
        double salary = input.InputSalary();
        Person person = new Person(name, address, salary);
        return person;
    }

    // create  person  information 
    Person[] CreatePersonInformation() {
        Person person[] = new Person[MAX_PERSON];
        // loop for traverse through person
        for (int i = 0; i < person.length; i++) {
            person[i] = inputPersonInfo();
        }
        return person;
    }

    // swap person
    private void SwapPerson(Person[] person, int i, int j) {
        Person temp = person[i];
        person[i] = person[j];
        person[j] = temp;
    }

    //sort person array by salary ascending
    void sortBySalary(Person[] person) {
        // loop for traverse through array 
        for (int i = 0; i < person.length; i++) {
            //loop traverse the array of unsorted person
            for (int j = 0; j < person.length - i - 1; j++) {
                // if salary person is bigger than the following salary person
                if (person[j].getSalary() > person[j + 1].getSalary()) {
                    // swap person[j] and person[j+1]
                    SwapPerson(person, j, j + 1);
                }
            }
        }
    }

    // display information input person
    protected void displayPersonInfo(Person[] person) {
        // loop for traverse through person
        for (int i = 0; i < person.length; i++) {
            System.out.println("Information of Person you have entered");
            System.out.println("Name:" + person[i].getName());
            System.out.println("Address:" + person[i].getAddress());
            System.out.println("Salary:" + person[i].getSalary());
            if (i == 2) {
                break;
            }
            System.out.println();

        }
    }

}
