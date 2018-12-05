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

public class checkYear2Controller {
    @FXML
    private Button back;

    @FXML
    private CheckBox basicLinear;
    @FXML
    private CheckBox software;
    @FXML
    private CheckBox dataStruct;
    @FXML
    private CheckBox statistic;

    @FXML
    private CheckBox database;
    @FXML
    private CheckBox assembly;
    @FXML
    private CheckBox algorithm;

    @FXML
    private Button save;

    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> studentSubject = StudentSubjects.getInstance().getStudentSubjects();
    private ArrayList<String> idSubjects = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectsHavetoPass = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> finalSub = new ArrayList<>();

    private ArrayList<String> checkStatus = new ArrayList<>();

    private String linear, java, data, stat, datab, assem, algo;

    public void initialize() {
        fileJSONReader = FileJSONReader.getInstance();
        for (Subject sub : fileJSONReader.readFileJSON()) {
            idSubjects.add(sub.getIdSubject());
            subjectsHavetoPass.add(sub.getBeforeThisSubject());

        }
        System.out.println(subjectsHavetoPass);

    }

    public void checkSem1() {
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

        studentSubject.add(linear);
        studentSubject.add(java);
        studentSubject.add(data);
        studentSubject.add(stat);
        studentSubject.add(datab);
        studentSubject.add(algo);
        studentSubject.add(assem);
    }

    @FXML
    public void saveOnAction(MouseEvent mouseEvent) {
        finalSub.removeAll(studentSubject);
        for (int i = studentSubject.size() - 8; i < studentSubject.size(); i++) {
            finalSub.add(studentSubject.get(i));
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

    public void changetoPageYear2 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year2.fxml"));

        stage.setTitle("Regis");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
}

