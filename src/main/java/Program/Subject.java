package Program;

import java.util.ArrayList;

public class Subject {
    private String nameSubject;
    private String idSubject;
    private String status;
    private ArrayList<String> beforeThisSubject = new ArrayList();


    public Subject(String nameSubject, String idSubject, String status, ArrayList<String> beforeThisSubject) {
        this.nameSubject = nameSubject;
        this.idSubject = idSubject;
        this.status = status;

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

    public void setBeforeThisSubject(ArrayList<String> beforeThisSubject) {
        this.beforeThisSubject = beforeThisSubject;
    }

    public String toString(){
        return "NAME : " + getNameSubject() + "\n" +
                "ID : " + getIdSubject() + "\n" +
                "STATUS : " + getStatus() + "\n";
    }
}
