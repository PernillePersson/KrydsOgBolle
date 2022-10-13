module com.example.testkryds {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testkryds to javafx.fxml;
    exports com.example.testkryds;
}