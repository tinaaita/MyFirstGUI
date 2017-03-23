package myFirstGui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by pwest on 3/14/17.
 */
public class SecondGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("OK");
        Pane pane = new StackPane();
        pane.getChildren().add(button);

        Scene scene = new Scene(pane, 200, 100);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
