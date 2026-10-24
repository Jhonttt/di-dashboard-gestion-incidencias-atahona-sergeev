package es.ies.incidencias;

import es.ies.incidencias.data.SampleData;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.view.TopBar;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ObservableList<Incidencia> tableData = SampleData.incidencias();
        TopBar nav = new TopBar();

        TableView<Incidencia> table = new TableView<>();

        TableColumn<Incidencia, String> colName = new TableColumn<>("Nombre");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setPrefWidth(150);

        TableColumn<Incidencia, String> colState = new TableColumn<>("Estado");
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));
        colState.setPrefWidth(100);

        TableColumn<Incidencia, String> colPriority = new TableColumn<>("Prioridad");
        colPriority.setCellValueFactory(new PropertyValueFactory<>("priority"));
        colPriority.setPrefWidth(100);

        TableColumn<Incidencia, String> colLastUpdated = new TableColumn<>("Última actualización");
        colLastUpdated.setCellValueFactory(new PropertyValueFactory<>("lastUpdated"));
        colLastUpdated.setPrefWidth(150);

        TableColumn<Incidencia, String> colCreationDate = new TableColumn<>("Fecha de creación");
        colCreationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        colCreationDate.setPrefWidth(120);

        TableColumn<Incidencia, String> colOptions = new TableColumn<>("Opciones");
        colOptions.setCellValueFactory(new PropertyValueFactory<>("options"));
        colOptions.setPrefWidth(120);

        table.getColumns()
                .addAll(
                        colName,
                        colState,
                        colPriority,
                        colLastUpdated,
                        colCreationDate,
                        colOptions);

        table.setItems(tableData);

        HBox footer =
                new HBox(
                        20,
                        new Label("Total de incidencias: 33"),
                        new Label("Abiertas: 33"),
                        new Label("En proceso: 33"),
                        new Label("Resueltas: 33"));

        footer.setAlignment(Pos.CENTER_LEFT);

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
