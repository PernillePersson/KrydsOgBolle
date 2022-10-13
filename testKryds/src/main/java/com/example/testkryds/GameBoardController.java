package com.example.testkryds;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class GameBoardController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView bolle1;

    @FXML
    private ImageView bolle2;

    @FXML
    private ImageView bolle3;

    @FXML
    private ImageView bolle4;

    @FXML
    private ImageView bolle5;

    @FXML
    private ImageView bolle6;

    @FXML
    private ImageView bolle7;

    @FXML
    private ImageView bolle8;

    @FXML
    private ImageView bolle9;

    @FXML
    private Pane felt1;

    @FXML
    private Pane felt2;

    @FXML
    private Pane felt3;

    @FXML
    private Pane felt4;

    @FXML
    private Pane felt5;

    @FXML
    private Pane felt6;

    @FXML
    private Pane felt7;

    @FXML
    private Pane felt8;

    @FXML
    private Pane felt9;

    @FXML
    private ImageView kryds1;

    @FXML
    private ImageView kryds2;

    @FXML
    private ImageView kryds3;

    @FXML
    private ImageView kryds4;

    @FXML
    private ImageView kryds5;

    @FXML
    private ImageView kryds6;

    @FXML
    private ImageView kryds7;

    @FXML
    private ImageView kryds8;

    @FXML
    private ImageView kryds9;

    @FXML
    private ImageView dog;

    @FXML
    private ImageView cat;

    @FXML
    private ToggleButton krydsKnap;

    @FXML
    private ToggleButton bolleKnap;

    @FXML
    private ToggleGroup toggleValg;

    @FXML
    private Button nytSpil;

    //label der viser hvor mange træk bolle bruger
    @FXML
    private Label bolleTal;

    //label der viser hvor mange træk kryds bruger
    @FXML
    private Label krydsTal;

    //label der viser hvor mange gange bolle har vundet
    @FXML
    private Label bolleSejr;

    //label der viser hvor mange gange kryds har vundet
    @FXML
    private Label krydsSejr;

    //Labels bliver vist når en spiller har vundet
   @FXML
   private Label dogLabel;

   @FXML
   private Label catLabel;

    //int bliver opdateret pr træk
    private int bolleTræk = 0;
    private int krydsTræk = 0;

    //int bliver opdateret pr vundet spil
    private int bolleVinder = 0;

    private int krydsVinder = 0;

    // int bliver opdateret når brikker er på brættet
    //tæller op til 3, så man maks kan have 3 brikker af hver
    private int maxKrydser = 0;
    private int maxBoller = 0;

    //Skifter scene fra gameBoard.fxml til gameMenu.fxml
    @FXML
    public void switchTogameMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gameMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void felt1Pressed(MouseEvent event) {
        sætBrik1();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt2Pressed(MouseEvent event) {
        sætBrik2();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt3Pressed(MouseEvent event) {
        sætBrik3();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt4Pressed(MouseEvent event) {
        sætBrik4();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt5Pressed(MouseEvent event) {
        sætBrik5();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt6Pressed(MouseEvent event) {
        sætBrik6();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt7Pressed(MouseEvent event) {
        sætBrik7();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt8Pressed(MouseEvent event) {

        sætBrik8();
        opdaterTræk();
        checkVinder();
    }

    @FXML
    void felt9Pressed(MouseEvent event) {

        sætBrik9();
        opdaterTræk();
        checkVinder();
    }

    //Genstarter alt undtagen antal gange kryds eller bolle har vundet
    @FXML
    void nytSpilPressed(ActionEvent event) {
        resetInt();
        hvemVandt();
        autoBolleSelect();
        fjernBrikker();
        opdaterTræk();
        resetFelter();
    }

    //metode der opdaterer label med antal træk
    public void opdaterTræk() {
        bolleTal.setText("" + bolleTræk);
        krydsTal.setText("" + krydsTræk);
    }

    //metode der opdaterer label med antal spil vundet
    public void opdaterVinder(){
        bolleSejr.setText("" + bolleVinder);
        krydsSejr.setText("" + krydsVinder);
    }

    //Metode der gør at man ikke kan klikke på nogen felter
    //Bruges når en spiller har vundet
    public void vinderFundet(){
        felt1.setDisable(true);
        felt2.setDisable(true);
        felt3.setDisable(true);
        felt4.setDisable(true);
        felt5.setDisable(true);
        felt6.setDisable(true);
        felt7.setDisable(true);
        felt8.setDisable(true);
        felt9.setDisable(true);
    }

    //Metode der gør at man igen kan klikke på alle felter
    //Bruges når man starter spillet forfra
    public void resetFelter(){
        felt1.setDisable(false);
        felt2.setDisable(false);
        felt3.setDisable(false);
        felt4.setDisable(false);
        felt5.setDisable(false);
        felt6.setDisable(false);
        felt7.setDisable(false);
        felt8.setDisable(false);
        felt9.setDisable(false);
    }

    //metode der sætter eller fjerner en brik
    public void sætBrik1(){
        // Nedenstående kommentarer gælder for alle feltPressed metoder.
        //fjerner kryds brik hvis den allerede ligger på feltet når der bliver klikket.
        //Det kan den kun hvis der er 3 kryds brikker på brættet
        if (krydsKnap.isSelected() && kryds1.isVisible() && maxKrydser == 3)
        {
            kryds1.setVisible(false);
            maxKrydser--;
        }

        //samme scenario med bolle brikker
        else if (bolleKnap.isSelected() && bolle1.isVisible() && maxBoller == 3)
        {
            bolle1.setVisible(false);
            maxBoller--;
        }

        //Bolle kan kan ikke lægges, hvis der allerede ligger et kryds
        else if (bolleKnap.isSelected() && kryds1.isVisible())
        {
            bolle1.setVisible(false);
        }

        //kryds kan kan ikke lægges, hvis der allerede ligger et bolle
        else if (krydsKnap.isSelected() && bolle1.isVisible())
        {
            kryds1.setVisible(false);
        }

        // Hvis der ikke allerede ligger 3 brikker, kan man lægge en brik
        //Træk bliver talt op, og det samme gør antal brikker på brættet
        // Hvis kryds har lagt en brik, bliver bolle selected automatisk
        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds1.isVisible())
        {
            kryds1.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle1.isVisible())
        {
            bolle1.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik2(){
        if (krydsKnap.isSelected() && kryds2.isVisible() && maxKrydser == 3)
        {
            kryds2.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle2.isVisible() && maxBoller == 3)
        {
            bolle2.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds2.isVisible())
        {
            bolle2.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle2.isVisible())
        {
            kryds2.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds2.isVisible())
        {
            kryds2.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle2.isVisible())
        {
            bolle2.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik3(){
        if (krydsKnap.isSelected() && kryds3.isVisible() && maxKrydser == 3)
        {
            kryds3.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle3.isVisible() && maxBoller == 3)
        {
            bolle3.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds3.isVisible())
        {
            bolle3.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle3.isVisible())
        {
            kryds3.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds3.isVisible())
        {
            kryds3.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle3.isVisible())
        {
            bolle3.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik4(){
        if (krydsKnap.isSelected() && kryds4.isVisible() && maxKrydser == 3)
        {
            kryds4.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle4.isVisible() && maxBoller == 3)
        {
            bolle4.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds4.isVisible())
        {
            bolle4.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle4.isVisible())
        {
            kryds4.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds4.isVisible())
        {
            kryds4.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle4.isVisible())
        {
            bolle4.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik5(){
        if (krydsKnap.isSelected() && kryds5.isVisible() && maxKrydser == 3)
        {
            kryds5.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle5.isVisible() && maxBoller == 3)
        {
            bolle5.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds5.isVisible())
        {
            bolle5.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle5.isVisible())
        {
            kryds5.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds5.isVisible())
        {
            kryds5.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle5.isVisible())
        {
            bolle5.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik6(){
        if (krydsKnap.isSelected() && kryds6.isVisible() && maxKrydser == 3)
        {
            kryds6.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle6.isVisible() && maxBoller == 3)
        {
            bolle6.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds6.isVisible())
        {
            bolle6.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle6.isVisible())
        {
            kryds6.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds6.isVisible())
        {
            kryds6.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle6.isVisible())
        {
            bolle6.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik7(){
        if (krydsKnap.isSelected() && kryds7.isVisible() && maxKrydser == 3)
        {
            kryds7.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle7.isVisible() && maxBoller == 3)
        {
            bolle7.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds7.isVisible())
        {
            bolle7.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle7.isVisible())
        {
            kryds7.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds7.isVisible())
        {
            kryds7.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle7.isVisible())
        {
            bolle7.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik8(){
        if (krydsKnap.isSelected() && kryds8.isVisible() && maxKrydser == 3)
        {
            kryds8.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle8.isVisible() && maxBoller == 3)
        {
            bolle8.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds8.isVisible())
        {
            bolle8.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle8.isVisible())
        {
            kryds8.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds8.isVisible())
        {
            kryds8.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle8.isVisible())
        {
            bolle8.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    public void sætBrik9(){
        if (krydsKnap.isSelected() && kryds9.isVisible() && maxKrydser == 3)
        {
            kryds9.setVisible(false);
            maxKrydser--;
        }
        else if (bolleKnap.isSelected() && bolle9.isVisible() && maxBoller == 3)
        {
            bolle9.setVisible(false);
            maxBoller--;
        }

        else if (bolleKnap.isSelected() && kryds9.isVisible())
        {
            bolle9.setVisible(false);
        }
        else if (krydsKnap.isSelected() && bolle9.isVisible())
        {
            kryds9.setVisible(false);
        }

        else if (krydsKnap.isSelected() && maxKrydser != 3 && !kryds9.isVisible())
        {
            kryds9.setVisible(true);
            krydsTræk++;
            maxKrydser++;
            bolleKnap.setSelected(true);
        }
        else if (bolleKnap.isSelected() && maxBoller != 3 && !bolle9.isVisible())
        {
            bolle9.setVisible(true);
            bolleTræk++;
            maxBoller++;
            krydsKnap.setSelected(true);
        }
    }

    @FXML
    void bolleSelected(ActionEvent event)
    {
    }

    @FXML
    void krydsSelected(ActionEvent event)
    {
    }
    public void hvemVandt(){
        dog.setVisible(false);
        dogLabel.setVisible(false);
        cat.setVisible(false);
        catLabel.setVisible(false);
    }

    //Reseter alle int, så man kan starte forfra
    public void resetInt(){
        krydsTræk = 0;
        bolleTræk = 0;
        maxKrydser = 0;
        maxBoller = 0;
    }

    public void fjernBrikker(){
        kryds1.setVisible(false);
        kryds2.setVisible(false);
        kryds3.setVisible(false);
        kryds4.setVisible(false);
        kryds5.setVisible(false);
        kryds6.setVisible(false);
        kryds7.setVisible(false);
        kryds8.setVisible(false);
        kryds9.setVisible(false);
        bolle1.setVisible(false);
        bolle2.setVisible(false);
        bolle3.setVisible(false);
        bolle4.setVisible(false);
        bolle5.setVisible(false);
        bolle6.setVisible(false);
        bolle7.setVisible(false);
        bolle8.setVisible(false);
        bolle9.setVisible(false);
    }

    //Bolle bliver selected som standart når man starter et spil
    public void autoBolleSelect(){
        bolleKnap.setSelected(true);
    }

    //Checker om enten kryds eller bolle har vundet.
    //Hvis bolle har vundet vil der komme en hund frem med tilhørende label.
    //Hvis kryds har vundet vil der komme en kat frem med tilhørende label.
    public void checkVinder(){
        if (bolle1.isVisible() && bolle2.isVisible() && bolle3.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle4.isVisible() && bolle5.isVisible() && bolle6.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle7.isVisible() && bolle8.isVisible() && bolle9.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle1.isVisible() && bolle4.isVisible() && bolle7.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle2.isVisible() && bolle5.isVisible() && bolle8.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle3.isVisible() && bolle6.isVisible() && bolle9.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle1.isVisible() && bolle5.isVisible() && bolle9.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (bolle3.isVisible() && bolle5.isVisible() && bolle7.isVisible()){
            bolleVinder++;
            vinderFundet();
            dog.setVisible(true);
            dogLabel.setVisible(true);
        }
        else if (kryds1.isVisible() && kryds2.isVisible() && kryds3.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds4.isVisible() && kryds5.isVisible() && kryds6.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds7.isVisible() && kryds8.isVisible() && kryds9.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds1.isVisible() && kryds4.isVisible() && kryds7.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds2.isVisible() && kryds5.isVisible() && kryds8.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds3.isVisible() && kryds6.isVisible() && kryds9.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds1.isVisible() && kryds5.isVisible() && kryds9.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        else if (kryds3.isVisible() && kryds5.isVisible() && kryds7.isVisible()){
            krydsVinder++;
            vinderFundet();
            cat.setVisible(true);
            catLabel.setVisible(true);
        }
        opdaterVinder();
    }
}