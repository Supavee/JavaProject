import Program.FileJSONReader;
import Program.StudentSubjects;
import Program.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class checkYear3Controller {

    @FXML private Button back;

    @FXML private CheckBox operating;
    @FXML private CheckBox systemAnalysis;
    @FXML private CheckBox intellectual;
    @FXML private CheckBox seminar;

    @FXML private CheckBox inforSystem;
    @FXML private CheckBox automata;
    @FXML private CheckBox compliertech;
    @FXML private CheckBox prinInCS ;
    @FXML private CheckBox coOpEduPre ;


    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> checkSubjectY3 = new ArrayList<>();
    private ArrayList<String> idSubjects = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectsHavetoPass = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> finalSub = new ArrayList<>();

    private ArrayList<String> checkStatus = new ArrayList<>();

    private String os, system , intell, semi, info , auto, complier , princs , cooppre ;

    public void initialize() {
        fileJSONReader = FileJSONReader.getInstance();
        for (Subject sub : fileJSONReader.readFileJSON()) {
            idSubjects.add(sub.getIdSubject());
            subjectsHavetoPass.add(sub.getBeforeThisSubject());
            status.add(sub.getStatus());
        }
        System.out.println(subjectsHavetoPass);
        System.out.println(status);
    }

    public void checkYear1() {
        if (operating.isSelected()) {
            os = "Operating Systems";
        }
        else if (!operating.isSelected()) {
            os = "";
        }
        if (systemAnalysis.isSelected()) {
            system = "System Analysis & Design";
        }
        else if (!systemAnalysis.isSelected()) {
            system = "";
        }
        if (intellectual.isSelected()) {
            intell = "Fund. Programming Concepts";
        }
        else if (!intellectual.isSelected()) {
            intell = "";
        }
        if (seminar.isSelected()) {
            semi = "Digital Computer Logic";
        }
        else if (!seminar.isSelected()) {
            semi = "";
        }
        if (inforSystem.isSelected()) {
            info = "Knowledge of the Land";
        }
        else if (!inforSystem.isSelected()) {
            info = "";
        }
        if (automata.isSelected()) {
            auto = "Calculus II";
        }
        else if (!automata.isSelected()) {
            auto = "";
        }
        if (compliertech.isSelected()) {
            complier = "Computer Programming";
        }
        else if (!compliertech.isSelected()) {
            complier = "";
        }
        if (prinInCS.isSelected()) {
            princs = "Fundamentals of Computing";
        }
        else if (!prinInCS.isSelected()) {
            princs = "";
        }
        if (coOpEduPre.isSelected()) {
            cooppre = "Fundamentals of Computing";
        }
        else if (!coOpEduPre.isSelected()) {
            cooppre = "";
        }

        checkSubjectY3.add(os);
        checkSubjectY3.add(system);
        checkSubjectY3.add(intell);
        checkSubjectY3.add(semi);
        checkSubjectY3.add(info);
        checkSubjectY3.add(auto);
        checkSubjectY3.add(complier);
        checkSubjectY3.add(princs);
        checkSubjectY3.add(cooppre);

    }

    public void changetoPageYear3 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year3.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }
}

