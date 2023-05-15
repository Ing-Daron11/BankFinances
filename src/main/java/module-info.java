module com.example.employeemanager {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.employeemanager to javafx.fxml;
    exports com.example.employeemanager;

    opens com.example.employeemanager.controller to javafx.fxml;
    exports com.example.employeemanager.controller;

    opens com.example.employeemanager.model to javafx.fxml;
    exports com.example.employeemanager.model;
}