package es.ies.incidencias;

import es.ies.incidencias.data.SampleData;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.view.Footer;
import es.ies.incidencias.view.IncidenciasTable;
import es.ies.incidencias.view.TopBar;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Incidencia> tableData = SampleData.incidencias();

        TopBar nav = new TopBar();
        IncidenciasTable table = new IncidenciasTable(tableData);
        Footer footer = new Footer();

        BorderPane root = new BorderPane();
        root.setTop(nav);
        root.setCenter(table);
        root.setBottom(footer);

        BorderPane.setMargin(table, new Insets(14, 0, 14, 0));
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
