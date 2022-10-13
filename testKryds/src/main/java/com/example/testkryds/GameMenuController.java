package com.example.testkryds;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameMenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    //Skifter scene fra gameMenu.fxml til gameBoard.fxml
    @FXML
    public void switchToGameBoard(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gameBoard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //Skifter scene fra gameMenu.fxml til gameBoardAI.fxml
    @FXML
    public void switchToTicTacToeAI(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TicTacToeAI.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
