package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML private TextField idUsername;
    @FXML private PasswordField idPassword;
    @FXML private Button idLogin;
    @FXML private TextField idVisiblePawd;
    @FXML private Label idSignupLabel;

    boolean countClick = false;
    //a method that make the 'password' of log in visible
    public void onCheckBoxClicked() {
        countClick = !countClick;

        if (countClick) {
            idPassword.setVisible(false);
            idVisiblePawd.setText(idPassword.getText());
            idVisiblePawd.setVisible(true);
        } else {
            idPassword.setText(idVisiblePawd.getText());
            idPassword.setVisible(true);
            idVisiblePawd.setVisible(false);
        }
    }
    //implementing the database, after that user compiles 'username' and 'password' he/she can switch to the main scene
    public void onLoginClicked() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) idLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //the user switches to the page of sign up
    public void onSignupLabelClicked() {

        try{
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Signup.fxml"));
            Parent root = fxmlLoader1.load();
            Stage stage1 = (Stage) idSignupLabel.getScene().getWindow();
            stage1.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}