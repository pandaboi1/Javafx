package com.example;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class lab12ASecondPage {
    public lab12ASecondPage(Stage oldStage){
        Stage newStage = new Stage();
        newStage.initOwner(oldStage);
        //Top left window title
        newStage.setTitle("Lab 12A - Results"); 

        Label Name = new Label("Thank you for answering all the questions, ");
        Label Name2 = new Label(".");
        Label Value1 = new Label(lab12A.messageInput1.getText());

        Label Food = new Label("It is true that ");
        Label Food2 = new Label(" is a delicious food item.");
        Label Value2 = new Label(lab12A.messageInput2.getText());

        Label Social = new Label("Well, guess you better get back on ");
        Label Social2 = new Label(" now.");
        Label Value3 = new Label(lab12A.messageInput3.getText());

        HBox line1 = new HBox(Name, Value1, Name2);
        line1.setPadding(new Insets(20));
        HBox line2 = new HBox(Food, Value2, Food2);
        line2.setPadding(new Insets(20));
        HBox line3 = new HBox(Social, Value3, Social2);
        line3.setPadding(new Insets(20));

        VBox mainContainer = new VBox(line1, line2, line3);
        mainContainer.setPadding(new Insets(20)); 
        mainContainer.setStyle("-fx-font: 24 arial;");

        Scene currentScene = new Scene(mainContainer, 800, 600);                                 
        newStage.setScene(currentScene);
        newStage.show();
    }
} 
