package org.example.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.AdminBO;
import org.example.bo.custom.UserBO;
import org.example.dto.AdminDTO;
import org.example.dto.UserDTO;
import org.example.validation.Regex;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterFormController {
    public AnchorPane node;
    public TextField txtName;
    public TextField txtTele;
    public TextField txtEmail;
    public PasswordField txPassword;
    public JFXButton btnRegistre;
    public Hyperlink hyperLogIn;
    public TextField txtId;
    public JFXComboBox <String>cmbAccountType;
    public PasswordField txtConfirmPassword;

    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.User);
    AdminBO adminBO = (AdminBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.Admin);

    public void initialize() {
        //genarateUserId();
        cmbAccountType.getItems().addAll("User","Admin");
    }

    private String genarateUserId(){
        try {
            String currentId = userBO.getCurrentId();
            if (currentId == null) {
                String[] split = currentId.split("SU");
                int id = Integer.parseInt(split[1]);
                String avliableId = String.format("SU%04d", ++id);
                txtId.setText(avliableId);
                return avliableId;
            }else {
                txtId.setText("SU0001");
                return "SU0001";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        // Collect input values
        String id = txtId.getText();
        String name = txtName.getText();
        String teleStr = txtTele.getText();
        String type = cmbAccountType.getValue();
        String email = txtEmail.getText();
        String password = txPassword.getText();
        String rePassword = txtConfirmPassword.getText();

        // Validate if any required field is empty
        if (id.isEmpty() || name.isEmpty() || teleStr.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty() || type == null) {
            new Alert(Alert.AlertType.ERROR, "All fields are required").show();
            return;
        }

        // Validate telephone as a number
        int tele;
        try {
            tele = Integer.parseInt(teleStr);
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Invalid telephone number").show();
            return;
        }

        // Check if passwords match
        if (!password.equals(rePassword)) {
            new Alert(Alert.AlertType.ERROR, "Passwords do not match").show();
            return;
        }

        // Validate email and password using Regex
//        if (!Regex.validateEmail(email) || !Regex.validatePassword(password)) {
//            new Alert(Alert.AlertType.ERROR, "Invalid email or password format").show();
//            return;
//        }

        // Save data to the appropriate table based on account type
        try {
            if (type.equals("Admin")) {
                // Save to Admin table
                adminBO.save(new AdminDTO(id, name, tele, email, password));
            } else if (type.equals("User")) {
                // Save to User table
                userBO.save(new UserDTO(id,name,tele,email,password));
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid account type selected").show();
                return;
            }

            // Clear fields and show success message
            cleanFields();
            new Alert(Alert.AlertType.INFORMATION, "Successfully registered").show();

            // Generate a new user ID
            txtId.setText(genarateUserId());
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Registration failed: " + e.getMessage()).show();
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

    public void cmbAccountTypeOnAction(ActionEvent actionEvent) {
    }

    private void cleanFields() {
        txtName.clear();
        txtTele.clear();
        txtEmail.clear();
        txPassword.clear();
        txtConfirmPassword.clear();
    }
}
