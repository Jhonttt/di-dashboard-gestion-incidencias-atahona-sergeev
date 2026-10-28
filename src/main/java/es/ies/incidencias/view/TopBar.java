package es.ies.incidencias.view;

import atlantafx.base.theme.Styles;
import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.model.PrioridadIncidencia;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class TopBar extends HBox {
    private static final String CLOSE_ICON =
            "m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z";
    private static final String FILTER_OFF_ICON =
            "m592-481-57-57 143-182H353l-80-80h487q25 0 36 22t-4 42L592-481ZM791-56 560-287v87q0 17-11.5 28.5T520-160h-80q-17 0-28.5-11.5T400-200v-247L56-791l56-57 736 736-57 56ZM535-538Z";
    private final TextField searchInput = new TextField();
    private final List<CheckMenuItem> statesList = new ArrayList<>();
    private final List<CheckMenuItem> prioritiesList = new ArrayList<>();
    private final Button clearInput = new Button();
    private final Button clearFilters = new Button();
    private Consumer<Incidencia> onCreate = i -> {};

    public TopBar() {
        super(10);

        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");
        HBox.setHgrow(searchInput, Priority.ALWAYS);

        clearInput.setGraphic(icon(CLOSE_ICON, 14));
        clearInput.setTooltip(new Tooltip("Borrar búsqueda"));
        clearInput.setVisible(false);
        clearInput.setManaged(false);
        clearInput.setOnAction(e -> searchInput.clear());
        clearInput.getStyleClass().addAll(Styles.BUTTON_ICON, Styles.FLAT);
        searchInput.textProperty().addListener((o, a, b) -> refreshClearInput());

        MenuButton filterButton = new MenuButton("Filtros");

        MenuItem states = new MenuItem("Estados:");
        states.setDisable(true);

        MenuItem priorities = new MenuItem("Prioridades:");
        priorities.setDisable(true);

        filterButton.getItems().add(states);

        for (EstadoIncidencia state : EstadoIncidencia.values()) {
            CheckMenuItem item = new CheckMenuItem(state.toString());
            statesList.add(item);
            filterButton.getItems().add(item);
        }

        filterButton.getItems().addAll(new SeparatorMenuItem(), priorities);

        for (PrioridadIncidencia priority : PrioridadIncidencia.values()) {
            CheckMenuItem item = new CheckMenuItem(priority.toString());
            prioritiesList.add(item);
            filterButton.getItems().add(item);
        }
        filterButton.setStyle("-fx-background-color: #fcff50;");

        clearFilters.setGraphic(icon(FILTER_OFF_ICON, 14));
        clearFilters.setTooltip(new Tooltip("Borrar búsqueda"));
        clearFilters.setVisible(false);
        clearFilters.setManaged(false);
        clearFilters.getStyleClass().addAll(Styles.BUTTON_ICON, Styles.FLAT);
        clearFilters.setOnAction(
                e -> {
                    statesList.forEach(i -> i.setSelected(false));
                    prioritiesList.forEach(i -> i.setSelected(false));
                });
        statesList.forEach(
                i -> i.selectedProperty().addListener((o, a, b) -> refreshClearFilters()));
        prioritiesList.forEach(
                i -> i.selectedProperty().addListener((o, a, b) -> refreshClearFilters()));

        Button createButton = new Button("Crear incidencia");
        createButton.getStyleClass().add(Styles.SUCCESS);
        createButton.setOnAction(e -> createIncidencia());

        getChildren()
                .addAll(
                        new Label("Incidencia: "),
                        searchInput,
                        clearInput,
                        filterButton,
                        clearFilters,
                        createButton);
        setAlignment(Pos.CENTER_LEFT);
    }

    private void createIncidencia() {
        new IncidenciaDialog(getScene().getWindow()).showAndWait().ifPresent(onCreate);
    }

    private void refreshClearInput() {
        boolean active = !searchInput.getText().equalsIgnoreCase("");
        clearInput.setVisible(active);
        clearInput.setManaged(active);
    }

    private void refreshClearFilters() {
        boolean active =
                statesList.stream().anyMatch(e -> e.isSelected())
                        || prioritiesList.stream().anyMatch(e -> e.isSelected());
        clearFilters.setVisible(active);
        clearFilters.setManaged(active);
    }

    private static Region icon(String path, int size) {
        Region icon = new Region();
        icon.setStyle(
                "-fx-shape: \""
                        + path
                        + "\";"
                        + "-fx-background-color: red;"
                        + "-fx-min-width: "
                        + size
                        + "; -fx-min-height: "
                        + size
                        + ";"
                        + "-fx-max-width: "
                        + size
                        + "; -fx-max-height: "
                        + size
                        + ";");
        return icon;
    }

    public TextField getSearchInput() {
        return searchInput;
    }

    public List<CheckMenuItem> getStatesList() {
        return statesList;
    }

    public List<CheckMenuItem> getPrioritiesList() {
        return prioritiesList;
    }

    public void setOnCreate(Consumer<Incidencia> handler) {
        this.onCreate = handler;
    }
}
