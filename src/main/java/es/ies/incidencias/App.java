package es.ies.incidencias;

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
import javafx.scene.control.ComboBox;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private BorderPane mainLayout;

    public static class Incidencia {

        private String name;
        private String state;
        private String priority;
        private LocalDateTime lastUpdated;
        private LocalDate creationDate;
        private final String options = "...";
        private String content = "";

        public Incidencia(
                String name,
                String state,
                String priority,
                LocalDateTime lastUpdated,
                LocalDate creationDate) {
            this.name = name;
            this.state = state;
            this.priority = priority;
            this.lastUpdated = lastUpdated;
            this.creationDate = creationDate;
        }

        public Incidencia(String name, String state, String priority) {
            this.name = name;
            this.state = state;
            this.priority = priority;
            this.lastUpdated = LocalDateTime.now();
            this.creationDate = LocalDate.now();
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public String getPriority() {
            return priority;
        }

        public LocalDateTime getLastUpdated() {
            return lastUpdated;
        }

        public LocalDate getCreationDate() {
            return creationDate;
        }

        public String getOptions() {
            return options;
        }

        public String getContent() {
            return content;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public void updateLastUpdated() {
            this.lastUpdated = LocalDateTime.now();
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        TextField searchInput = new TextField();
        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");
        HBox.setHgrow(searchInput, Priority.ALWAYS);

        Button searchButton = new Button("Buscar");
        searchButton.setDefaultButton(true);

        ComboBox<String> sortButton = new ComboBox<>();
        sortButton.getItems().addAll("Alfabéticamente", "Cronológicamente");
        sortButton.setValue("Ordenar");

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
                        sortButton,
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

        mainLayout = new BorderPane();
        mainLayout.setCenter(table);

        HBox footer =
                new HBox(
                        20,
                        new Label("Total de incidencias: 33"),
                        new Label("Abiertas: 33"),
                        new Label("En proceso: 33"),
                        new Label("Resueltas: 33"));

        nav.setAlignment(Pos.CENTER_LEFT);

        VBox root = new VBox(14, nav, table, footer);

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
