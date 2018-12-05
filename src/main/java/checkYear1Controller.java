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

    private ArrayList<String> studentSubject = new ArrayList<>();
    private ArrayList<String> idSubjects = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectsHavetoPass = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> finalSub = new ArrayList<>();

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
    public void checkSem1() {
        if (calculus1.isSelected()) {
            cal = "calPass";
            status.get(0).replace("NotPass","calPass");
            System.out.println(status);

        }
        else if (!calculus1.isSelected()) {
            cal = "";
        }
        if (IntroCom.isSelected()) {
            intro = " introPass";
        }
        else if (!IntroCom.isSelected()) {
            intro = "";
        }
        if (FunPro.isSelected()) {
            funp = "funProPass";
        }
        else if (!FunPro.isSelected()) {
            funp = "";
        }
        if (Digital.isSelected()) {
            digi = "digiPass";
        }
        else if (!Digital.isSelected()) {
            digi = "";
        }
        if (Knowledge.isSelected()) {
            know = "knowPass";
        }
        else if (!Knowledge.isSelected()) {
            know = "";
        }
        if (calculus2.isSelected()) {
            cal2 = "cal2Pass";
        }
        else if (!calculus2.isSelected()) {
            cal2 = "";
        }
        if (comPro.isSelected()) {
            comp = "comProPass";
        }
        else if (!comPro.isSelected()) {
            comp = "";
        }
        if (Funcom.isSelected()) {
            func = "knowPass";
        }
        else if (!Funcom.isSelected()) {
            func = "";
        }
        studentSubject.add(cal);
        studentSubject.add(intro);
        studentSubject.add(funp);
        studentSubject.add(digi);
        studentSubject.add(know);
        studentSubject.add(cal2);
        studentSubject.add(comp);
        studentSubject.add(func);
        System.out.println(studentSubject);
    }
    @FXML public void saveOnAction(MouseEvent mouseEvent) {
        finalSub.removeAll(studentSubject);
        for (int i=studentSubject.size()-8; i<studentSubject.size(); i++) {
            finalSub.add(studentSubject.get(i));
            System.out.println(finalSub);
        }
        if (finalSub.get(2).equals("funProPass") && finalSub.get(1).equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("If you passed FunPro, you have to pass IntroCom before.");

            alert.showAndWait();
        }
        if (finalSub.get(5).equals("calPass")) {

        }
    }

    public void Alert(String sub) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("You must select" + sub + " the data first!");

        alert.showAndWait();
    }

    public void changetoPageYear3 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year3.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

    public void changetoPageYear1 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year1.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


}
