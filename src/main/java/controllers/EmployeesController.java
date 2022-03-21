package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Employee;
import services.EmployeeServices;
import utilities.SceneChanger;
import utilities.XmlHandler;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    private EmployeeServices employeeServices;
    private XmlHandler xmlHandler;

    private int employeeIndex = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        xmlHandler = new XmlHandler("target/classes/dataSource/employees.xml");

        employeeServices = new EmployeeServices();
        var employees = employeeServices.getEmployees(xmlHandler.getDocument());

        if (employees.size() > 0) {
            showEmployee(employees);
            employeeIndex++;
        }


        btnBack.setOnAction(actionEvent ->

        {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            try {
                SceneChanger.switchToHomeScene(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnNext.setOnAction(actionEvent ->

        {
            if (employeeIndex >= employees.size() || employeeIndex < 0)
                employeeIndex = 0;
            showEmployee(employees);
            employeeIndex++;
        });

        btnPrev.setOnAction(actionEvent ->
        {
            if (employeeIndex < 0)
                employeeIndex = employees.size() - 1;
            showEmployee(employees);
            employeeIndex--;
        });

    }

    private void showEmployee(List<Employee> employees) {
        txtName.setText(employees.get(employeeIndex).getName());
        txtEmail.setText(employees.get(employeeIndex).getEmail());
        txtSalary.setText(String.valueOf(employees.get(employeeIndex).getSalary()));
        for (int i = 0; i < employees.get(employeeIndex).getPhones().size(); i++) {
            switch (i) {
                case 0: {
                    txtFirstPhone.setText(employees.get(employeeIndex).getPhones().get(i).getNumber());
                    cmbFirstPhoneType.getSelectionModel().select((employees.get(employeeIndex).getPhones().get(i).getType()));
                }
                case 1: {
                    txtSecondPhone.setText(employees.get(employeeIndex).getPhones().get(i).getNumber());
                    cmbSecondPhoneType.getSelectionModel().select((employees.get(employeeIndex).getPhones().get(i).getType()));
                }
                case 2: {
                    txtThirdPhone.setText(employees.get(employeeIndex).getPhones().get(i).getNumber());
                    cmbThirdPhoneType.getSelectionModel().select((employees.get(employeeIndex).getPhones().get(i).getType()));
                }
                default:
                    break;
            }
        }

        for (int i = 0; i < employees.get(employeeIndex).getAddresses().size(); i++) {
            switch (i) {
                case 0: {
                    txtFirstAddressCountry.setText(employees.get(employeeIndex).getAddresses().get(i).getCountry());
                    txtFirstAddressCity.setText(employees.get(employeeIndex).getAddresses().get(i).getCity());
                    txtFirstAddressRegion.setText(employees.get(employeeIndex).getAddresses().get(i).getRegion());
                    txtFirstAddressStreet.setText(employees.get(employeeIndex).getAddresses().get(i).getStreet());
                    txtFirstAddressBuilding.setText(employees.get(employeeIndex).getAddresses().get(i).getBuilding());
                }
                case 1: {
                    txtSecondAddressCountry.setText(employees.get(employeeIndex).getAddresses().get(i).getCountry());
                    txtSecondAddressCity.setText(employees.get(employeeIndex).getAddresses().get(i).getCity());
                    txtSecondAddressRegion.setText(employees.get(employeeIndex).getAddresses().get(i).getRegion());
                    txtSecondAddressStreet.setText(employees.get(employeeIndex).getAddresses().get(i).getStreet());
                    txtSecondAddressBuilding.setText(employees.get(employeeIndex).getAddresses().get(i).getBuilding());
                }
                default:
                    break;
            }
        }
    }
}
