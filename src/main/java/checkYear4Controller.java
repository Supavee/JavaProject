import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;

public class checkYear4Controller {
    @FXML private Button back;
    @FXML private CheckBox calculus1;
    @FXML private CheckBox FunPro;
    @FXML private CheckBox IntroCom;
    @FXML private CheckBox Digital;
    @FXML private CheckBox Knowledge;



    public void changetoPageYear4 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year4.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

}
