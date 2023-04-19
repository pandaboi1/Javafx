package com.example;
/////////////////////////
// CSCI 3326.02
// Spring 2023
// Lab 11A
// Edwin Serna
/////////////////////////

import javafx.application.Application;
import javafx.event.*;              //adds EventHandler [all]
import javafx.geometry.Insets;
import javafx.geometry.Pos;         //adds Padding
import javafx.scene.Scene;          //adds Scene
import javafx.scene.control.*;      //adds Button [ALL]
import javafx.scene.layout.HBox;    //adds HBOX
import javafx.scene.layout.VBox;    //adds VBox
import javafx.stage.Stage;          //adds Stage (creats window)

import java.io.IOException;    

public class lab11A extends Application{
    
    private static Scene scene;
    private static Label messageText;
    private static Label messageText2;
    private static Label messageText3;
    @Override

    

    // START METHOD v
    public void start(Stage stage) throws IOException {
        //Top left window title
        stage.setTitle("Lab 11A"); 

        // Needs java.scene.control.* package
        Button rock = new Button("Rock"); 
        Button paper = new Button("Paper");
        Button scissors = new Button("Scissors");

        //setStyle changes ("background; text-color; size;")
        rock.setStyle("-fx-background-color: blue; -fx-text-fill: white; -fx-font-size: 30px;"); 
        paper.setStyle("-fx-background-color: red; -fx-text-fill: white; -fx-font-size: 30px;");
        scissors.setStyle("-fx-background-color: #FF10F0; -fx-text-fill: white; -fx-font-size: 30px;");
        

        //when rock,paper,scissors buttons are pressed, messageText will be updated
        rock.setOnAction(new EventHandler<ActionEvent>(){       
            @Override
            public void handle(ActionEvent event){
                messageText.setText("\nYou selected rock.");
                gameAlg(1);
            }
        });
        paper.setOnAction(new EventHandler<ActionEvent>(){       
            @Override
            public void handle(ActionEvent event){
                messageText.setText("\nYou selected paper.");
                gameAlg(2);

            }
        });
        scissors.setOnAction(new EventHandler<ActionEvent>(){       
            @Override
            public void handle(ActionEvent event){
                messageText.setText("\nYou selected scissors.");
                gameAlg(3);

            }
        });

        messageText = new Label("Prompt"); 
        messageText2 = new Label("Computer"); 
        messageText3 = new Label("Output");                   //creats text output
        messageText.setText("");                                        //setText replaces messageText
        messageText.setStyle("-fx-font: 24 arial;");                    //creats text output
        messageText2.setText("");                                        //setText replaces messageText
        messageText2.setStyle("-fx-font: 24 arial;");                   //creats text output
        messageText3.setText("");                                        //setText replaces messageText
        messageText3.setStyle("-fx-font: 24 arial;");
        
        
        HBox buttonContainer = new HBox(rock, paper, scissors);         //holds buttons
        buttonContainer.setAlignment(Pos.TOP_CENTER);                       //positions buttons to center
        buttonContainer.setPadding(new Insets(10));                     //adds spacing, 20pixels of spacing around 
        buttonContainer.setSpacing(15);

        
        buttonContainer.borderProperty();
        VBox layoutContainer = new VBox(buttonContainer, messageText, messageText2, messageText3);  //formats buttons

        scene = new Scene(layoutContainer, 800, 600);                  //dimentions (vBox, x, y)
        stage.setScene(scene);                                          //sets stage to scene parameters
        stage.show();                                                   //opens window
    }

  
    // MAIN METHOD v
    public static void main(String[] args) {
        launch(); // Launches Start method
    }

    //Algorthom
    public void gameAlg(int num){
        int randNum = (int)(Math.random() * (3 + 1 - 1) + 1); 

        if (randNum == 1)
            messageText2.setText("\nComputer selected rock.");
        if (randNum == 2)
            messageText2.setText("\nComputer selected paper.");
        if (randNum == 3)
            messageText2.setText("\nComputer selected scissors.");
        
        if (num == randNum)
            messageText3.setText("\nYou tied!");
        else if (num == 1 && randNum == 3 || num == 2 && randNum == 1 || num == 3 && randNum == 2)
            messageText3.setText("\nYou Won!");
        else
            messageText3.setText("\nYou lost!");
    }
}
