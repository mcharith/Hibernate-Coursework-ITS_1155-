package org.example.controller.user;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DashboardForm {
    public AnchorPane rootNode;
    public AnchorPane root;
    public AnchorPane node;
    public Label lblStudent;
    public Label lblCourse;
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnCourseFrom;
    public JFXButton btnStudentForm;
    public JFXButton btnDashbord;

    public void initialize() {
        setDate();
        updateTime();
    }

    private void setDate() {
        LocalDate now = LocalDate.now();
        lblDate.setText(String.valueOf(now));
    }

    private void updateTime() {
        LocalTime currentTime = LocalTime.now();
        String formattedTime = currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        lblTime.setText(formattedTime);
    }

    public void btnCourseFormOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/user-course-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }

    public void btnStudentFormnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/student-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }

    public void btnDashboardFormOnActin(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(this.getClass().getResource("/view/user/back-to-dashboard-form.fxml"));
        node.getChildren().clear();
        node.getChildren().add(anchorPane);
    }
}
