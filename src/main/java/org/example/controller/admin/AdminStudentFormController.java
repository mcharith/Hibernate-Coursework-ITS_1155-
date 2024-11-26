package org.example.controller.admin;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AdminStudentFormController {
    public AnchorPane rootNode;
    public TableView tblStudent;
    public TableColumn clmStudentId;
    public TableColumn clmName;
    public TableColumn clmAddress;
    public TableColumn clmEmail;
    public TableColumn clmTelephone;
    public TableColumn clmDOB;
    public TextField txtIds;
    public JFXButton btnUpdate;
    public JFXButton btnDelete;

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }
}
