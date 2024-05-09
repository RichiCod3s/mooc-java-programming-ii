package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window){
        
        // main layout
        BorderPane layout = new BorderPane();
        
        
        // hbox that contains buttons for main layout
        HBox jokeOptions = new HBox();
        jokeOptions.setPadding(new Insets(20, 20, 20, 20));
        jokeOptions.setSpacing(10);
        
        //components 
        Button joke = new Button("Joke");
        Button answer = new Button("Answer");
        Button explanation = new Button("Explanation");
        
        jokeOptions.getChildren().addAll(joke,answer,explanation);
        
        
        //add HBox to BorderPane 
        layout.setTop(jokeOptions);
        
        
        // component groups with label that will show in center of main layout when the button is clicked
        StackPane jokeText = createView("What do you call a bear with no teeth?");
        StackPane answerText = createView("A gummy bear.");
        StackPane explanationText = createView("Gummy teeth means you have no teeth, a gummy bear is a popular sweet");
        
        
         // 2.3. Set initial view
        layout.setCenter(jokeText);
        
        // action for buttons
        
        joke.setOnAction((event) -> layout.setCenter(jokeText));
        answer.setOnAction((event) -> layout.setCenter(answerText));
        explanation.setOnAction((event) -> layout.setCenter(explanationText));
        
        
        
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
        
        
        
        
        
        
    }

      private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
    
    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
