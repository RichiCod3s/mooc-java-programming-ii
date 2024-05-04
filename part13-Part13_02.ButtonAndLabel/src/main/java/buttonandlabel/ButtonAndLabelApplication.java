package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//remember to extend Application otherwise can't use launch in main (Needs an import)
public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {

        // components
        Button button = new Button("Click me");
        button.setLayoutX(300); // Set X-coordinate
        button.setLayoutY(300); // Set Y-coordinate

        Label label = new Label("Stage, scene, scene-graph, nodes");
        label.setLayoutX(0);
        label.setLayoutY(0);
       
        // component group
        FlowPane root = new FlowPane();
        //Group root = new Group(); .// seems to have more flexible layout of components compared to group.
        
        // add component to component to component group
        root.getChildren().add(label);
        root.getChildren().add(button);

        // pass in componentgroup to scene
        Scene scene = new Scene(root);

        //Stage
        window.setTitle("My Window Title");
        window.setHeight(500);
        window.setWidth(500);
        window.setScene(scene); // add scene
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);

    }

}
