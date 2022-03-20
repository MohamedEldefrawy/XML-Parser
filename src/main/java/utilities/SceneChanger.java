package utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void switchToCreateScene(Stage stage) throws IOException {
        FXMLLoader createFxmlLoader = new FXMLLoader(SceneChanger.class.
                getResource("/com/employeexml/employeecrudxml/views/Create.fxml"));
        Scene createScene = new Scene(createFxmlLoader.load());
        createScene.getStylesheets().add("/com/employeexml/employeecrudxml/styles/style.css");
        stage.setScene(createScene);
    }

    public static void switchToEmployeesScene(Stage stage) throws IOException {
        FXMLLoader employeesFxmlLoader = new FXMLLoader(SceneChanger.class.
                getResource("/com/employeexml/employeecrudxml/views/Employees.fxml"));
        Scene createScene = new Scene(employeesFxmlLoader.load());
        createScene.getStylesheets().add("/com/employeexml/employeecrudxml/styles/style.css");
        stage.setScene(createScene);
    }

    public static void switchToHomeScene(Stage stage) throws IOException {
        FXMLLoader homeFxmlLoader = new FXMLLoader(SceneChanger.class.
                getResource("/com/employeexml/employeecrudxml/views/Home.fxml"));
        Scene homeScene = new Scene(homeFxmlLoader.load());
        homeScene.getStylesheets().add("/com/employeexml/employeecrudxml/styles/style.css");
        stage.setScene(homeScene);
    }

}
