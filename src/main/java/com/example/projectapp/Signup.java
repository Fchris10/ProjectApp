package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Signup {

    @FXML
    public Button idSignup;
    @FXML
    public Button idCancel;
    @FXML
    private CheckBox idShowPawd;
    @FXML
    private CheckBox idConfirmPawd;
    @FXML
    private Label idPawd;
    @FXML
    private Label idCPawd;
    @FXML
    private PasswordField idPassword;
    @FXML
    private PasswordField idConfirmPassword;
    @FXML
    private TextField idFullName;
    @FXML
    private TextField idUsername;

    int countCheckBox1 = 0, countCheckBox2 = 0;
    boolean value = false;

    public void checkAll(){
        String nameStr = idFullName.toString();
        //check 1
        if(idFullName.getText().isEmpty() || idUsername.getText().isEmpty() || idPassword.getText().isEmpty() || idConfirmPassword.getText().isEmpty()){
            value = true;
        }
        //check 2
        for(char c : nameStr.toCharArray()){
            if(Character.isDigit(c)){
                value = true;
            }
        }
        //check 3

    }
    public void onSignupClicked() {
        //insert of username and password in the database
        if(value){
            switchToLogin();
        } else System.out.println("Error access");
    }
    public void switchToLogin(){
        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = fxmlLoader1.load();
            Stage stage1 = (Stage) idSignup.getScene().getWindow();
            stage1.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onCancelClicked() {
        try{
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = fxmlLoader2.load();
            Stage stage2 = (Stage) idCancel.getScene().getWindow();
            stage2.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ShowPawdClicked() {
        countCheckBox1++;

        if (countCheckBox1 % 2 != 0) {
            idPassword.setVisible(false);
            idPawd.setText(idPassword.getText());
            idPawd.setVisible(true);
        } else {
            idPassword.setVisible(true);
            idPawd.setVisible(false);
        }
    }

    public void ConfirmPawdClicked() {
        countCheckBox2++;

        if (countCheckBox2 % 2 != 0) {
            idConfirmPassword.setVisible(false);
            idCPawd.setText(idConfirmPassword.getText());
            idCPawd.setVisible(true);
        } else {
            idConfirmPassword.setVisible(true);
            idPawd.setVisible(false);
        }
    }
}