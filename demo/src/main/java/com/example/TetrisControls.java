package com.example;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TetrisControls {
    public TetrisControls(Stage oldStage){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        newStage.setTitle("Tetris - Controls"); 


        // Keys Labels
        Label leftArrow1 = new Label("Move Left:");
        Label blank1 = new Label (" ");
        blank1.setStyle("-fx-font-size: 1px;");

        Label rightArrow1 = new Label("Move Right: ");
        Label blank2 = new Label ("");
        blank2.setStyle("-fx-font-size: 1px;");

        Label upArrow1 = new Label("Rotate Clockwise: ");
        Label blank3 = new Label (" ");
        blank3.setStyle("-fx-font-size: 1px;");

        Label downArrow1 = new Label("Move Downward: ");
        Label blank4 = new Label (" ");
        blank4.setStyle("-fx-font-size: 1px;");

        Label shift1 = new Label ("Hold: ");
        

        // Symbols Labels
        Label leftArrow2 = new Label("←");
        leftArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");
        
        Label rightArrow2 = new Label("→");
        rightArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");

        Label upArrow2 = new Label("↑");  
        upArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;"); 

        Label downArrow2 = new Label("↓");
        downArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");
        
        Label shift2 = new Label("Shift");
        shift2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");


        // Keys vertical box
        VBox keys = new VBox(leftArrow1, blank1, rightArrow1, blank2, upArrow1, blank3, downArrow1, blank4, shift1);
        keys.setStyle("-fx-font: 100 Didot; -fx-font-size: 30px;");
        keys.setPadding(new Insets(20));
        keys.setSpacing(15);
        keys.setAlignment(Pos.CENTER_LEFT);

        // Symbols vertical box
        VBox symbols = new VBox(leftArrow2, blank1, rightArrow2, blank2, upArrow2, blank3, downArrow2, blank4, shift2);
        symbols.setStyle("-fx-font: 100 Didot; -fx-font-size: 30px;");
        symbols.setPadding(new Insets(5));
        symbols.setAlignment(Pos.CENTER);


        HBox mainContainer = new HBox(keys, symbols);
        mainContainer.setStyle("-fx-background-color: #dbe9ff;");
        mainContainer.setAlignment(Pos.CENTER);

        Scene currentScene = new Scene(mainContainer, 600, 800);                                 
        newStage.setScene(currentScene);
        newStage.show();
    }
} 
