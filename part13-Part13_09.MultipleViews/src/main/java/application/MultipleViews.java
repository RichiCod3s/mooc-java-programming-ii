package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public void start(Stage window) {

        // first scene
        // component group
        BorderPane firstView = new BorderPane();

        //components
        Label labelFirst = new Label("First View");
        Button toSecondView = new Button("To the second view!");

        firstView.setTop(labelFirst);
        firstView.setCenter(toSecondView);

        Scene sceneOne = new Scene(firstView);

        //second scene
        VBox secondView = new VBox();

        Button toThirdView = new Button("To the third view!");
        Label labelSecond = new Label("Second view!");

        secondView.getChildren().add(toThirdView);
        secondView.getChildren().add(labelSecond);
        Scene sceneTwo = new Scene(secondView);

        // third scene
        GridPane thirdView = new GridPane();
        Label labelThird = new Label("Third view!");
        Button toFirstView = new Button("To the first view!");
        
        thirdView.add(labelThird, 0, 0);
        thirdView.add(toFirstView, 1, 1);
        
        Scene sceneThree = new Scene(thirdView);

        // change scen one to second scene
        toSecondView.setOnAction((event) -> {
            window.setScene(sceneTwo);
        });

        // change from scene 2 to third scene
        toThirdView.setOnAction((event) -> {
            window.setScene(sceneThree);
        });
        
        // change from third to first scene
        toFirstView.setOnAction((event) -> {
            window.setScene(sceneOne);
        });
        
        //Stage
        window.setScene(sceneOne);
        window.show();

    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
