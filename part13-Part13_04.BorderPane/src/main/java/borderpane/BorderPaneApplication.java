package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application {
    
    // start method needed to initalise stage
    @Override
    public void start(Stage window){
        
          BorderPane layout = new BorderPane();
          
          //components
          Label north = new Label("NORTH");
          layout.setTop(north); // add label to top of BorderPane
          //another way
          layout.setBottom(new Label("SOUTH"));
          layout.setRight(new Label("EAST"));
          
          //scene add component group BorderPane
          Scene scene = new Scene(layout);
          
          // add scene to stage
          window.setScene(scene);
          window.show();
    }
  
    
   
    

    public static void main(String[] args) {
     
        launch(BorderPaneApplication.class);
    }

   
}
