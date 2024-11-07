package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane rootNode;
    public TextField txtuserName;
    public PasswordField txtpassword;
    public JFXButton btnLogin;
    public Hyperlink hyperRegister;
    public AnchorPane node;

    public void btnLoginOnAction(ActionEvent actionEvent) {
    }

    public void hyperRegisterOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/register-form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage)this.node.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Registation Form");
    }
}
