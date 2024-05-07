package textstatistics;

import java.util.Arrays;
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
        TextArea text = new TextArea();
        layout.setCenter(text);
        //Another way to add TextArea to center of BorderPane 
        //componentGroup.setCenter(new TextArea()); 

        // horizontal box
        HBox textComponents = new HBox();
        Label lettersCountLabel = new Label("Letters: 0");
        Label wordCountLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("Longest word is:");

        // add components to ComponentGroup
        textComponents.getChildren().addAll(lettersCountLabel, wordCountLabel, longestWordLabel);
        textComponents.setSpacing(20);

        // add HBox to bottom of BorderPane
        layout.setBottom(textComponents);

        // get statistics
        //The textProperty() method is a convenience method provided by various UI controls, such as TextField, TextArea, Label, etc., to access the property that represents the text content of the control.
        // the param are apart of the ActionListener/changeListener
        // allows manipulation of change, old values and new values - best to look at documentation: https://docs.oracle.com/javafx/2/api/javafx/beans/value/ChangeListener.html
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();// length of all chars in new value and thus is the number of all characters
            String[] parts = newValue.split(" ");// split the text by space in to an array 
            int words = parts.length; // the size/length of that array gives us the number of words

            
            String longest = Arrays.stream(parts)
                    //this sorts the Strings in the array by length
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    // returns an Optional containing the first element of the sorted stream, or an empty Optional if the stream is empty.
                    .findFirst()
                    //Since we used findFirst() earlier, we are guaranteed to have at most one element in the stream. Therefore, it's safe to call get() to retrieve the longest string from the sorted stream.
                    .get();

            lettersCountLabel.setText("Letters: " + characters);
            wordCountLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);

        });

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
