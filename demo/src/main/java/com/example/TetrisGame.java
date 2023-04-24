package com.example;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TetrisGame {
    public TetrisGame(Stage oldStage){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        newStage.setTitle("Tetris - Game"); 

        Label current = new Label("Current");
        Label score = new Label("Score");
        Label next = new Label("Next");
        Button menu = new Button("menu");

        menu.setStyle("-fx-background-color: grey; -fx-text-fill: white; -fx-font-size: 24px;"); 

        HBox line1 = new HBox(current);
        line1.setAlignment(Pos.CENTER_RIGHT);
        line1.setPadding(new Insets(20));

        HBox line2 = new HBox(score);
        line2.setAlignment(Pos.CENTER_RIGHT);
        line2.setPadding(new Insets(20));

        HBox line3 = new HBox(next);
        line3.setAlignment(Pos.CENTER_RIGHT);
        line3.setPadding(new Insets(20));

        HBox line4 = new HBox(menu);
        line4.setAlignment(Pos.CENTER_RIGHT);
        line4.setPadding(new Insets(20));

         


        VBox left = new VBox();
        left.setPadding(new Insets(20)); 
        left.setStyle("-fx-font: 24 arial;");


        VBox right = new VBox(line1, line2, line3, line4);
        right.setAlignment(Pos.TOP_RIGHT);
        right.setPadding(new Insets(20)); 
        right.setStyle("-fx-font: 24 arial;");
        HBox mainStage = new HBox(left, right);
        mainStage.setStyle("-fx-background-color: #dbe9ff;");
        Scene currentScene = new Scene(mainStage, 600, 800);                                 
        newStage.setScene(currentScene);
        newStage.show();
    }
} 
