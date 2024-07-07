module com.mycompany.movieticketbookingmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires java.desktop;
    requires jdk.jdi;
    requires jasperreports;

    opens com.mycompany.movieticketbookingmanagement to javafx.fxml;
    exports com.mycompany.movieticketbookingmanagement;
    exports com.mycompany.movieticketbookingmanagement.controller;
    opens com.mycompany.movieticketbookingmanagement.controller to javafx.fxml;
    exports com.mycompany.movieticketbookingmanagement.model;
    opens com.mycompany.movieticketbookingmanagement.model to javafx.fxml;
    exports com.mycompany.movieticketbookingmanagement.repository;
    opens com.mycompany.movieticketbookingmanagement.repository to javafx.fxml;
}
