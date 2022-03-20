package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeesController implements Initializable {
    public JFXComboBox cmbFirstPhoneType;
    public TextField txtFirstPhone;
    public JFXComboBox cmbSecondPhoneType;
    public TextField txtSecondPhone;
    public JFXComboBox cmbThirdPhoneType;
    public TextField txtThirdPhone;
    public TextField txtFirstAddressCountry;
    public TextField txtFirstAddressCity;
    public TextField txtFirstAddressRegion;
    public TextField txtFirstAddressStreet;
    public TextField txtFirstAddressBuilding;
    public TextField txtSecondAddressCountry;
    public TextField txtSecondAddressCity;
    public TextField txtSecondAddressRegion;
    public TextField txtSecondAddressStreet;
    public TextField txtSecondAddressBuilding;
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtSalary;
    public JFXButton btnNext;
    public JFXButton btnPrev;
    public JFXButton btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnBack.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            try {
                SceneChanger.switchToHomeScene(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnNext.setOnAction(actionEvent -> {

        });

        btnPrev.setOnAction(actionEvent -> {

        });

    }
}
