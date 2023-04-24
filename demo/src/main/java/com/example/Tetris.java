package com.example;
/////////////////////////
// CSCI 3326.02
// Spring 2023
// Tetris
/////////////////////////

// https://youtu.be/boAJUSN8fOU
// https://youtu.be/KGaixc-ExXA
// https://github.com/Gaspared/tetris

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;    //adds HBOX
import javafx.scene.layout.VBox;    //adds VBox
import java.io.IOException;

public class Tetris extends Application{
    public static final int MOVE = 0;
    private static Label T;
    private static Label E;
    private static Label T2;
    private static Label R;
    private static Label I;
    private static Label S;



    @Override

    // START METHOD v
    public void start(Stage stage) throws IOException {
        stage.setTitle("TETRIS");                                       //Top left window title

        T = new Label("T");                                             // Title by letter so it's color coded
        T.setStyle("-fx-font: 100 Didot; -fx-text-fill: da869c; -fx-font-size: 100px;");
        
        E = new Label("E"); 
        E.setStyle("-fx-font: 100 Didot; -fx-text-fill: ffa36d; -fx-font-size: 100px;");
        
        T2 = new Label("T"); 
        T2.setStyle("-fx-font: 100 Didot; -fx-text-fill: #ffd652; -fx-font-size: 100px;");
        
        R = new Label("R"); 
        R.setStyle("-fx-font: 100 Didot; -fx-text-fill: #4ff4a2 ; -fx-font-size: 100px;");
        
        I = new Label("I"); 
        I.setStyle("-fx-font: 100 Didot; -fx-text-fill: #5f9cff; -fx-font-size: 100px;");
        
        S = new Label("S"); 
        S.setStyle("-fx-font: 100 Didot; -fx-text-fill: b19cf8 ; -fx-font-size: 100px;");
       
        HBox tetris = new HBox(T, E, T2, R, I, S);                      // horizontal box that groups the title letters
        tetris.setAlignment(Pos.TOP_CENTER);                            // Centers the title to the top center
        
        
        Button start = new Button("Start");                             // Creates Start button, labeled start
        start.setStyle("-fx-background-color: #ffb2a8; -fx-text-fill: white; -fx-font-size: 24px;"); //setStyle changes ("background; text-color; size;")
        start.setOnAction(e ->{    
            
            stage.hide();                                               // Start button opens Difficulty window
            new TetrisDiff(stage);
            
        });

        HBox buttonContainer = new HBox(start);                         // holds buttons properties
        buttonContainer.setAlignment(Pos.CENTER);                       // positions buttons to center
        buttonContainer.setPadding(new Insets(20));                     // adds padding of 20 pixels within the button
        buttonContainer.setSpacing(40);                                 // adds spacing  of 40 pixels around the button, 
        
        // Center (title and start)
        VBox center = new VBox(tetris, buttonContainer);                // vertical box formats Tertis label and Start button
        center.setAlignment(Pos.CENTER);

        // IDEA MIGHT GET SCRAPED
        Button volumeButton = new Button("               ");                          // Creates volume button 
        volumeButton.setStyle("-fx-background-color: #dbe9ff; -fx-text-fill: white; -fx-font-size: 20px; -fx-padding:10px;"); //setStyle changes ("background; text-color; size;")
        volumeButton.setOnAction(e ->{                                  // when volume button is pressed it has an action
            // Volome on/off code
            
        });
        VBox volume = new VBox(volumeButton);                           // vertical box formats the volume button
        // Left (volumebutton)
        VBox left = new VBox(volume);                                   // vertical box that holds everything to the left
        left.setAlignment(Pos.BOTTOM_LEFT);                             // format it to the  bottom left


        Button settings = new Button("Controls");                              // creates settings button
        settings.setStyle("-fx-background-color: grey; -fx-text-fill: white; -fx-font-size: 20px; -fx-padding:10px;"); //setStyle changes ("background; text-color; size;")
        settings.setOnAction(e ->{                                      // when settings is pressed it opens Controls page
            new TetrisControls(stage);
        });
        VBox tabs = new VBox(settings);                                 // creates vertcal boc that holds settings
        
        // Right (settings)
        VBox right = new VBox(tabs);                                    // creates a vertical box for the right tabs
        right.setAlignment(Pos.BOTTOM_RIGHT);                           // formats it to bottom right
        
        
        HBox main = new HBox(left, center, right);                      // creates horizontal box from left to right
        main.setAlignment(Pos.CENTER);                                  // formats main to the center
        main.setStyle("-fx-background-color: #dbe9ff;");                // changes the background color

        Scene scene = new Scene(main, 600, 800);                              //dimentions (vBox, x, y)
        
        stage.setScene(scene);                                          //sets stage to scene parameters
        stage.show();                                                   //opens window
    }

  
    // MAIN METHOD v
    public static void main(String[] args) {
        launch(); // Launches Start method
    }
    
}
