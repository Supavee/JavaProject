import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Year4Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();


    @FXML public ListView<String> subjectList;
    @FXML private ListView<String> subjectList2;
    @FXML private Label year4;
    @FXML private TextArea screen;
    @FXML private Button goBack;



    private void loadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        String a = "Co-op. Education";


        String e = "CS Project";



        list.addAll(a);
        list2.addAll(e);
        subjectList.getItems().addAll(list);
        subjectList2.getItems().addAll(list2);

    }

    public void changetoPageChoose (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goBack.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }
}
