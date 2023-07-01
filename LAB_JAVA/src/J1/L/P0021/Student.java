package J1.L.P0021;

public class Student implements Comparable<Student> {

    private String StudentName;
    private String semester;
    private String ID;
    private String CourseName;

    public Student() {
    }

    public Student(String ID, String StudentName, String semester, String CourseName) {
        this.StudentName = StudentName;
        this.semester = semester;
        this.ID = ID;
        this.CourseName = CourseName;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getSemester() {
        return semester;
    }

    public String getID() {
        return ID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    @Override
    public int compareTo(Student o) {
        return this.StudentName.compareTo(o.StudentName);
    }

}
