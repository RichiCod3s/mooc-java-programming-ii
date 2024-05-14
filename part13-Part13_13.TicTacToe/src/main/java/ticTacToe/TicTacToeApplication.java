package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private boolean xTurn = true;
    private int numberOfTurns = 0;
    private Button[] buttons = new Button[9];

    @Override
    public void start(Stage window) {

        // main component group
        BorderPane layout = new BorderPane();

        // top of layout
        HBox text = new HBox();
        Label gameDisplay = new Label("Turn: X");
        gameDisplay.setFont(Font.font("Monospaced", 40)); // family, size
        text.getChildren().add(gameDisplay);

        // middle of layout
        GridPane game = new GridPane();

        //add buttons to GridPane 3x3
        // putting buttons in to an Array allows us more flexibilty to use them.
        for (int i = 0; i < 9; i++) { //array of buttons
            buttons[i] = createButton(gameDisplay);
        }
        
        //add each button to GridPane
        game.add(buttons[0], 0, 0);
        game.add(buttons[1], 0, 1);
        game.add(buttons[2], 0, 2);
        game.add(buttons[3], 1, 0);
        game.add(buttons[4], 1, 1);
        game.add(buttons[5], 1, 2);
        game.add(buttons[6], 2, 0);
        game.add(buttons[7], 2, 1);
        game.add(buttons[8], 2, 2);

        //style
        // game.setPrefSize(300, 350); //no need for this as Font class makes it as big as it needs to be
        game.setAlignment(Pos.CENTER);
        game.setVgap(10); // gap between buttons
        game.setHgap(10);
        game.setPadding(new Insets(20, 20, 20, 20)); //add to layout

  
        // add cg to main to layout
        layout.setTop(gameDisplay);
        layout.setCenter(game);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }//start method
    
    // buttons layout and actions
    private Button createButton(Label gameDisplay) {
        Button button = new Button(" ");
        //button.setPrefSize(100, 80); // no need for this as Font class takes care of it
        button.setFont(Font.font("Monospaced", 40)); //family, size

        //action of buttons
        //we need to set the boolean value like this as objects instanced of interfaces cannot use variables that are defined outside of the method
        // we get an error: local variables referenced from a lambda expression must be final or effectively final
        //avoid the error by creating new variables outside start method that you set the problematic values to just before using them in the method.
        button.setOnAction((event) -> {
            boolean turnX = xTurn;
            if (turnX) {
                button.setText("X");
                button.setDisable(true);
                xTurn = false;
                gameDisplay.setText("Turn: O");
            } else {
                button.setText("O");
                button.setDisable(true);
                gameDisplay.setText("Turn: X");
                xTurn = true;
            }
            // if games wins or stalemate
            numberOfTurns++; 
            if (gameWon(buttons)) {
                gameDisplay.setText("The end!");
            }
            if (numberOfTurns == 9) {
                gameDisplay.setText("The end!");
            }

        });

        return button;
    }

     // method of game win conditions
    // a bit verbose but works :) we could divide this to X and O and change the label to X | O wins
    public boolean gameWon(Button[] buttons) {
        //X
        //rows
        if (buttons[0].getText().equals("X") && buttons[1].getText().equals("X") && buttons[2].getText().equals("X")
                || buttons[3].getText().equals("X") && buttons[4].getText().equals("X") && buttons[5].getText().equals("X")
                || buttons[6].getText().equals("X") && buttons[7].getText().equals("X") && buttons[8].getText().equals("X")
                || //columns
                buttons[0].getText().equals("X") && buttons[3].getText().equals("X") && buttons[6].getText().equals("X")
                || buttons[1].getText().equals("X") && buttons[4].getText().equals("X") && buttons[7].getText().equals("X")
                || buttons[2].getText().equals("X") && buttons[5].getText().equals("X") && buttons[8].getText().equals("X")
                || // Diagonals
                buttons[0].getText().equals("X") && buttons[4].getText().equals("X") && buttons[8].getText().equals("X")
                || buttons[2].getText().equals("X") && buttons[4].getText().equals("X") && buttons[6].getText().equals("X")) {

            //disable all buttons when game is won
            for (int i = 0; i < 9; i++) {
                buttons[i].setDisable(true);
            }
            return true;
        }
        //O
        //rows
        if (buttons[0].getText().equals("O") && buttons[1].getText().equals("O") && buttons[2].getText().equals("O")
                || buttons[3].getText().equals("O") && buttons[4].getText().equals("O") && buttons[5].getText().equals("O")
                || buttons[6].getText().equals("O") && buttons[7].getText().equals("O") && buttons[8].getText().equals("O")
                || //columns
                buttons[0].getText().equals("O") && buttons[3].getText().equals("O") && buttons[6].getText().equals("O")
                || buttons[1].getText().equals("O") && buttons[4].getText().equals("O") && buttons[7].getText().equals("O")
                || buttons[2].getText().equals("O") && buttons[5].getText().equals("O") && buttons[8].getText().equals("O")
                || // Diagonals
                buttons[0].getText().equals("O") && buttons[4].getText().equals("O") && buttons[8].getText().equals("O")
                || buttons[2].getText().equals("O") && buttons[4].getText().equals("O") && buttons[6].getText().equals("O")) {

            //disable all buttons when game is won
            for (int i = 0; i < 9; i++) {
                buttons[i].setDisable(true);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}//class
