package org.example.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminDashboardFormController {
    public AnchorPane rootNode;
    public AnchorPane root;
    public AnchorPane node;
    public JFXButton btnCourseFrom;
    public JFXButton btnStudentForm;
    public JFXButton btnDashbord;
    public JFXButton btnMangeDetalis;
    public ImageView btnSetting;
    public JFXButton btnLogOut;
    public Label lblStudent;
    public Label lblCourse;
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnUserManage;

    public void btnCourseFormOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/admin/courses-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }

    public void btnStudentFormnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/admin/admin-student-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }

    public void btnDashboardFormOnActin(ActionEvent actionEvent) {
    }

    public void btnManageDetailsOnAction(ActionEvent actionEvent) {
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene loginScene = new Scene(FXMLLoader.load(getClass().getResource("/view/login-form.fxml")));
        stage.setScene(loginScene);
        stage.setTitle("Login Page");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnUserManageOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/admin/admin-user-manage-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }
}
