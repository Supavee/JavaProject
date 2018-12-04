package Program;

import java.util.ArrayList;

public class Student extends Subject{
    private String studentName;
    private String studentID;
    private ArrayList<Subject> studentSubjects = new ArrayList();

    public Student(String nameSubject, String idSubject, String status, String credit,
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

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
