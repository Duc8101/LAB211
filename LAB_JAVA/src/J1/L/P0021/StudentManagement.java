package J1.L.P0021;

import java.util.*;

public class StudentManagement {

    private final List<Student> listStudent = new ArrayList<>();
    private final Inputter input = new Inputter();

    public StudentManagement() {

    }

    // create student  
    void CreateStudent() {
        int count = 1;// number of student
        // loop until stop create student
        while (true) {
            String ID = input.InputID("Enter ID:");
            String StudentName;
            boolean match;
            // loop until input name match to ID
            do {
                StudentName = input.InputName("Enter StudentName:");
                match = isNameAndIDMatch(ID, StudentName);
            } while (match == false);
            String semester = input.InputSemester("Enter semester:");
            String CourseName = input.InputCourse("Enter CourseName(Java,.Net,C/C++):");
            Student student = new Student(ID, StudentName, semester, CourseName);
            // if student input exist
            if (isStudentExist(ID, StudentName, semester, CourseName)) {
                System.err.println("Duplicate Student");
            } else {
                listStudent.add(student);
                DisplayList(listStudent);
                count++;
                // if more than 10 student
                if (count > 10) {
                    String choice = input.InputYesNo("Do you want to continue (Y/N): ");
                    // if input N(no)
                    if (choice.equalsIgnoreCase("N")) {
                        return;
                    }
                }
            }

        }
    }

    // check ID and name match
    private boolean isNameAndIDMatch(String ID, String name) {
        // loop for traverse through student list
        for (Student student : listStudent) {
            if (ID.equalsIgnoreCase(student.getID()) && !name.equalsIgnoreCase(student.getStudentName())) {
                System.err.println("Name and ID not match");
                return false;
            }

        }
        return true;
    }

    // check student exist 
    private boolean isStudentExist(String ID, String StudentName, String semester, String CourseName) {
        // loop for traverse through student list
        for (Student student : listStudent) {
            // if student exist
            if (ID.equalsIgnoreCase(student.getID()) && StudentName.equalsIgnoreCase(student.getStudentName())
                    && semester.equalsIgnoreCase(student.getSemester()) && CourseName.equalsIgnoreCase(student.getCourseName())) {
                return true;
            }

        }
        return false;
    }

    // display student list
    private void DisplayList(List<Student> listStudent) {
        System.out.println("----------------------- List Student ------------------------------");
        System.out.format("%-15s%-20s%-15s%-15s\n", "StudentID", "Student Name", "Semester", "Course Name");
        // loop for traverse through list all students
        for (Student student : listStudent) {
            System.out.format("%-15s%-20s%-15s%-15s\n", student.getID(), student.getStudentName(), student.getSemester(), student.getCourseName());
        }
    }

