package myFirstGui;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pwest on 3/16/17.
 */
public class EarthRotateAroundSun extends Application {
    private static double mRadius;
    private static Map<KeyCode, Boolean> mKeyMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene theScene = new Scene(root);
        primaryStage.setScene(theScene);

        Canvas canvas = new Canvas(512, 512);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image earth = new Image("earth.png");
        Image sun = new Image("sun.png");
        Image space = new Image("space.png");

        final long startNanoTime = System.nanoTime();

        mRadius = 128.0;

        mKeyMap.put(KeyCode.UP, false);
        mKeyMap.put(KeyCode.DOWN, false);
        new AnimationTimer() {
            long lastKeyCheck = startNanoTime;
            @Override
            public void handle(long now) {
                double t = (now - startNanoTime) / 1000000000.0; // give us milliseconds.

                if (now - lastKeyCheck / 1000000000.0 > 25.0) {
                    if (mKeyMap.get(KeyCode.UP) == true) {
                        mRadius += 10;
                    }
                    if (mKeyMap.get(KeyCode.DOWN) == true) {
                        mRadius -= 10;
                    }

                    lastKeyCheck = now;
                }

                double x = 232 + mRadius * Math.cos(t);
                double y = 232 + mRadius * Math.sin(t);

                gc.drawImage(space, 0, 0);
                gc.drawImage(earth, x, y);
                gc.drawImage(sun, 196, 196);
            }
        }.start();

        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                mKeyMap.put(event.getCode(), true);
            }
        });

        theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                mKeyMap.put(event.getCode(), false);
            }
        });

        theScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse clicked on " + event.getX() + ", " + event.getY());
            }
        });

        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
