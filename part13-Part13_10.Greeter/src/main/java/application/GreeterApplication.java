package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {

        // First view
        //component
        Label nameRequest = new Label("Enter your name and start");
        TextField text = new TextField();
        Button button = new Button("Start");

        // component group
        GridPane firstView = new GridPane();
        firstView.add(nameRequest, 0, 0);
        firstView.add(text, 0, 1);
        firstView.add(button, 0, 2);

        // 1.3 styling the layout (GridPane /firstView)
        firstView.setPrefSize(300, 180);
        firstView.setAlignment(Pos.CENTER);
        firstView.setVgap(10);
        firstView.setHgap(10);
        firstView.setPadding(new Insets(20, 20, 20, 20));

        Scene sceneOne = new Scene(firstView);

        // secondView
        //component
        Label welcomeLabel = new Label();

        //component group
        StackPane secondView = new StackPane();
        secondView.getChildren().add(welcomeLabel);

        //styling for StackPane (second view)
        secondView.setPrefSize(300, 180);
        secondView.setAlignment(Pos.CENTER);

        Scene sceneTwo = new Scene(secondView);

        // when button is clicked set name in textfield to second view label 
        button.setOnAction((event) -> {
            welcomeLabel.setText("Welcome " + text.getText() + "!");
            window.setScene(sceneTwo);
        });

        //Stage
        window.setScene(sceneOne);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
