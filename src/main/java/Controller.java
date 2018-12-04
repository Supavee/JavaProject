import Program.Student;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML public ChoiceBox<String> choiceBox;
    @FXML public Button submitButton;
    @FXML public TextField name;
    @FXML public TextField id;
    @FXML public Button save;

    private Student student;

    public void initialize() {
        choiceBox.getItems().add("YEAR 1");
        choiceBox.getItems().add("YEAR 2");
        choiceBox.getItems().add("YEAR 3");
        choiceBox.getItems().add("YEAR 4");

        choiceBox.setValue("Choose Year");

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
                        stage.setScene(new Scene(root, 600, 450));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

//    @FXML public void handleOnAction(ActionEvent actionEvent) throws IOException {
//        name.setPromptText("Enter your name.");
//        id.setPromptText("Enter your id.");
//        String nameStu = name.getText();
//        String IDStu = id.getId();
//
//        save.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
////                student.setStudentName(nameStu);
////                student.setStudentID(IDStu);
//
//                Stage stage = (Stage) save.getScene().getWindow();
//                Parent root = null;
//                try {
//                    root = FXMLLoader.load(getClass().getResource("SelectSubject.fxml"));
//                    stage.setTitle("Regis");
//                    stage.setScene(new Scene(root, 1000, 500));
//                    stage.show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

}
