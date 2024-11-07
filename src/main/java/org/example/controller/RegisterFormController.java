package org.example.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.io.IOException;

public class RegisterFormController {
    public AnchorPane node;
    public TextField txtName;
    public TextField txtTele;
    public TextField txtEmail;
    public TextField txtJobRole;
    public PasswordField txPassword;
    public JFXButton btnRegistre;
    public Hyperlink hyperLogIn;
    public TextField txtId;

    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.User);

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        boolean isSaved = userBO.save(new UserDTO(txtId.getText(),txtName.getText(),Integer.parseInt(txtTele.getText()),txtEmail.getText(),
                txtJobRole.getText(),txPassword.getText()));
        System.out.println("badu awa");
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION,"Registation Successful!", ButtonType.OK).show();
            System.out.println("badu wada");
        }else {
            new Alert(Alert.AlertType.ERROR,"Something went wrong", ButtonType.CLOSE).show();
        }
    }

    public void hyperLogInOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/login-form.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = (Stage)this.node.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Login Form");
    }
}
