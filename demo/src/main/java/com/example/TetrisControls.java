package com.example;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TetrisControls {
    public TetrisControls(Stage oldStage){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        newStage.setTitle("Tetris - Controls"); 

        // Back Button
        Button back = new Button("Menu");
        back.setStyle("-fx-background-color: grey; -fx-text-fill: white; -fx-padding:5px; -fx-font-size: 25px;");
        back.setOnAction(e ->{
            newStage.hide();
        });
        
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

        

        // Symbols Labels
        Label leftArrow2 = new Label("←");
        leftArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");
        
        Label rightArrow2 = new Label("→");
        rightArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");

        Label upArrow2 = new Label("↑");  
        upArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;"); 

        Label downArrow2 = new Label("↓");
        downArrow2.setStyle("-fx-background-color: #5050ff; -fx-text-fill: white; -fx-padding:5px;");
        
        // Back Verticla Box
        VBox backButton = new VBox(back);
        backButton.setAlignment(Pos.TOP_LEFT);
        backButton.setPadding(new Insets(35));

        // Keys vertical box
        VBox keys = new VBox(leftArrow1, blank1, rightArrow1, blank2, upArrow1, blank3, downArrow1 );
        keys.setStyle("-fx-font: 100 Didot; -fx-font-size: 30px;");
        keys.setPadding(new Insets(20));
        keys.setSpacing(15);
        keys.setAlignment(Pos.CENTER_LEFT);

        // Symbols vertical box
        VBox symbols = new VBox(leftArrow2, blank1, rightArrow2, blank2, upArrow2, blank3, downArrow2);
        symbols.setStyle("-fx-font: 100 Didot; -fx-font-size: 30px;");
        symbols.setPadding(new Insets(5));
        symbols.setAlignment(Pos.CENTER);

        // Controls horizontal box
        HBox controls = new HBox(keys, symbols);
        controls.setAlignment(Pos.CENTER);

        // Main scene
        HBox mainContainer = new HBox(backButton, controls);
        mainContainer.setStyle("-fx-background-color: #dbe9ff;");

        Scene currentScene = new Scene(mainContainer, 600, 800);                                 
        newStage.setScene(currentScene);
        newStage.show();
    }
} 
