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

public class Year3Controller implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }

    ObservableList list = FXCollections.observableArrayList();
    ObservableList list2 = FXCollections.observableArrayList();


    @FXML
    public ListView<String> subjectList;
    @FXML private ListView<String> subjectList2;
    @FXML private Label year3;
    @FXML private TextArea screen;
    @FXML private Button goBack;
    @FXML private Button checkYear3;


    private void loadData() {
        list.removeAll(list);
        list2.removeAll(list2);
        String a = "System Analysis and Design";
        String b = "Operation Systems";
        String c = "Intellectual Prop. & Profess. Ethics";
        String d = "Seminar";


        String e = "Information System Security";
        String f = "Automata Theory";
        String g = "Compiler Techniques";
        String h = "Prin. in CCs & Cloud Computing";
        String i = "Co-op. Education Preparation";


        list.addAll(a, b, c, d);
        list2.addAll(e, f, g, h, i);
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

    public void changetoPageCheck (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) checkYear3.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("checkYear3.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

}
