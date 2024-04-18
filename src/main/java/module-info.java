module himanshukhadka.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens himanshukhadka.tictactoe to javafx.fxml;
    exports himanshukhadka.tictactoe;
}