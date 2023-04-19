package com.example;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TetrisDiff {
    public TetrisDiff(Stage oldStage){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        newStage.setTitle("Tetris - Difficulty"); 

        Label difficulty = new Label("Difficulty");
        difficulty.setAlignment(Pos.TOP_CENTER);                                    
        difficulty.setStyle("-fx-font: 90 Didot;");
        Button easy = new Button("Easy");
        easy.setStyle("-fx-background-color: #fbb474; -fx-text-fill: white; -fx-font-size: 24px;"); 
        Button med = new Button("Medium");
        med.setStyle("-fx-background-color: #74bbfb; -fx-text-fill: white; -fx-font-size: 24px;"); 
        Button hard = new Button("Hard");
        hard.setStyle("-fx-background-color: #ff6961; -fx-text-fill: white; -fx-font-size: 24px;"); 

        easy.setOnAction(e ->{
            
            new TetrisGame(newStage);
        });
        med.setOnAction(e ->{
            new TetrisGame(newStage);
        });
        hard.setOnAction(e ->{
            new TetrisGame(newStage);
        });
        VBox difficultyBox = new VBox(difficulty);
        difficultyBox.setPadding(new Insets(15));
        difficultyBox.setAlignment(Pos.CENTER);
        VBox easyBox = new VBox(easy);
        easyBox.setPadding(new Insets(15));
        easyBox.setAlignment(Pos.CENTER);
        VBox medBox = new VBox(med);
        medBox.setPadding(new Insets(15));
        medBox.setAlignment(Pos.CENTER);
        VBox hardBox = new VBox(hard);
        hardBox.setPadding(new Insets(15));
        hardBox.setAlignment(Pos.CENTER);

        VBox mainContainer = new VBox(difficultyBox, easyBox, medBox, hardBox);
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.setStyle("-fx-background-color: #dbe9ff;");

        Scene currentScene = new Scene(mainContainer, 600, 800);                                 
        newStage.setScene(currentScene);
        newStage.show();
    }
} 
