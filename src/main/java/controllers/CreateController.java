package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable {
    public TextField txtSalary;
    public TextField txtEmail;
    public JFXButton btnAdd;
    public JFXButton btnBack;
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
    public TextField txtFirstAddressBuilidng;
    public TextField txtSecondAddressCountry;
    public TextField txtSecondAddressCity;
    public TextField txtSecondAddressRegion;
    public TextField txtSecondAddressStreet;
    public TextField txtSecondAddressBuilding;
    public TextField txtname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
