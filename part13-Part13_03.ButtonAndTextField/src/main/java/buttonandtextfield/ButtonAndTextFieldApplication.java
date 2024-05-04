package buttonandtextfield;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class ButtonAndTextFieldApplication extends Application {

    public void start(Stage window) {

        // components
        Button button = new Button("click here");
        TextField text = new TextField();
        text.setText("My text field");

        // add components to component group
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(text);
        
        // scene
        // add components to scene
        Scene scene = new Scene(componentGroup, Color.RED );
        
        
        
        //stage
        window.setScene(scene);
        window.setTitle("Button and Textfield");
        window.show();
        
        

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(ButtonAndTextFieldApplication.class);
    }

}
