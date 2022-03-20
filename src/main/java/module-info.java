module com.employeexml.employeecrudxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.jfoenix;
    requires java.xml;

    opens com.employeexml.employeecrudxml to javafx.fxml;
    exports com.employeexml.employeecrudxml;
    exports controllers;
    opens controllers to javafx.fxml;
}