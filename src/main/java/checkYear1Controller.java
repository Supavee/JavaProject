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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class checkYear1Controller {
    @FXML private Button back;
    @FXML private CheckBox calculus1;
    @FXML private CheckBox FunPro;
    @FXML private CheckBox IntroCom;
    @FXML private CheckBox Digital;
    @FXML private CheckBox Knowledge;

    @FXML private CheckBox calculus2;
    @FXML private CheckBox comPro;
    @FXML private CheckBox Funcom;

    @FXML private Button save;

    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> studentSubject = StudentSubjects.getInstance().getStudentSubjects();
    private ArrayList<String> idSubjects = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectsHavetoPass = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> checkSubject = new ArrayList<>();

    private ArrayList<String> checkStatus = new ArrayList<>();

    private String cal,intro,funp,digi,know,cal2,comp,func;

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
        checkSubject.add(cal);
        checkSubject.add(intro);
        checkSubject.add(funp);
        checkSubject.add(digi);
        checkSubject.add(know);
        checkSubject.add(cal2);
        checkSubject.add(comp);
        checkSubject.add(func);
    }
    @FXML public void saveOnAction(MouseEvent mouseEvent) {
        studentSubject.removeAll(checkSubject);
        for (int i=checkSubject.size()-8; i<checkSubject.size(); i++) {
            studentSubject.add(checkSubject.get(i));
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
        System.out.println(studentSubject);
    }

    public void Alert(String sub) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(sub);

        alert.showAndWait();
    }

    public void changetoPageYear1 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year1.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


}
