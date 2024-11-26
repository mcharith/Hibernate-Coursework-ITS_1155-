package org.example.controller.user;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.controller.LoginFormController;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.sql.SQLException;

public class UserSettingFormController {
    public AnchorPane rootNode;
    public TextField txtLoggedEmail;
    public TextField txtCurrentPassword;
    public TextField txtNewPassword;
    public TextField txtReEnterPassword;
    public JFXButton btnSave;
    public TextField txtUserName;
    public TextField txtTelephone;
    public JFXButton btnUpdate;
    public Label lblUserId;

    private User userDTO;
    UserBO userBO = (UserBO) BOFactory.getBOFactory().getBOType(BOFactory.BOType.User);

    public void initialize() {
        try {
            txtLoggedEmail.setText(LoginFormController.loggedUserEmail);
            txtUserName.setText(LoginFormController.loggedUserName);
            txtTelephone.setText(String.valueOf(LoginFormController.telephone));
            lblUserId.setText(LoginFormController.loggedUserId);

            userDTO = userBO.searchByEmail(LoginFormController.loggedUserEmail);
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Error loading user details: " + e.getMessage()).show();
        }
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        String email = txtLoggedEmail.getText();
        String password = txtCurrentPassword.getText();
        String newPassword = txtNewPassword.getText();
        String reEnterPassword = txtReEnterPassword.getText();

        if (password.isEmpty() || newPassword.isEmpty() || reEnterPassword.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return;
        }


        if (userDTO == null || !userDTO.getPassword().equals(password)) {
            showAlert(Alert.AlertType.ERROR, "Invalid Password", "The current password you entered is incorrect.");
            return;
        }

        if (!newPassword.equals(reEnterPassword)) {
            showAlert(Alert.AlertType.ERROR, "Password Mismatch", "New passwords do not match. Please try again.");
            return;
        }

        try {
            UserDTO updatedUser = new UserDTO(
                    userDTO.getUserId(),
                    txtUserName.getText(),
                    email,
                    newPassword,
                    Integer.parseInt(txtTelephone.getText())
            );

            boolean isUpdated = userBO.update(updatedUser);

            if (isUpdated) {
                showAlert(Alert.AlertType.INFORMATION, "Update Successful", "Your password has been updated.");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Update Failed", "Failed to update your password. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while updating your password: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtCurrentPassword.clear();
        txtNewPassword.clear();
        txtReEnterPassword.clear();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null); // Optional
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String email = txtLoggedEmail.getText();
        String username = txtUserName.getText();
        String telephone = txtTelephone.getText();

        try {
            // Fetch user data by email
            User userdto = userBO.searchByEmail(email);

            if (userdto == null) {
                new Alert(Alert.AlertType.ERROR, "User not found for the provided email.").show();
                return;
            }

            // Validate fields
            if (username.isEmpty() || telephone.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "All fields are required").show();
                return;
            }

            // Validate telephone format
            int phoneNumber;
            try {
                phoneNumber = Integer.parseInt(telephone);
            } catch (NumberFormatException e) {
                new Alert(Alert.AlertType.ERROR, "Invalid telephone number format.").show();
                return;
            }

            // Perform update
            boolean isUpdated = userBO.update(new UserDTO(
                    userdto.getUserId(),      // Ensure userId is passed
                    username,                 // Updated username
                    email,                    // Existing email
                    userdto.getPassword(),    // Existing password
                    phoneNumber               // Updated telephone
            ));

            // Show success or failure alert
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "User details updated successfully!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Failed to update user details.").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "An error occurred: " + e.getMessage()).show();
        }
    }
}