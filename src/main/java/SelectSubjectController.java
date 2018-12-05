import Program.FileJSONReader;
import Program.StudentSubjects;
import Program.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SelectSubjectController {
    @FXML private Button back;

    @FXML private CheckBox calculus1;
    @FXML private CheckBox FunPro;
    @FXML private CheckBox IntroCom;
    @FXML private CheckBox Digital;
    @FXML private CheckBox Knowledge;

    @FXML private CheckBox calculus2;
    @FXML private CheckBox comPro;
    @FXML private CheckBox Funcom;

    @FXML private CheckBox basicLinear;
    @FXML private CheckBox software;
    @FXML private CheckBox dataStruct;
    @FXML private CheckBox statistic;

    @FXML private CheckBox database;
    @FXML private CheckBox assembly;
    @FXML private CheckBox algorithm;

    @FXML private CheckBox systemAnalysis;
    @FXML private CheckBox operating;
    @FXML private CheckBox intellectual;
    @FXML private CheckBox seminar;

    @FXML private CheckBox inforSystem;
    @FXML private CheckBox automata;
    @FXML private CheckBox compliertech;
    @FXML private CheckBox prinInCS ;
    @FXML private CheckBox coOpEduPre ;

    @FXML private CheckBox coOpEdu;
    @FXML private CheckBox csProject;

    @FXML private Button save;
    @FXML private TextArea showSub;

    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> studentSubject = StudentSubjects.getInstance().getStudentSubjects();

    private ArrayList<ArrayList<String>> beforeThisSubject = new ArrayList<>();
    private ArrayList<Subject> allSubjects = new ArrayList<>();
    private ArrayList<String> checkSubjectY1 = new ArrayList<>();
    private ArrayList<String> checkSubjectY2 = new ArrayList<>();
    private ArrayList<String> checkSubjectY3 = new ArrayList<>();
    private ArrayList<String> checkSubjectY4 = new ArrayList<>();

    private String cal, intro, funp, digi, know, cal2, comp, func;
    private String linear, java, data, stat, datab, assem, algo;
    private String os, system, intell, semi, info, auto, complier, princs, cooppre;
    private String coOp,csPro ;

    public void initialize() {
        fileJSONReader = FileJSONReader.getInstance();
        allSubjects = fileJSONReader.readFileJSON();
        for (Subject sub : allSubjects) {
            beforeThisSubject.add(sub.getBeforeThisSubject());
            studentSubject.add("");
        }

//        for(int i = 0; i < allSubjects.size(); i++){
//            if(allSubjects.get(i).getStatus().equals(false))
//                allSubjects.get(i).setStatus(true);
//            System.out.println(allSubjects.get(i).getStatus());
//        }

    }
    public void checkYear1() {
        //year 1
        if (calculus1.isSelected()) {
            cal = "Calculus I";
        } else if (!calculus1.isSelected()) {
            cal = "";
        }
        if (IntroCom.isSelected()) {
            intro = "Intro. to Computer Science";
        } else if (!IntroCom.isSelected()) {
            intro = "";
        }
        if (FunPro.isSelected()) {
            funp = "Fund. Programming Concepts";
        } else if (!FunPro.isSelected()) {
            funp = "";
        }
        if (Digital.isSelected()) {
            digi = "Digital Computer Logic";
        } else if (!Digital.isSelected()) {
            digi = "";
        }
        if (Knowledge.isSelected()) {
            know = "Knowledge of the Land";
        } else if (!Knowledge.isSelected()) {
            know = "";
        }
        if (calculus2.isSelected()) {
            cal2 = "Calculus II";
        } else if (!calculus2.isSelected()) {
            cal2 = "";
        }
        if (comPro.isSelected()) {
            comp = "Computer Programming";
        } else if (!comPro.isSelected()) {
            comp = "";
        }
        if (Funcom.isSelected()) {
            func = "Fundamentals of Computing";
        } else if (!Funcom.isSelected()) {
            func = "";
        }
        checkSubjectY1.add(cal);
        checkSubjectY1.add(intro);
        checkSubjectY1.add(funp);
        checkSubjectY1.add(digi);
        checkSubjectY1.add(know);
        checkSubjectY1.add(cal2);
        checkSubjectY1.add(comp);
        checkSubjectY1.add(func);
    }

    public void checkYear2() {
        //year2
        if (basicLinear.isSelected()) {
            linear = "Basic Linear Algebra";
        } else if (!basicLinear.isSelected()) {
            linear = "";
        }
        if (software.isSelected()) {
            java = "Software Construction";
        } else if (!software.isSelected()) {
            java = "";
        }
        if (dataStruct.isSelected()) {
            data = "Data Structures";
        } else if (!dataStruct.isSelected()) {
            data = "";
        }
        if (statistic.isSelected()) {
            stat = "Principles of Statistics";
        } else if (!statistic.isSelected()) {
            stat = "";
        }
        if (database.isSelected()) {
            datab = "Fundamental of Database Systems";
        } else if (!database.isSelected()) {
            datab = "";
        }
        if (algorithm.isSelected()) {
            algo = "Algorithms Design and Analysis";
        } else if (!algorithm.isSelected()) {
            algo = "";
        }
        if (assembly.isSelected()) {
            assem = "Assembly Lang. and Comp. Arch.";
        } else if (!assembly.isSelected()) {
            assem = "";
        }
        checkSubjectY2.add(linear);
        checkSubjectY2.add(java);
        checkSubjectY2.add(data);
        checkSubjectY2.add(stat);
        checkSubjectY2.add(datab);
        checkSubjectY2.add(algo);
        checkSubjectY2.add(assem);
    }

    public void checkYear3() {
        if (systemAnalysis.isSelected()) {
            system = "System Analysis & Design";
        }
        else if (!systemAnalysis.isSelected()) {
            system = "";
        }
        if (operating.isSelected()) {
            os = "Operating Systems";
        }
        else if (!operating.isSelected()) {
            os = "";
        }
        if (intellectual.isSelected()) {
            intell = "Intellectual Prop. & Profess. Ethics";
        }
        else if (!intellectual.isSelected()) {
            intell = "";
        }
        if (seminar.isSelected()) {
            semi = "Seminar";
        }
        else if (!seminar.isSelected()) {
            semi = "";
        }
        if (inforSystem.isSelected()) {
            info = "Information System Security";
        }
        else if (!inforSystem.isSelected()) {
            info = "";
        }
        if (automata.isSelected()) {
            auto = "Automata Theory";
        }
        else if (!automata.isSelected()) {
            auto = "";
        }
        if (compliertech.isSelected()) {
            complier = "Compiler Techniques";
        }
        else if (!compliertech.isSelected()) {
            complier = "";
        }
        if (prinInCS.isSelected()) {
            princs = "Principles in CCs & Cloud Computing";
        }
        else if (!prinInCS.isSelected()) {
            princs = "";
        }
        if (coOpEduPre.isSelected()) {
            cooppre = "Cooperative Education Preparation";
        }
        else if (!coOpEduPre.isSelected()) {
            cooppre = "";
        }
        checkSubjectY3.add(system);
        checkSubjectY3.add(os);
        checkSubjectY3.add(intell);
        checkSubjectY3.add(semi);
        checkSubjectY3.add(info);
        checkSubjectY3.add(auto);
        checkSubjectY3.add(complier);
        checkSubjectY3.add(princs);
        checkSubjectY3.add(cooppre);
    }

    public void checkYear4() {
        if (coOpEdu.isSelected()) {
            coOp = "Co-op Education";
        } else if (!coOpEdu.isSelected()) {
            coOp = "";
        }
        if (csProject.isSelected()) {
            csPro = "CS Project";
        } else if (!csProject.isSelected()) {
            csPro = "";
        }
        checkSubjectY4.add(coOp);
        checkSubjectY4.add(csPro);
    }

    @FXML public void saveOnAction(MouseEvent mouseEvent) {
        studentSubject.removeAll(checkSubjectY1);
        studentSubject.removeAll(checkSubjectY2);
        studentSubject.removeAll(checkSubjectY3);
        studentSubject.removeAll(checkSubjectY4);
        if (checkSubjectY1.size()!=0) {
            for (int i = checkSubjectY1.size() - 8; i < checkSubjectY1.size(); i++) {
                studentSubject.add(checkSubjectY1.get(i));
            }
        }
        if (checkSubjectY2.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY2.size() - 7; i < checkSubjectY2.size(); i++) {
                studentSubject.add(checkSubjectY2.get(i));
            }
        }
        if (checkSubjectY3.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<7; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY3.size() - 9; i < checkSubjectY3.size(); i++) {
                studentSubject.add(checkSubjectY3.get(i));
            }
        }
        if (checkSubjectY4.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<7; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<9; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY4.size() - 2; i < checkSubjectY4.size(); i++) {
                studentSubject.add(checkSubjectY4.get(i));
            }
        }
        System.out.println(studentSubject);
    }

    public void checkPass() {
        for (String s : studentSubject) {
            for (Subject subject : allSubjects) {
                if (subject.getNameSubject().equals(s)){
                    if (subject.getBeforeThisSubject().isEmpty()){
                        subject.setStatus(true);
                    }
                    else {
                        int beforeSub = subject.getBeforeThisSubject().size();
                        for (String s1 : subject.getBeforeThisSubject()) {
                            for (Subject allSubject : allSubjects) {
                                if (allSubject.getNameSubject().equals(s1)){
                                    if (allSubject.getStatus()){
                                        beforeSub--;
                                    }
                                }
                            }
                        }
                        if (beforeSub == 0){
                            subject.setStatus(true);
                        }
                    }
                }
            }
        }
    }
    @FXML public void save(MouseEvent mouseEvent) {
        checkPass();
        String setText = "" ;
        for (Subject subject : allSubjects) {
            setText += "Subject: "+ subject.getNameSubject()
                    + "   Status: " ;
            if (subject.getStatus()){
                setText+= "Pass\n";
            }
            else{
                setText+="Not pass\n";
            }
        }
        showSub.setText(setText);
    }

    public void Alert(String sub) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(sub);

        alert.showAndWait();
    }

    public void changetoPageChoose (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


}
