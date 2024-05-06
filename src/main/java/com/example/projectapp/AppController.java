package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AppController {
    @FXML
    public TextField idRAL;
    @FXML
    public TextField idAddC;
    @FXML
    public ChoiceBox<String> idRegions;
    @FXML
    public Label idWI1;
    @FXML
    public Label idWI2;

    int countErrorRAL = 0, countErrorAddC = 0;
    String[] italianRegions = {"Abruzzo","Basilicata","Calabria","Campania","Emilia-Romagna","Friuli-Venezia Giulia","Lazio","Liguria","Lombardia","Marche","Molise","Piemonte","Puglia","Sardegna","Sicilia","Toscana","Trentino-Alto Adige","Umbria","Valle d'Aosta","Veneto"};

    public void initialize(){
        idRegions.getItems().addAll(italianRegions);
    }
    public void setRALEditable(MouseEvent mouseEvent) {
        idRAL.setEditable(true);
    }
    public void setAddCEditable(MouseEvent mouseEvent) {
        idAddC.setEditable(true);
    }
    public void errorValues(){
        if(countErrorRAL == 1 && countErrorAddC == 1){
            idWI1.setVisible(true);
            idWI2.setVisible(true);
        } else if(countErrorRAL == 1){
            idWI1.setVisible(true);
        } else if(countErrorAddC == 1){
            idWI2.setVisible(true);
        }
    }
    public void checkInsertedValues(){
        try{
            double valueOfRAL = Double.parseDouble(idRAL.getText());
        } catch (NumberFormatException e){
            countErrorRAL++;
            errorValues();
        }
        try{
            double valueOfAddC = Double.parseDouble(idAddC.getText());
        } catch (NumberFormatException e){
            countErrorAddC++;
            errorValues();
        }
        if(idRegions.getValue() == null || idRegions.getValue().isEmpty()){
            idRegions.setStyle("-fx-border-color: red; -fx-background-radius: 20; -fx-background-color: white; -fx-border-radius: 20;");
        }
    }
    public void onNextClicked(ActionEvent actionEvent) {
        checkInsertedValues();
    }

    public void onRegionsClicked(MouseEvent mouseEvent) {
        idRegions.setStyle("-fx-border-color: gray; -fx-background-radius: 20; -fx-background-color: white; -fx-border-radius: 20;");
    }
}