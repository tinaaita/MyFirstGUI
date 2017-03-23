package myFirstGui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by pwest on 3/14/17.
 */
public class myFirstGui extends Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button("OK");
        Scene scene = new Scene(button, 200, 500);

        button.setStyle("-fx-background-color: yellow; -fx-border-color: green; -fx-border-width: 12px;");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Stage stage = new Stage(); // Stage represents a window.
                stage.setTitle("John Stamos!"); // Give it a tile
                ImageView johnStamos = new ImageView("john-stamos-2.jpg"); // Create an image of John Stamos

                Pane pane = new Pane(); // A Pane is a component that holds other items/nodes
                pane.getChildren().add(johnStamos); // Add the john Stamos image node to the pane

                // Next we create a scene from the pane with the width and height of John Stamos
                Scene scene = new Scene(pane, johnStamos.getImage().getWidth(), johnStamos.getImage().getHeight());

                // Tell the stage to use our scene
                stage.setScene(scene);

                // On our John Stamos scene create an event when the mouse enters
                scene.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        // Move to a random location on the screen.
                        int x = (int)(800 * Math.random());
                        int y = (int)(600 * Math.random());
                        stage.setX(x);
                        stage.setY(y);
                    }
                });

                // Don't foget to show it!
                stage.show();
            }
        });

        primaryStage.setTitle("First Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
