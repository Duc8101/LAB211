package J1.S.P0101;

public class Employee implements Comparable<Employee> {

    private String ID;
    private String FirstName;
    private String LastName;
    private String phone;
    private String email;
    private String address;
    private String DOB;
    private String sex;
    private double salary;
    private String agency;

    public Employee() {
    }

    public Employee(String ID, String FirstName, String LastName, String phone, String email, String address, String DOB, String sex, double salary, String agency) {
        this.ID = ID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.agency = agency;
    }

    public String getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDOB() {
        return DOB;
    }

    public String getSex() {
        return sex;
    }

    public double getSalary() {
        return salary;
    }

    public String getAgency() {
        return agency;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    // sort employee order by salary ASC
    @Override
    public int compareTo(Employee o) {
        if (salary - o.salary > 0) {
            return 1;
        }
        if (salary - o.salary < 0) {
            return -1;
        }
        return 0;
    }

}
