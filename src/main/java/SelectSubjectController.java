import Program.FileJSONReader;
import Program.StudentSubjects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

    @FXML private Button save;

    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> studentSubject = StudentSubjects.getInstance().getStudentSubjects();
    private ArrayList<String> checkSubjectY1 = new ArrayList<>();
    private ArrayList<String> checkSubjectY2 = new ArrayList<>();
    private ArrayList<String> checkSubjectY3 = new ArrayList<>();
    private ArrayList<String> checkSubjectY4 = new ArrayList<>();


    private String cal, intro, funp, digi, know, cal2, comp, func;
    private String linear, java, data, stat, datab, assem, algo;

    public void initialize() {
    }
    public void checkYear1() {
        //year 1
        if (calculus1.isSelected()) {
            cal = "Calculus I";
        }
        else if (!calculus1.isSelected()) {
            cal = "";
        }
        if (IntroCom.isSelected()) {
            intro = "Intro. to Computer Science";
        }
        else if (!IntroCom.isSelected()) {
            intro = "";
        }
        if (FunPro.isSelected()) {
            funp = "Fund. Programming Concepts";
        }
        else if (!FunPro.isSelected()) {
            funp = "";
        }
        if (Digital.isSelected()) {
            digi = "Digital Computer Logic";
        }
        else if (!Digital.isSelected()) {
            digi = "";
        }
        if (Knowledge.isSelected()) {
            know = "Knowledge of the Land";
        }
        else if (!Knowledge.isSelected()) {
            know = "";
        }
        if (calculus2.isSelected()) {
            cal2 = "Calculus II";
        }
        else if (!calculus2.isSelected()) {
            cal2 = "";
        }
        if (comPro.isSelected()) {
            comp = "Computer Programming";
        }
        else if (!comPro.isSelected()) {
            comp = "";
        }
        if (Funcom.isSelected()) {
            func = "Fundamentals of Computing";
        }
        else if (!Funcom.isSelected()) {
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
            data = "Data Structure";
        } else if (!dataStruct.isSelected()) {
            data = "";
        }
        if (statistic.isSelected()) {
            stat = "Principles of Statistics";
        } else if (!statistic.isSelected()) {
            stat = "";
        }
        if (database.isSelected()) {
            datab = "Fund. of Database Systems";
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

    @FXML public void saveOnAction(MouseEvent mouseEvent) {
        studentSubject.removeAll(checkSubjectY1);
        studentSubject.removeAll(checkSubjectY2);
        if (checkSubjectY1.size()!=0) {
            for (int i = checkSubjectY1.size() - 8; i < checkSubjectY1.size(); i++) {
                studentSubject.add(checkSubjectY1.get(i));
            }
        }
        if (checkSubjectY2.size()!=0) {
            for (int i = checkSubjectY2.size() - 7; i < checkSubjectY2.size(); i++) {
                studentSubject.add(checkSubjectY2.get(i));
            }
        }
        if (studentSubject.get(2).equals("Fund. Programming Concepts") && studentSubject.get(1).equals("")) {
            String s = "If you passed Fund. Programming Concepts, you have to pass Intro. to Computer Science before.";
            Alert(s);
        }
        if (studentSubject.get(5).equals("Calculus II") && studentSubject.get(0).equals("")) {
            String s = "If you passed Calculus II, you have to pass Calculus I before.";
            Alert(s);
        }
        if (studentSubject.get(6).equals("Computer Programming") && studentSubject.get(2).equals("") ||
                studentSubject.get(6).equals("Computer Programming") && studentSubject.get(1).equals("") ||
                studentSubject.get(6).equals("Computer Programming") && studentSubject.get(2).equals("") && studentSubject.get(1).equals("")) {
            String s = "If you passed Computer Programming, you have to pass Fund. Programming Concepts and Intro. to Computer Science before.";
            Alert(s);
        }
//        if (studentSubject.get(9).equals("Basic Linear Algebra") && studentSubject.get(5).equals("")
//                &&studentSubject.get(0).equals("")) {
//            String s = "If you passed Basic Linear Algebra, you have to Calculus I and Calculus II before.";
//            Alert(s);
//        }
        System.out.println(studentSubject);
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
