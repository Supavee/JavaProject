package Program;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private String idSubject;
    private String status;
    private String credit;
    private String level;
    private ArrayList<String> beforeThisSubject = new ArrayList();

    public Subject(String nameSubject, String idSubject, String status, String credit, String level,
                   ArrayList<String> beforeThisSubject) {
        this.nameSubject = nameSubject;
        this.idSubject = idSubject;
        this.status = status;
        this.credit = credit;
        this.level = level;
        this.beforeThisSubject = beforeThisSubject;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public String getStatus() {
        return status;
    }

    public String getCredit() {
        return credit;
    }

    public String getLevel() {
        return level;
    }

    public ArrayList<String> getBeforeThisSubject() {
        return beforeThisSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setBeforeThisSubject(ArrayList<String> beforeThisSubject) {
        this.beforeThisSubject = beforeThisSubject;
    }

    public String toString(){
        return "NAME : " + getNameSubject() + "\n" +
                "ID : " + getIdSubject() + "\n" +
                "CREDIT : " + getCredit() + "\n";
    }
}
