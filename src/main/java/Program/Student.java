package Program;

import Program.Subject;

import java.util.ArrayList;
import java.util.Collection;

public class Student {
    private String studentName;
    private String studentID;
    private ArrayList<Subject> studentSubjects = new ArrayList();

    public Student(String studentName, String studentID, ArrayList<Subject> studentSubjects) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.studentSubjects = studentSubjects;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    


}
