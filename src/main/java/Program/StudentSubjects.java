package Program;

import java.util.ArrayList;

public class StudentSubjects extends Subject{
    private String studentName;
    private String studentID;
    private ArrayList<Subject> studentSubjects = new ArrayList();

    public StudentSubjects(String nameSubject, String idSubject, String status, String credit,
                           String level, ArrayList<String> beforeThisSubject, String studentName,
                           String studentID, ArrayList<Subject> studentSubjects) {
        super(nameSubject, idSubject, status, credit, level, beforeThisSubject);
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

    public ArrayList<Subject> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setStudentSubjects(ArrayList<Subject> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
