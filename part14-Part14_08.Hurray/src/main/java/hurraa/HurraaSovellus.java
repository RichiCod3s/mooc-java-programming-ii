package hurraa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/*
added the below in the pom file under a similar one with  <artifactId>javafx-controls</artifactId>.
cant seem to get it to pass because it cant find the java fx media 
the code works
   <dependency>
                    <groupId>org.openjfx</groupId>
                    <artifactId>javafx-media</artifactId>
                    <version>11.0.2</version>
                </dependency>
 */
public class HurraaSovellus extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();

        Button button = new Button("Hurraa!");
        pane.setCenter(button);

        // issue with Maven not being able to find javafx.scene.media.AudioClip;
        AudioClip audio = new AudioClip("file:Applause-Yannick_Lemieux.wav");
        button.setOnAction(event -> audio.play());

        Scene scene = new Scene(pane, 600, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
