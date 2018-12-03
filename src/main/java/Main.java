import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

//        ImageView iv = new ImageView();
//        iv.setImage(image);
//        pane.getChildren().add(iv);
//

        Parent root = FXMLLoader.load(getClass().getResource("chooseyear.fxml"));
        primaryStage.setTitle("REGIS");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();



    }

//    Image image = new Image("file:maxresdefault.jpg");
//    StackPane pane = new StackPane();
//    Scene scene = new Scene(pane,600,400);


    public static void main(String[] args) {
        launch(args);
    }
}
