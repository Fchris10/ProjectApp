package com.example.projectapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    public TextField idUsername;
    @FXML
    public PasswordField idPassword;
    @FXML
    public CheckBox idCheckBox;
    @FXML
    public Button idLogin;
    @FXML
    public Label idVisiblePawd;

    int countClick = 0;
    public void onCheckBoxClicked(ActionEvent actionEvent) {
        countClick++;

        if (countClick % 2 != 0) {
            idPassword.setVisible(false);
            idVisiblePawd.setText(" " + idPassword.getText());
            idVisiblePawd.setVisible(true);
        } else {
            idPassword.setVisible(true);
            idVisiblePawd.setVisible(false);
        }
    }

    public void onLoginClicked(ActionEvent actionEvent) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("App.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) idLogin.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
