package com.example;
import javafx.application.Application;
import javafx.event.*;              //adds EventHandler [all]
import javafx.geometry.Insets;
import javafx.geometry.Pos;         //adds Padding
import javafx.scene.Scene;          //adds Scene
import javafx.scene.control.*;      //adds Button [ALL]
import javafx.scene.layout.HBox;    //adds HBOX
//import javafx.scene.layout.VBox;    //adds VBox
import javafx.stage.Stage;          //adds Stage (creats window)

import java.io.IOException;

// JavaFX App is a sublass to Application
public class App extends Application {
    private static Scene scene;
    private static Label messageText;
    public static Object messageInput1;
    //public static TextField messageInput = new TextField();
    @Override

    // START METHOD v
    public void start(Stage stage) throws IOException {
        //Top left window title
        stage.setTitle("Class demo"); 

        // Needs java.scene.control.* package
        Button helloButton = new Button("Say Hello"); 
        Button goodbyeButton = new Button("Say Goodbye");

        //setStyle changes ("background; text-color; size;")
        helloButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 20px;"); 
        goodbyeButton.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-font-size: 20px;");

        //when hello button is pressed, messageText will be updated
        helloButton.setOnAction(new EventHandler<ActionEvent>(){       
            @Override
            public void handle(ActionEvent event){
                messageText.setText("You said hello to me");
            }
        });

        messageText = new Label("Defult Lable");                        //creats text output
        messageText.setText("New Text in Java");                        //setText replaces messageText

        HBox buttonContainer = new HBox(helloButton, goodbyeButton);    //holds buttons
        buttonContainer.setAlignment(Pos.CENTER);                       //positions buttons to center
        buttonContainer.setPadding(new Insets(20));                     //adds spacing, 20pixels of spacing around 
        
        //Label messageHint = new Label("Enter a message:");
        
        Button submit = new Button("Submit");

        submit.setOnAction(e ->{
            //new SecondPage(stage);
        });
        //VBox messageContainer = new VBox(messageHint, messageInput, submit);

        buttonContainer.borderProperty();
        //VBox layoutContainer = new VBox(buttonContainer, messageText, messageContainer);  //formats buttons

        //scene = new Scene(layoutContainer, 800, 600);                  //dimentions (vBox, x, y)
        stage.setScene(scene);                                          //sets stage to scene parameters
        stage.show();                                                   //opens window                                             //opens window
    }

    // MAIN METHOD v
    public static void main(String[] args) {
        launch(); // Launches Start method
    }
}