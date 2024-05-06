module com.example.projectapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectapp to javafx.fxml;
    exports com.example.projectapp;
}