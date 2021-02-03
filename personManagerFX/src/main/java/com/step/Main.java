package com.step;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainPage.fxml"));
        primaryStage.getIcons().add(new Image(String.valueOf(getClass().getResource("/img/persons.png"))));
        primaryStage.setTitle("Person Manager");
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(root, 1300, 950));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
