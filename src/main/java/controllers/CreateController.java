package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateController implements Initializable {
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtEmail;
    public VBox PhonesArea;
    public VBox AddressesArea;
    public JFXButton btnAdd;
    public JFXButton btnBack;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
