module com.employeexml.employeecrudxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.employeexml.employeecrudxml to javafx.fxml;
    exports com.employeexml.employeecrudxml;
}