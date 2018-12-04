import Program.FileJSONReader;
import Program.Student;
import Program.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SelectSubjectController {
    private Student student;
    private ArrayList<Subject> subjects;
    private FileJSONReader fileJSONReader;

    ObservableList all = FXCollections.observableArrayList();
    ObservableList checkSubj = FXCollections.observableArrayList();

    @FXML private Button save;

    @FXML private CheckBox cal;
    @FXML private CheckBox funPro;
    @FXML private CheckBox intro;
    @FXML private CheckBox digi;
    @FXML private CheckBox knowl;

    private boolean status;

    public void initialize() {
        fileJSONReader = FileJSONReader.getInstance();
        int i = 0;
        for (Subject subj: fileJSONReader.readFileJSON()) {
            all.addAll(subj);
            checkSubj.add(subj.getBeforeThisSubject());
            System.out.println(i);
            System.out.println(subj);
            i++;
        }

    }

    public void checkSubject() {

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (status == true) {
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("You have to check subjects");

                    alert.showAndWait();
                }
            }
        });

    }

    @FXML private Button goBack;
    public void changetoPageChoose (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }
}
