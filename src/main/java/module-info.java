module com.ytgrabber.ytgrabber {
    requires javafx.controls;
    requires javafx.fxml;
    requires vget;

    opens com.ytgrabber to javafx.fxml;
    exports com.ytgrabber;
    exports com.ytgrabber.controller;
    opens com.ytgrabber.controller to javafx.fxml;
    exports com.ytgrabber.model;
    opens com.ytgrabber.model to javafx.fxml;
}