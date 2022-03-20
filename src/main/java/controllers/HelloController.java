package controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import utilities.SceneChanger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public JFXButton btnCreate;
    public JFXButton btnView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnCreate.setOnAction(actionEvent -> {

            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            try {
                SceneChanger.switchToCreateScene(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnView.setOnAction(actionEvent -> {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            try {
                SceneChanger.switchToEmployeesScene(stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}