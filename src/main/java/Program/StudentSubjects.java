package Program;

import java.util.ArrayList;

public class StudentSubjects{
    private String studentName;
    private String studentID;
    private ArrayList<String> studentSubjects = new ArrayList();

    public StudentSubjects(String studentName, String studentID, ArrayList<String> studentSubjects) {
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

    public ArrayList<String> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentSubjects(ArrayList<String> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }

    @Override
    public String toString() {
        String sub = getStudentSubjects().toString();
        return sub;
    }
}
