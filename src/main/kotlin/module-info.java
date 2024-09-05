module com.slade.fxtutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.slade.fxtutorial to javafx.fxml;
    exports com.slade.fxtutorial;
}