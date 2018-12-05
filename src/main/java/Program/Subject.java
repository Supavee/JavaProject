package Program;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private String idSubject;
    private boolean status;
    private String credit;
    private String level;
    private ArrayList<String> beforeThisSubject = new ArrayList();
    private String info;

    public Subject(String nameSubject, String idSubject, String credit, String level,
                   ArrayList<String> beforeThisSubject, String info) {
        this.nameSubject = nameSubject;
        this.idSubject = idSubject;
        this.status = false;
        this.credit = credit;
        this.level = level;
        this.beforeThisSubject = beforeThisSubject;
        this.info = info;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public boolean getStatus() {
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

    public String getInfo() {return info; }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public void setStatus(boolean status) {
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

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString(){
        return "NAME : " + getNameSubject() + "\n" +
                "ID : " + getIdSubject() + "\n" +
                "CREDIT : " + getCredit() + "\n" +
                "INFO : " + getInfo();
    }
}
