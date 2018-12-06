package Program;

import java.util.ArrayList;

public class StudentSubjects{
    private String studentName;
    private String studentID;
    private ArrayList<String> studentSubjects = new ArrayList();

    private static StudentSubjects instance = new StudentSubjects();

    private StudentSubjects(){}

    public static StudentSubjects getInstance(){
        if(instance == null)
            instance = new StudentSubjects();
        return instance;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public ArrayList<String> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(ArrayList<String> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }

    @Override
    public String toString() {
        String sub = getStudentName() + " (" + getStudentID() + ") has sign in.";
        return sub;
    }
}
