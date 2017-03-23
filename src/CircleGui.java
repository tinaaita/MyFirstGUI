package myFirstGui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Created by pwest on 3/14/17.
 */
public class CircleGui extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circle = new Circle();
        circle.setCenterX(50);
        circle.setCenterY(50);
        circle.setRadius(50);
        circle.setStroke(Color.ALICEBLUE);
        circle.setFill(Color.FUCHSIA);

        Circle circle2 = new Circle();
        circle2.setCenterX(150);
        circle2.setCenterY(150);
        circle2.setRadius(50);
        circle2.setStroke(Color.ALICEBLUE);
        circle2.setFill(Color.SALMON);

        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().add(circle2);
        Scene scene = new Scene(pane, 200, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
