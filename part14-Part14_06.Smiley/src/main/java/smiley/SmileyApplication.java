package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage window) {

        //Add a BorderPane into the GUI to be responsible for the application's layout.
        BorderPane layout = new BorderPane();

        //Add a Canvas object in the middle of the BorderPane.
        Canvas paintingCanvas = new Canvas(400, 400);
        layout.setCenter(paintingCanvas);

        // use the GraphicsContext object of the Canvas object to draw a smiley. 
        //Use white (Color.WHITE) as the background color, and black (Color.BLACK) as the color of the smiley.
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        painter.setFill(Color.BLACK);

        //  ColorPicker colorPalette = new ColorPicker(); - you could use this in a nother program as a dropdown to pick a colour
        //the purpose here is NOT to manually draw the smiley with the mouse — use the methods of the GraphicsContext object so that the picture is already drawn when the program is first started
        painter.fillRect(100, 50, 50, 50); // left eye
        painter.fillRect(250, 50, 50, 50); // right eye
        painter.fillRect(50, 200, 50, 50);// the rest is the mouth
        painter.fillRect(300, 200, 50, 50);
        painter.fillRect(100, 250, 200, 50);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
