import Program.FileJSONReader;
import Program.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Year2Controller implements Initializable {
    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();

    private ArrayList<Subject> subjects;
    private FileJSONReader fileJSONReader ;
    @FXML public ListView<Subject> subjectList;
    @FXML private ListView<Subject> subjectList2;
    @FXML private Label year2;
    @FXML private TextArea screen;
    @FXML private Button goBack;
    @FXML private Label level;
    @FXML private Button checkYear2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileJSONReader = FileJSONReader.getInstance();
        loadData();

    }

    private void loadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        int i = 1;
        for (Subject sub : fileJSONReader.readFileJSON()) {
            if (8<i && i<=15) {
                list.add(sub);
                i++;
            }
            else if (i>12 && i<=22) {
                list2.add(sub);
                i++;
            }
            i++;
        }
        subjectList.getItems().addAll(list);
        subjectList.setCellFactory(param -> new ListCell<Subject>(){
            protected void updateItem(Subject item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getNameSubject() == null) {
                    setText(null);
                } else {
                    setText(item.getNameSubject());
                }
            }
        });
        subjectList2.getItems().addAll(list2);
        subjectList2.setCellFactory(param -> new ListCell<Subject>(){
            protected void updateItem(Subject item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getNameSubject() == null) {
                    setText(null);
                } else {
                    setText(item.getNameSubject());
                }
            }
        });
    }

    @FXML
    public void displaySelected(MouseEvent event){
        Subject selectSubject = subjectList.getSelectionModel().getSelectedItem();
        if (selectSubject.getLevel().equals("hard")) {
            level.setStyle("-fx-border-color:black; -fx-background-color: red;");
            level.setText("HARD");
        } else if (selectSubject.getLevel().equals("normal")) {
            level.setStyle("-fx-border-color:black; -fx-background-color: blue;");
            level.setText("NORMAL");
        } else {
            level.setStyle("-fx-border-color:black; -fx-background-color: green;");
            level.setText("EASY");
        }
        screen.setText(selectSubject.toString());
        System.out.println(selectSubject.toString());

    }

    @FXML
    public void displaySelected2(MouseEvent event){
        Subject selectSubject2 = subjectList2.getSelectionModel().getSelectedItem();
        if (selectSubject2.getLevel().equals("hard")) {
            level.setStyle("-fx-border-color:black; -fx-background-color: red;");
            level.setText("HARD");
        } else if (selectSubject2.getLevel().equals("normal")) {
            level.setStyle("-fx-border-color:black; -fx-background-color: blue;");
            level.setText("NORMAL");
        } else {
            level.setStyle("-fx-border-color:black; -fx-background-color: green;");
            level.setText("EASY");
        }
        screen.setText(selectSubject2.toString());
        System.out.println(selectSubject2.toString());
    }

    public void changetoPageChoose (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

}