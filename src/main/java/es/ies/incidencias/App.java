package es.ies.incidencias;

import es.ies.incidencias.model.Incidencia;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        TextField searchInput = new TextField();
        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");
        HBox.setHgrow(searchInput, Priority.ALWAYS);

        Button searchButton = new Button("Buscar");
        searchButton.setDefaultButton(true);

        MenuButton filterButton = new MenuButton("Filtros");

        MenuItem estados = new MenuItem("Estados:");
        estados.setDisable(true);

        MenuItem prioridades = new MenuItem("Prioridades:");
        prioridades.setDisable(true);

        filterButton
                .getItems()
                .addAll(
                        estados,
                        new CheckMenuItem("Abiertas"),
                        new CheckMenuItem("En proceso"),
                        new CheckMenuItem("Resueltas"),
                        new SeparatorMenuItem(),
                        prioridades,
                        new CheckMenuItem("Alta"),
                        new CheckMenuItem("Media"),
                        new CheckMenuItem("Baja"));

        Button createButton = new Button("Crear incidencia");

        HBox nav =
                new HBox(
                        10,
                        new Label("Incidencia: "),
                        searchInput,
                        searchButton,
                        filterButton,
                        createButton);

        nav.setAlignment(Pos.CENTER_LEFT);

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

        ObservableList<Incidencia> data =
                FXCollections.observableArrayList(
                        new Incidencia(
                                "Error en pasarela de pago",
                                "Abierta",
                                "Crítica",
                                LocalDateTime.parse(
                                        "2025-09-23T09:30:00",
                                        DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                                LocalDate.parse("2025-09-01")),
                        new Incidencia(
                                "Fallo de renderizado en UI",
                                "En proceso",
                                "Media",
                                LocalDateTime.parse(
                                        "2025-12-20T10:30:00",
                                        DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                                LocalDate.parse("2025-12-03")),
                        new Incidencia(
                                "Actualizar dependencias Maven",
                                "Resueltas",
                                "Baja",
                                LocalDateTime.parse(
                                        "2026-01-18T11:00:00",
                                        DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                                LocalDate.parse("2026-01-05")),
                        new Incidencia(
                                "Fuga de memoria en controlador",
                                "Abierta",
                                "Alta",
                                LocalDateTime.parse(
                                        "2026-03-15T12:00:00",
                                        DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                                LocalDate.parse("2026-03-07")),
                        new Incidencia(
                                "Error 404 en imágenes de perfil",
                                "En proceso",
                                "Baja",
                                LocalDateTime.parse(
                                        "2026-05-12T13:00:00",
                                        DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                                LocalDate.parse("2026-05-09")));
        table.setItems(data);

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
