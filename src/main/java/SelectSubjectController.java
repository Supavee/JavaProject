import Program.FileJSONReader;
import Program.Subject;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class SelectSubjectController {
    @FXML private CheckBox calculus1;
    @FXML private CheckBox FunPro;
    @FXML private CheckBox IntroCom;
    @FXML private CheckBox Digital;
    @FXML private CheckBox Knowledge;

    @FXML private CheckBox calculus2;
    @FXML private CheckBox comPro;
    @FXML private CheckBox Funcom;

    @FXML private CheckBox basicLinear;
    @FXML private CheckBox software;
    @FXML private CheckBox dataStruct;
    @FXML private CheckBox statistic;

    @FXML private CheckBox database;
    @FXML private CheckBox assembly;
    @FXML private CheckBox algorithm;

    @FXML private CheckBox systemAnalysis;
    @FXML private CheckBox operating;
    @FXML private CheckBox intellectual;
    @FXML private CheckBox seminar;

    @FXML private CheckBox inforSystem;
    @FXML private CheckBox automata;
    @FXML private CheckBox compliertech;
    @FXML private CheckBox prinInCS ;
    @FXML private CheckBox coOpEduPre ;

    @FXML private CheckBox coOpEdu;
    @FXML private CheckBox csProject;

    @FXML private Button save;
    @FXML private Button show;
    @FXML private Button back;
    @FXML private TextArea showSubPass;
    @FXML private TextArea showSubNotPass;
    @FXML private Button getPDF;

    private FileJSONReader fileJSONReader;

    private ArrayList<String> studentSubject = new ArrayList<>();

    private ArrayList<ArrayList<String>> beforeThisSubject = new ArrayList<>();
    private ArrayList<Subject> allSubjects = new ArrayList<>();
    private ArrayList<String> checkSubjectY1 = new ArrayList<>();
    private ArrayList<String> checkSubjectY2 = new ArrayList<>();
    private ArrayList<String> checkSubjectY3 = new ArrayList<>();
    private ArrayList<String> checkSubjectY4 = new ArrayList<>();

    private String cal, intro, funp, digi, know, cal2, comp, func;
    private String linear, java, data, stat, datab, assem, algo;
    private String os, system, intell, semi, info, auto, complier, princs, cooppre;
    private String coOp,csPro ;

    public void initialize() {
        // read JSON file for build SelectSubjectController object
        fileJSONReader = FileJSONReader.getInstance();
        allSubjects = fileJSONReader.readFileJSON();
        for (Subject sub : allSubjects) {
            beforeThisSubject.add(sub.getBeforeThisSubject());
        }

        showSubNotPass.setText("You have to select and save the data to show first.");
        showSubPass.setText("You have to select and save the data to show first.");

        try {
            createFilePDF();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void checkYear1() {
        // select subject in year 1
        if (calculus1.isSelected()) {
            cal = "Calculus I";
        } else if (!calculus1.isSelected()) {
            cal = "";
        }
        if (IntroCom.isSelected()) {
            intro = "Intro. to Computer Science";
        } else if (!IntroCom.isSelected()) {
            intro = "";
        }
        if (FunPro.isSelected()) {
            funp = "Fund. Programming Concepts";
        } else if (!FunPro.isSelected()) {
            funp = "";
        }
        if (Digital.isSelected()) {
            digi = "Digital Computer Logic";
        } else if (!Digital.isSelected()) {
            digi = "";
        }
        if (Knowledge.isSelected()) {
            know = "Knowledge of the Land";
        } else if (!Knowledge.isSelected()) {
            know = "";
        }
        if (calculus2.isSelected()) {
            cal2 = "Calculus II";
        } else if (!calculus2.isSelected()) {
            cal2 = "";
        }
        if (comPro.isSelected()) {
            comp = "Computer Programming";
        } else if (!comPro.isSelected()) {
            comp = "";
        }
        if (Funcom.isSelected()) {
            func = "Fundamentals of Computing";
        } else if (!Funcom.isSelected()) {
            func = "";
        }
        // add subjects that select
        checkSubjectY1.add(cal);
        checkSubjectY1.add(intro);
        checkSubjectY1.add(funp);
        checkSubjectY1.add(digi);
        checkSubjectY1.add(know);
        checkSubjectY1.add(cal2);
        checkSubjectY1.add(comp);
        checkSubjectY1.add(func);
    }

    public void checkYear2() {
        // select subject in year2
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
            data = "Data Structures";
        } else if (!dataStruct.isSelected()) {
            data = "";
        }
        if (statistic.isSelected()) {
            stat = "Principles of Statistics";
        } else if (!statistic.isSelected()) {
            stat = "";
        }
        if (database.isSelected()) {
            datab = "Fundamental of Database Systems";
        } else if (!database.isSelected()) {
            datab = "";
        }
        if (algorithm.isSelected()) {
            algo = "Algorithms Design & Analysis";
        } else if (!algorithm.isSelected()) {
            algo = "";
        }
        if (assembly.isSelected()) {
            assem = "Assembly Language and Computer Architecture";
        } else if (!assembly.isSelected()) {
            assem = "";
        }
        // add subjects that select
        checkSubjectY2.add(linear);
        checkSubjectY2.add(java);
        checkSubjectY2.add(data);
        checkSubjectY2.add(stat);
        checkSubjectY2.add(datab);
        checkSubjectY2.add(algo);
        checkSubjectY2.add(assem);
    }

    public void checkYear3() {
        // select subject in year3
        if (systemAnalysis.isSelected()) {
            system = "System Analysis & Design";
        }
        else if (!systemAnalysis.isSelected()) {
            system = "";
        }
        if (operating.isSelected()) {
            os = "Operating Systems";
        }
        else if (!operating.isSelected()) {
            os = "";
        }
        if (intellectual.isSelected()) {
            intell = "Intellectual Prop. & Profess. Ethics";
        }
        else if (!intellectual.isSelected()) {
            intell = "";
        }
        if (seminar.isSelected()) {
            semi = "Seminar";
        }
        else if (!seminar.isSelected()) {
            semi = "";
        }
        if (inforSystem.isSelected()) {
            info = "Information System Security";
        }
        else if (!inforSystem.isSelected()) {
            info = "";
        }
        if (automata.isSelected()) {
            auto = "Automata Theory";
        }
        else if (!automata.isSelected()) {
            auto = "";
        }
        if (compliertech.isSelected()) {
            complier = "Compiler Techniques";
        }
        else if (!compliertech.isSelected()) {
            complier = "";
        }
        if (prinInCS.isSelected()) {
            princs = "Principles in CCs & Cloud Computing";
        }
        else if (!prinInCS.isSelected()) {
            princs = "";
        }
        if (coOpEduPre.isSelected()) {
            cooppre = "Cooperative Education Preparation";
        }
        else if (!coOpEduPre.isSelected()) {
            cooppre = "";
        }
        // add subjects that select
        checkSubjectY3.add(system);
        checkSubjectY3.add(os);
        checkSubjectY3.add(intell);
        checkSubjectY3.add(semi);
        checkSubjectY3.add(info);
        checkSubjectY3.add(auto);
        checkSubjectY3.add(complier);
        checkSubjectY3.add(princs);
        checkSubjectY3.add(cooppre);
    }

    public void checkYear4() {
        // select subject in year4
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
        // add subjects that select
        checkSubjectY4.add(coOp);
        checkSubjectY4.add(csPro);
    }

    @FXML public void saveOnAction(MouseEvent mouseEvent) {
        // remove all subject for add new subject when click save button

        name.removeAll(check);
        studentSubject.removeAll(checkSubjectY1);
        studentSubject.removeAll(checkSubjectY2);
        studentSubject.removeAll(checkSubjectY3);
        studentSubject.removeAll(checkSubjectY4);
        //check the duplicate data for add to list
        if (checkSubjectY1.size()!=0) {
            for (int i = checkSubjectY1.size() - 8; i < checkSubjectY1.size(); i++) {
                studentSubject.add(checkSubjectY1.get(i));
            }
        }
        if (checkSubjectY2.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY2.size() - 7; i < checkSubjectY2.size(); i++) {
                studentSubject.add(checkSubjectY2.get(i));
            }
        }
        if (checkSubjectY3.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<7; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY3.size() - 9; i < checkSubjectY3.size(); i++) {
                studentSubject.add(checkSubjectY3.get(i));
            }
        }
        if (checkSubjectY4.size()!=0) {
            if (checkSubjectY1.size()==0) {
                for (int i=0; i<8; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<7; i++) {
                    studentSubject.add("");
                }
            }
            if (checkSubjectY2.size()==0) {
                for (int i=0; i<9; i++) {
                    studentSubject.add("");
                }
            }
            for (int i = checkSubjectY4.size() - 2; i < checkSubjectY4.size(); i++) {
                studentSubject.add(checkSubjectY4.get(i));
            }
        }

        checkSubjectY1.removeAll(checkSubjectY1);
        checkSubjectY2.removeAll(checkSubjectY2);
        checkSubjectY3.removeAll(checkSubjectY3);
        checkSubjectY4.removeAll(checkSubjectY4);
        // clear selected checkbox when click saved button
        calculus1.setSelected(false); FunPro.setSelected(false); IntroCom.setSelected(false);
        Digital.setSelected(false); Knowledge.setSelected(false);

        calculus2.setSelected(false); comPro.setSelected(false); Funcom.setSelected(false);

        basicLinear.setSelected(false);software.setSelected(false);dataStruct.setSelected(false);
        statistic.setSelected(false);

        database.setSelected(false);assembly.setSelected(false);algorithm.setSelected(false);

        systemAnalysis.setSelected(false);operating.setSelected(false);intellectual.setSelected(false);
        seminar.setSelected(false);

        inforSystem.setSelected(false);automata.setSelected(false);compliertech.setSelected(false);
        prinInCS.setSelected(false);coOpEduPre.setSelected(false);

        coOpEdu.setSelected(false);csProject.setSelected(false);
//        name.removeAll(name);

    }

    private HashSet name = new HashSet();
    private HashSet check = new HashSet();

    public void checkPass() {
        // check subject that pass
        int count = 0;
        System.out.println(studentSubject);
        for (String s : studentSubject) {
            if (!s.isEmpty()){
                for (Subject subject : allSubjects) {
                    if (subject.getNameSubject().equals(s)){

                        if (subject.getBeforeThisSubject().isEmpty()){
                            subject.setStatus(true);
                        }
                        else {
                            int beforeSub = subject.getBeforeThisSubject().size();
                            for (String s1 : subject.getBeforeThisSubject()) {
                                for (Subject allSubject : allSubjects) {
                                    if (allSubject.getNameSubject().equals(s1)){
                                        if (allSubject.getStatus()){
                                            beforeSub--;
                                        }
                                    }
                                }
                            }
                            if (beforeSub == 0){
                                subject.setStatus(true);
                                check.add(subject.getNameSubject());
                            }
                            else{
                                count++;
                                name.add(subject.getNameSubject());
                            }
                        }
                    }
                }
            }

        }
        if (count!=0) {
            for (Object ch : name) {
                studentSubject.remove(ch);
                studentSubject.add("");
            }
            studentSubject.add("");
            System.out.println(studentSubject);
            Alert();
        }
        name.removeAll(name);
    }

    private String getPass = "";
    @FXML public void setShowSub(MouseEvent mouseEvent) throws Exception {
        // show passed and not pass subject

        checkPass();
        String Pass = "", NotPass = "", pdfText = "SUBJECTS REGISTER\n\n";
        for (Subject subject : allSubjects) {
            if (subject.getStatus()){
                Pass+= "Subject: "+ subject.getNameSubject() +" ("+ subject.getIdSubject() +")"+ "\n"
                        + "- Credit: "+ subject.getCredit() + "\n- Status: " + "Pass\n " +"\n";

                pdfText += "Subject: "+ subject.getNameSubject() +" ("+ subject.getIdSubject() +")"+ "\n"
                        + "- Credit: "+ subject.getCredit() + "\n- Level: " + subject.getLevel() + "\n";

            }
            else{
                NotPass+= "Subject: "+ subject.getNameSubject() +" ("+ subject.getIdSubject() +")"+ "\n"
                        + "- Status: " + "Not pass\n";
                for (String s : subject.getBeforeThisSubject()) {
                    if (!s.isEmpty()) {
                        NotPass += "- Have to pass "+ s +" before.";
                    }
                    NotPass += "\n";
                }
                NotPass += "\n";
            }
        }

        if (Pass.equals("")) {
            showSubPass.setText("You don't pass any subjects.");
        } else {
            showSubPass.setText(Pass);
            getPass = pdfText;
            createFilePDF();
        }

        if (NotPass.equals("")) {
            showSubNotPass.setText("You have passed all the subjects.");
        } else {
            showSubNotPass.setText(NotPass);
        }

    }

    public void Alert() {
        for (Object nameSub : name) {
            for (Subject s : allSubjects) {
                if (s.getNameSubject().equals(nameSub)) {
                    // alert when select subject can't regis
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Dialog");
                    alert.setHeaderText(null);
                    alert.setContentText("Can not save \"" + nameSub + "\"\nYou have to pass " + s.getBeforeThisSubject());
                    alert.showAndWait();
                }
            }
        }


    }

    public void changetoPageChoose (ActionEvent actionEvent) throws IOException {
        //when click sign out button and change to home page
        Stage stage = (Stage) back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        stage.setTitle("Regis");
        stage.setScene(new Scene(root,600,400));
        stage.show();
    }


    public void createFilePDF() throws Exception {
        Document document = new Document();
        if (getPass.equals("")) {
            getPass = "No information\nYou must register by selecting the subjects that have passed before."+
                    "\nWarning! Don't forget to save register.";
        }

        try {
            PdfWriter.getInstance(document, new FileOutputStream("ExportRegister.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);

            Paragraph paragraph = new Paragraph(getPass, font);
            document.add(paragraph);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(getPass);

        document.close();
    }

    public void openPDF(ActionEvent event) {
        try {
            Desktop.getDesktop().open(new File("ExportRegister.pdf"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
