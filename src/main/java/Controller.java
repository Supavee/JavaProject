import Program.StudentSubjects;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Controller {

    @FXML public ChoiceBox<String> choiceBox;
    @FXML public Button submitButton;
    @FXML public TextField name;
    @FXML public TextField id;
    @FXML public Button saveNameID;
    @FXML public TextArea stuSub;
    @FXML public Button register;
    private StudentSubjects studentSubjects;


    public void initialize() {
        choiceBox.getItems().add("YEAR 1");
        choiceBox.getItems().add("YEAR 2");
        choiceBox.getItems().add("YEAR 3");
        choiceBox.getItems().add("YEAR 4");
        choiceBox.setValue("CHOOSE YEAR");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String newStage = "";
                if (choiceBox.getValue().equals("YEAR 1")){
                    newStage = "1";
                } if (choiceBox.getValue().equals("YEAR 2")) {
                    newStage = "2";
                } if (choiceBox.getValue().equals("YEAR 3")) {
                    newStage = "3";
                } if (choiceBox.getValue().equals("YEAR 4")) {
                    newStage = "4";
                }

                if (newStage.equals("")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("You must select the data first!");

                    alert.showAndWait();
                }
                else {
                    Stage stage = (Stage) submitButton.getScene().getWindow();
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("year"+ newStage +".fxml"));
                        stage.setTitle("Regis");
                        stage.setScene(new Scene(root, 600, 400));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @FXML public void changetoSelectSubject() throws IOException {
        Stage stage = (Stage) register.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SelectSubject.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,1000,500));
        stage.show();
    }

    @FXML public void handleOnAction(ActionEvent actionEvent) {
        String nameStu = name.getText();
        String IDStu = id.getId();
        studentSubjects = StudentSubjects.getInstance();
        studentSubjects.setStudentID(IDStu);
        studentSubjects.setStudentName(nameStu);
        studentSubjects.setStudentSubjects(new ArrayList<String>());
        name.setText("");
        id.setText("");
    }

    @FXML public void setSubjectArea(MouseEvent mouseEvent) {
        stuSub.setText(studentSubjects.toString());
    }

    public StudentSubjects getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(StudentSubjects studentSubjects) {
        this.studentSubjects = studentSubjects;
    }
}
