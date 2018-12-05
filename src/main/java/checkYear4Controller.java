import Program.FileJSONReader;
import Program.StudentSubjects;
import Program.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class checkYear4Controller {
    @FXML private Button back;
    @FXML private CheckBox coOpEdu;
    @FXML private CheckBox csProject;

    private FileJSONReader fileJSONReader;
    private StudentSubjects studentSubjects;

    private ArrayList<String> checkSubjectY3 = new ArrayList<>();
    private ArrayList<String> idSubjects = new ArrayList<>();
    private ArrayList<ArrayList<String>> subjectsHavetoPass = new ArrayList<>();
    private ArrayList<String> status = new ArrayList<>();
    private ArrayList<String> finalSub = new ArrayList<>();

    private ArrayList<String> checkStatus = new ArrayList<>();

    private String coOp,csPro ;

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

    public void checkYear1() {
        if (coOpEdu.isSelected()) {
            coOp = "Co-op Education";
        } else if (!coOpEdu.isSelected()) {
            coOp = "";
        }
        if (csProject.isSelected()) {
            csPro = "CS Project";
        } else if (!csProject.isSelected()) {
            csPro = "";
        }

        checkSubjectY3.add(coOp);
        checkSubjectY3.add(csPro);
    }





    public void changetoPageYear4 (ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("year4.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }

}
