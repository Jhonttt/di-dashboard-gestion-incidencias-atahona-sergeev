package es.ies.incidencias;

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        TextField searchInput = new TextField();
        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");

        HBox.setHgrow(searchInput, Priority.ALWAYS);

        Button searchButton = new Button("Buscar");
        searchButton.setDefaultButton(true);

        HBox nav = new HBox(10, new Label("Incidencia: "), searchInput, searchButton);

        nav.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(14, nav);

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 820, 500);
        stage.setTitle("Gestor de incidencias");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
