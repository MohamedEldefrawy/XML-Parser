package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Address;
import model.Employee;
import model.Phone;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    public TextField txtFirstAddressBuilding;
    public TextField txtSecondAddressCountry;
    public TextField txtSecondAddressCity;
    public TextField txtSecondAddressRegion;
    public TextField txtSecondAddressStreet;
    public TextField txtSecondAddressBuilding;
    public TextField txtName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Employee newEmployee = new Employee();
        cmbFirstPhoneType.getItems().addAll("Type", "Mobile", "Phone");
        cmbFirstPhoneType.getSelectionModel().selectFirst();
        cmbSecondPhoneType.getItems().addAll("Type", "Mobile", "Phone");
        cmbSecondPhoneType.getSelectionModel().selectFirst();
        cmbThirdPhoneType.getItems().addAll("Type", "Mobile", "Phone");
        cmbThirdPhoneType.getSelectionModel().selectFirst();

        btnAdd.setOnAction(actionEvent -> {
            List<Address> newAddresses = new ArrayList<Address>();
            List<Phone> newPhones = new ArrayList<Phone>();
            if (!txtName.getText().equals("")) {
                newEmployee.setName(txtName.getText());
            }

            if (!txtEmail.getText().equals("")) {
                newEmployee.setEmail(txtName.getText());
            }

            if (!txtSalary.getText().equals("")) {
                newEmployee.setSalary(Integer.parseInt(txtSalary.getText()));
            }
            getNewAddresses(newAddresses, txtFirstAddressCountry, txtFirstAddressCity,
                    txtFirstAddressRegion, txtFirstAddressStreet, txtFirstAddressBuilding);
            getNewAddresses(newAddresses, txtSecondAddressCountry, txtSecondAddressCity,
                    txtSecondAddressRegion, txtSecondAddressStreet, txtSecondAddressBuilding);

            newEmployee.setAddresses(newAddresses);
            getNewPhones(newPhones, cmbFirstPhoneType, txtFirstPhone);
            getNewPhones(newPhones, cmbSecondPhoneType, txtSecondPhone);
            newEmployee.setPhones(newPhones);
        });
        btnBack.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            try {
                SceneChanger.switchToHomeScene(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void getNewPhones(List<Phone> newPhones, JFXComboBox cmbFirstPhoneType, TextField txtFirstPhone) {
        if (!cmbFirstPhoneType.getSelectionModel().getSelectedItem().equals("Type")) {
            var newPhone = new Phone();
            if (!txtFirstPhone.getText().equals("")) {
                newPhone.setType(cmbFirstPhoneType.getSelectionModel().getSelectedItem().toString());
                newPhone.setNumber(txtFirstPhone.getText());
            }
            newPhones.add(newPhone);
        }
    }

    private void getNewAddresses(List<Address> newAddresses, TextField txtSecondAddressCountry, TextField txtSecondAddressCity, TextField txtSecondAddressRegion, TextField txtSecondAddressStreet, TextField txtSecondAddressBuilding) {
        if (!txtSecondAddressCountry.getText().equals("")) {

            var newAddress = new Address();
            newAddress.setCountry(txtSecondAddressCountry.getText());
            if (!txtSecondAddressCity.getText().equals("")) {
                newAddress.setCity(txtSecondAddressCity.getText());
            }

            if (!txtSecondAddressRegion.getText().equals("")) {
                newAddress.setRegion(txtSecondAddressRegion.getText());
            }
            if (!txtSecondAddressStreet.getText().equals("")) {
                newAddress.setStreet(txtSecondAddressStreet.getText());
            }
            if (!txtSecondAddressBuilding.getText().equals("")) {
                newAddress.setBuilding(txtSecondAddressBuilding.getText());
            }
            newAddresses.add(newAddress);
        }
    }
}
