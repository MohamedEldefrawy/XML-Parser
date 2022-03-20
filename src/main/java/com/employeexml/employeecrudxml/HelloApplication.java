package com.employeexml.employeecrudxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class
                .getResource("/com/employeexml/employeecrudxml/views/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add("/com/employeexml/employeecrudxml/styles/style.css");
        stage.setTitle("XML DEMO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}