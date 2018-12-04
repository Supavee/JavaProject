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
import java.util.ArrayList;


public class Controller {

    @FXML public ChoiceBox<String> choiceBox;
    @FXML public Button submitButton;
    @FXML public TextField name;
    @FXML public TextField id;
    @FXML public Button next;

    private ArrayList<Student> studentSubjects;

    public void initialize() {
        choiceBox.getItems().add("YEAR 1");
        choiceBox.getItems().add("YEAR 2");
        choiceBox.getItems().add("YEAR 3");
        choiceBox.getItems().add("YEAR 4");

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

    @FXML public void handleOnAction(ActionEvent actionEvent) throws IOException {
        name.setPromptText("Enter your name.");
        id.setPromptText("Enter your id.");
        String nameStu = name.getText();
        String IDStu = id.getId();


        Stage stage = (Stage) next.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SelectSubject.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root, 600, 450));
        stage.show();
    }


//    public void changePage (ActionEvent actionEvent) throws IOException{
//        String newStage = "";
//        if (choiceBox.getValue().equals("YEAR 1")){
//            newStage = "1";
//        } if (choiceBox.equals("YEAR 2")) {
//            newStage = "2";
//        } if (choiceBox.equals("YEAR 3")) {
//            newStage = "3";
//        } if (choiceBox.equals("YEAR 4")) {
//            newStage = "4";
//        }
//        Stage stage = (Stage) submitButton.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("year" + newStage + ".fxml"));
//        stage.setTitle("Regis");
//        stage.setScene(new Scene(root,600,450));
//        stage.show();
//    }
//
//    public void changePageYear1 (ActionEvent actionEvent) throws IOException{
//        Stage stage = (Stage) buttonYear1.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("year1.fxml"));
//        stage.setTitle("Regis");
//        stage.setScene(new Scene(root,600,450));
//        stage.show();
//    }
//
//    public void changePageYear2 (ActionEvent actionEvent) throws IOException{
//        Stage stage = (Stage) buttonYear2.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("year2.fxml"));
//        stage.setTitle("Regis");
//        stage.setScene(new Scene(root,600,450));
//        stage.show();
//    }
//
//    public void changePageYear3 (ActionEvent actionEvent) throws IOException{
//        Stage stage = (Stage) buttonYear3.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("year3.fxml"));
//        stage.setTitle("Regis");
//        stage.setScene(new Scene(root,600,450));
//        stage.show();
//    }
//
//    public void changePageYear4 (ActionEvent actionEvent) throws IOException{
//        Stage stage = (Stage) buttonYear4.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("year4.fxml"));
//        stage.setTitle("Regis");
//        stage.setScene(new Scene(root,600,450));
//        stage.show();
//    }


}