    // get list student found by name
    private List<Student> getListStudentFoundByName(String name) {
        List<Student> listStudentByName = new ArrayList<>();
        // loop for traverse through list student
        for (Student student : listStudent) {
            // if name student exist
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listStudentByName.add(student);
            }

        }
        return listStudentByName;
    }

    // find and sort student by name
    void FindAndSortStudentByName() {
        // if list empty
        if (listStudent.isEmpty()) {
            System.err.println("List empty");
        } else {
            String name = input.InputName("Enter name to find:");
            List<Student> listStudentByName = getListStudentFoundByName(name);
            // if name not exist in list
            if (listStudentByName.isEmpty()) {
                System.err.println("Not found name");
            } else {
                Collections.sort(listStudentByName);
                System.out.println("--------------- List After Sort ---------------");
                System.out.format("%-20s%-15s%-15s\n", "Student Name", "Semester", "Course Name");
                // loop for traverse through list
                for (Student StudentFoundByName : listStudentByName) {
                    System.out.format("%-20s%-15s%-15s\n", StudentFoundByName.getStudentName(), StudentFoundByName.getSemester(), StudentFoundByName.getCourseName());
                }
            }
        }

    }

    // get list student found by id
    private List<Student> getListStudentFoundByID(String ID) {
        List<Student> list = new ArrayList<>();
        // loop for traverse through list all students
        for (Student student : listStudent) {
            // if ID input exist in list
            if (ID.equalsIgnoreCase(student.getID())) {
                list.add(student);
            }
        }
        return list;
    }

    // dislay student list found by ID
    private void DisplayListStudentFoundByID(List<Student> listStudent) {
        int StudentNo = 1;// number of student
        System.out.println("----------------------- List Student ------------------------------");
        System.out.format("%-5s%-15s%-20s%-15s%-15s\n", "S.No", "Student ID", "Student Name", "Semester", "Course Name");
        // loop for traverse all student
        for (Student student : listStudent) {
            System.out.format("%-5s%-15s%-20s%-15s%-15s\n", StudentNo, student.getID(), student.getStudentName(), student.getSemester(), student.getCourseName());
            StudentNo++;
        }
        System.out.println();
    }

    // get student
    private Student getStudent(List<Student> listStudent) {
        int NoOfStudent = input.InputOption(1, listStudent.size(), "Enter No of Student:");
        return listStudent.get(NoOfStudent - 1);
    }

    // update or delete student
    protected void UpdateOrDeleteStudent() {
        //if list empty 
        if (listStudent.isEmpty()) {
            System.err.println("List empty.");
        } else {
            String ID = input.InputID("Enter ID:");
            List<Student> ListStudentById = getListStudentFoundByID(ID);
            // if ID input not exist 
            if (ListStudentById.isEmpty()) {
                System.err.println("Not Found ID");
            } else {
                DisplayListStudentFoundByID(ListStudentById);
                Student student = getStudent(ListStudentById);
                String choice = input.InputUD("Do you want to update (U) or delete (D) student: ");
                // if choose U(update)
                if (choice.equalsIgnoreCase("U")) {
                    String NewID = input.InputID("Enter New ID:");
                    String NewStudentName = input.InputName("Enter New StudentName:");
                    String NewSemester = input.InputSemester("Enter New Semester:");
                    String NewCourseName = input.InputCourse("Enter New CourseName(Java,.Net,C/C++):");
                    // if information update not change
                    if (!isInformationUpdateChange(student, NewID, NewStudentName, NewSemester, NewCourseName)) {
                        System.err.println("Information update not change");
                        // if student update exist in list   
                    } else if (isStudentExist(NewID, NewStudentName, NewSemester, NewCourseName)) {
                        System.err.println("Student existed");
                    } else {
                        student.setID(NewID);
                        student.setStudentName(NewStudentName);
                        student.setSemester(NewSemester);
                        student.setCourseName(NewCourseName);
                        DisplayList(listStudent);
                        System.out.println("Update successful");
                    }
                    // if choose D(delete)
                } else if (choice.equalsIgnoreCase("D")) {
                    listStudent.remove(student);
                    DisplayList(listStudent);
                    System.out.println("Delete successful");
                }
            }
        }

    }

    // check information update change or not
    private boolean isInformationUpdateChange(Student student, String id,
            String name, String semester, String course) {
        return !(id.equalsIgnoreCase(student.getID())
                && name.equalsIgnoreCase(student.getStudentName())
                && semester.equalsIgnoreCase(student.getSemester())
                && course.equalsIgnoreCase(student.getCourseName()));
    }

    // report student 
    void ReportStudent() {
        // if list empty
        if (listStudent.isEmpty()) {
            System.err.println("List empty");
        } else {
            List<Report> listReport = new ArrayList<>();
            // loop for traverse through list
            for (int i = 0; i < listStudent.size(); i++) {
                int total = 0;// total of course
                // loop for traverse through list
                for (int j = 0; j < listStudent.size(); j++) {
                    if (listStudent.get(i).getStudentName().equalsIgnoreCase(listStudent.get(j).getStudentName())
                            && listStudent.get(i).getCourseName().equalsIgnoreCase(listStudent.get(j).getCourseName())) {
                        total++;
                    }
                }
                // if StudentName and CourseName not exist in list report
                if (!isReportExist(listReport, listStudent.get(i).getStudentName(), listStudent.get(i).getCourseName())) {
                    Report report = new Report(listStudent.get(i).getStudentName(), listStudent.get(i).getCourseName(), total);
                    listReport.add(report);
                }
            }
            // display list report
            System.out.println("--------------- List Report ---------------");
            System.out.format("%-20s|%-6s|%-7s\n", "Student Name", "Course", "Total");
            // loop traversal all report in list report
            for (Report report : listReport) {
                System.out.format("%-20s|%-6s|%-7s\n", report.getStudentName(), report.getCourseName(), report.getTotalCourse());
            }
        }

    }

    // check report exist
    private boolean isReportExist(List<Report> ListReport, String name, String course) {
        // loop for traverse through list report
        for (Report report : ListReport) {
            // if name,course,total of course of next report existed in report list
            if (name.equalsIgnoreCase(report.getStudentName()) && course.equalsIgnoreCase(report.getCourseName())) {
                return true;
            }
        }
        return false;
    }
}
