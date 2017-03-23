package myFirstGui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by pwest on 3/16/17.
 */
public class RealTimeBasics1 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(400, 200);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLANCHEDALMOND);
        gc.setStroke(Color.AQUA);
        gc.setLineWidth(2);
        Font font = Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 48);
        gc.setFont(font);
        gc.fillText("Hello World!", 60, 50);
        gc.strokeText("Hello World!", 60, 50);

        Image earth = new Image("earth.png");
        gc.drawImage(earth, 180, 100);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
