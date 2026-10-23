package es.ies.incidencias;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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

        private String nombre;
        private String estado;
        private String prioridad;
        private String ultimaActualizacion;
        private String fechaCreacion;
        private final String opciones = "...";
        private String contenido = "";

        public Incidencia(
                String nombre,
                String estado,
                String prioridad,
                String ultimaActualizacion,
                String fechaCreacion) {
            this.nombre = nombre;
            this.estado = estado;
            this.prioridad = prioridad;
            this.ultimaActualizacion = ultimaActualizacion;
            this.fechaCreacion = fechaCreacion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEstado() {
            return estado;
        }

        public String getPrioridad() {
            return prioridad;
        }

        public String getUltimaActualizacion() {
            return ultimaActualizacion;
        }

        public String getFechaCreacion() {
            return fechaCreacion;
        }

        public String getOpciones() {
            return opciones;
        }

        public String getContenido() {
            return contenido;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public void setPrioridad(String prioridad) {
            this.prioridad = prioridad;
        }

        public void setUltimaActualizacion(String ultimaActualizacion) {
            this.ultimaActualizacion = ultimaActualizacion;
        }

        public void setContenido(String contenido) {
            this.contenido = contenido;
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
        sortButton.setValue("Filtrar");

        HBox nav = new HBox(10, new Label("Incidencia: "), searchInput, searchButton, sortButton);

        nav.setAlignment(Pos.CENTER_LEFT);

        TableView<Incidencia> tabla = new TableView<>();

        TableColumn<Incidencia, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(150);

        TableColumn<Incidencia, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colEstado.setPrefWidth(100);

        TableColumn<Incidencia, String> colPrioridad = new TableColumn<>("Prioridad");
        colPrioridad.setCellValueFactory(new PropertyValueFactory<>("prioridad"));
        colPrioridad.setPrefWidth(100);

        TableColumn<Incidencia, String> colUltimaAct = new TableColumn<>("Última actualización");
        colUltimaAct.setCellValueFactory(new PropertyValueFactory<>("ultimaActualizacion"));
        colUltimaAct.setPrefWidth(150);

        TableColumn<Incidencia, String> colFechaCreacion = new TableColumn<>("Fecha de creación");
        colFechaCreacion.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        colFechaCreacion.setPrefWidth(120);

        TableColumn<Incidencia, String> colOpciones = new TableColumn<>("Opciones");
        colOpciones.setCellValueFactory(new PropertyValueFactory<>("opciones"));
        colOpciones.setPrefWidth(120);

        tabla.getColumns()
                .addAll(
                        colNombre,
                        colEstado,
                        colPrioridad,
                        colUltimaAct,
                        colFechaCreacion,
                        colOpciones);

        ObservableList<Incidencia> datos =
                FXCollections.observableArrayList(
                        new Incidencia(
                                "Error en pasarela de pago",
                                "Abierta",
                                "Crítica",
                                "21-10-2026",
                                "21-10-2026"),
                        new Incidencia(
                                "Fallo de renderizado en UI",
                                "En proceso",
                                "Media",
                                "20-10-2026",
                                "18-10-2026"),
                        new Incidencia(
                                "Actualizar dependencias Maven",
                                "Resueltas",
                                "Baja",
                                "19-10-2026",
                                "15-10-2026"),
                        new Incidencia(
                                "Fuga de memoria en controlador",
                                "Abierta",
                                "Alta",
                                "21-10-2026",
                                "20-10-2026"),
                        new Incidencia(
                                "Error 404 en imágenes de perfil",
                                "En proceso",
                                "Baja",
                                "21-10-2026",
                                "21-10-2026"));
        tabla.setItems(datos);

        mainLayout = new BorderPane();
        mainLayout.setCenter(tabla);

        VBox root = new VBox(14, nav, tabla);

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
