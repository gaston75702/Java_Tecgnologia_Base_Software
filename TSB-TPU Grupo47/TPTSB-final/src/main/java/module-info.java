module com.example.tptsbfinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens Interfaz to javafx.fxml;
    exports Interfaz;
}