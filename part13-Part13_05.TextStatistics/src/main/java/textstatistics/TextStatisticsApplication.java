package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

//initilise Stage
    public void start(Stage window) {

        // main component group. can add CG and components to left,right,top,bottom
        BorderPane layout = new BorderPane();

        //text area
        TextArea text = new TextArea("Write in here");
        layout.setCenter(text);
        //Another way to add TextArea to center of BorderPane 
        //componentGroup.setCenter(new TextArea()); 

        // horizontal box
        HBox textComponents = new HBox();

        textComponents.getChildren().add(new Label("Letters: 0"));
        textComponents.getChildren().add(new Label("Words: 0"));
        textComponents.getChildren().add(new Label("The longest word is:"));
        textComponents.setSpacing(20);
        // add HBox to bottom of BorderPane
        layout.setBottom(textComponents);

        //add BorderPane to Scene   
        Scene scene = new Scene(layout);

        //add Scene to Stage
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
