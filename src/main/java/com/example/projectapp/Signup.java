package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Signup {

    @FXML private Button idSignup;
    @FXML private Button idCancel;
    @FXML private CheckBox idShowPawd;
    @FXML private CheckBox idConfirmPawd;
    @FXML private TextField idPawd;
    @FXML private TextField idCPawd;
    @FXML private PasswordField idPassword;
    @FXML private PasswordField idConfirmPassword;
    @FXML private TextField idFullName;
    @FXML private TextField idUsername;

    boolean countCheckBox1 = false, countCheckBox2 = false;
    boolean error = false;

    public void importantCheck() {
        if (idFullName.getText().isEmpty() || idUsername.getText().isEmpty() || idPassword.getText().isEmpty() || idConfirmPassword.getText().isEmpty() || !idPassword.getText().equals(idConfirmPassword.getText())) {
            error = true;
        } else {
            error = false;
        }
        //check all if the text fields are empty or not and if password == confirm password
    }
    public void errorName() {
        if (Pattern.compile("[0-9]").matcher(idFullName.getText()).find()) {
            error = true;
        }
        //check if in the full name there's a number
    }
    public void passwordConstraint() {
        boolean numError = true, charError = true, symbolError = true;
        String password = new String(idPawd.getText());

        if (Pattern.compile("[0-9]").matcher(password).find()) {
            numError = false;
        }
        if (Pattern.compile("[a-z]").matcher(password).find() && Pattern.compile("[A-Z]").matcher(password).find()) {
            charError = false;
        }
        if (Pattern.compile("[^a-zA-Z0-9\\\\s]").matcher(password).find()) {
            symbolError = false;
        }
        if (password.length() >= 8 && !numError && !charError && !symbolError) {
            error = false;
        } else {
            error = true;
        }
        //check if password contains a letter, a number and a special symbol
    }
    public void onSignupClicked() {
        passwordConstraint();
        importantCheck();
        errorName();
        if (!error) {
            switchToLogin();
        } else {
            System.out.println("Error: Please check your inputs.");
        }
        //after all checks, if !error we can switch to log in
    }
    public void switchToLogin(){
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("Login.fxml"));
                Parent root = fxmlLoader1.load();
                Stage stage1 = (Stage) idSignup.getScene().getWindow();
                stage1.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    public void onCancelClicked() {
        switchToLogin();
    }

    //two methods that make the 'password' and 'confirm password' visible
    public void ShowPawdClicked() {
        countCheckBox1 = !countCheckBox1;

        if (countCheckBox1) {
            idPassword.setVisible(false);
            idPawd.setText(idPassword.getText());
            idPawd.setVisible(true);
        } else {
            idPassword.setText(idPawd.getText());
            idPassword.setVisible(true);
            idPawd.setVisible(false);
        }
    }
    public void ConfirmPawdClicked() {
        countCheckBox2 = !countCheckBox2;

        if (countCheckBox2) {
            idConfirmPassword.setVisible(false);
            idCPawd.setText(idConfirmPassword.getText());
            idCPawd.setVisible(true);
        } else {
            idConfirmPassword.setText(idCPawd.getText());
            idConfirmPassword.setVisible(true);
            idCPawd.setVisible(false);
        }
    }
}