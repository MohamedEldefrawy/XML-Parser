package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Employee;
import utilities.SceneChanger;

import java.io.IOException;
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
            if (!txtName.getText().equals("")) {
                newEmployee.setName(txtName.getText());
            }

            if (!txtEmail.getText().equals("")) {
                newEmployee.setEmail(txtName.getText());
            }

            if (!txtSalary.getText().equals("")) {
                newEmployee.setSalary(Integer.parseInt(txtSalary.getText()));
            }
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
}
