package com.example.testkryds;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KrydsOgBolleApplication extends Application {

    //Starter applicationen med gameMenu
    @Override
    public void start(Stage stage) throws IOException {

        //Forsøger at starter programmet med gameMenu.fxml
        try {
            Parent root = FXMLLoader.load(KrydsOgBolleApplication.class.getResource("gameMenu.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Kryds og Bolle");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}