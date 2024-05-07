package notifier;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {

        // component group - Vertical Box
        VBox layout = new VBox();

        //components
        TextField textField = new TextField();
        Button button = new Button("Update");
        Label label = new Label();

        // add components to component group
        layout.getChildren().add(textField);
        layout.getChildren().add(button);
        layout.getChildren().add(label);

        // give button functioanilty - copy text from tectField to label
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // set text of label from textField
                label.setText(textField.getText());
            }
        });

        /*
        // Lambda way to implement action listener:
         button.setOnAction((event) -> {
            text.setText(textField.getText());
        });
         */
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        launch(NotifierApplication.class);
    }

}
