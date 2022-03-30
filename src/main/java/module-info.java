module com.example.assignment2gc200455715 {    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    exports com.example.assignment2gc200455715;

    opens com.example.assignment2gc200455715 to
            javafx.fxml,
            com.google.gson;
}
