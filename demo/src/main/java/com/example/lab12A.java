package com.example;
/////////////////////////
// CSCI 3326.02
// Spring 2023
// Lab 12A
// Edwin Serna
/////////////////////////

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;         //adds Padding
import javafx.scene.Scene;          //adds Scene
import javafx.scene.control.*;      //adds Button [ALL]
import javafx.scene.layout.HBox;    //adds HBOX
import javafx.scene.layout.VBox;    //adds VBox
import javafx.stage.Stage;          //adds Stage (creats window)

import java.io.IOException;    

public class lab12A extends Application{
    
    private static Scene scene;
    private static Label messageText;
    private static Label messageText2;
    private static Label messageText3;
    
    public static TextField messageInput1 = new TextField();
    public static TextField messageInput2 = new TextField();
    public static TextField messageInput3 = new TextField();

    @Override

    // START METHOD v
    public void start(Stage stage) throws IOException {
        //Top left window title
        stage.setTitle("Lab 12A");  

        // Needs java.scene.control.* package
        Button submit = new Button("Submit"); 

        //setStyle changes ("background; text-color; size;")
        submit.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 24px;"); 
        
        messageText = new Label("Name"); 
        messageText2 = new Label("Food"); 
        messageText3 = new Label("Social"); 

        messageText.setText("What is your name?");                                     
        messageText2.setText("What is your favorite food item?");                 
        messageText3.setText("What is your favorite social media platform?");

        submit.setOnAction(e ->{
            new lab12ASecondPage(stage);
        });
        
        HBox buttonContainer = new HBox(submit);                        //holds buttons
        buttonContainer.setAlignment(Pos.CENTER);                       //positions buttons to center
        buttonContainer.setPadding(new Insets(10));                     //adds spacing, 20pixels of spacing around 
        buttonContainer.setSpacing(15);
        

        VBox messageContainer1 = new VBox(messageText, messageInput1); 
        messageContainer1.setPadding(new Insets(20)); 
        messageContainer1.setStyle("-fx-font: 24 arial;");
        
        VBox messageContainer2 = new VBox(messageText2, messageInput2); 
        messageContainer2.setPadding(new Insets(20)); 
        messageContainer2.setStyle("-fx-font: 24 arial;");

        VBox messageContainer3 = new VBox(messageText3, messageInput3);  
        messageContainer3.setPadding(new Insets(20)); 
        messageContainer3.setStyle("-fx-font: 24 arial;");

        
        VBox layoutContainer = new VBox(messageContainer1, messageContainer2, messageContainer3, buttonContainer);  //formats buttons
        
        messageContainer1.borderProperty();
        buttonContainer.borderProperty();
        scene = new Scene(layoutContainer, 800, 600);                  //dimentions (vBox, x, y)
        stage.setScene(scene);                                          //sets stage to scene parameters
        stage.show();                                                   //opens window
    }

  
    // MAIN METHOD v
    public static void main(String[] args) {
        launch(); // Launches Start method
    }
}
