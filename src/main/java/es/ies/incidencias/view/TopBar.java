package es.ies.incidencias.view;

import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.PrioridadIncidencia;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class TopBar extends HBox {
    private final TextField searchInput = new TextField();
    private final List<CheckMenuItem> statesList = new ArrayList<>();
    private final List<CheckMenuItem> prioritiesList = new ArrayList<>();

    public TopBar() {
        super(10);

        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");
        HBox.setHgrow(searchInput, Priority.ALWAYS);

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

        for (PrioridadIncidencia prioritie : PrioridadIncidencia.values()) {
            CheckMenuItem item = new CheckMenuItem(prioritie.toString());
            prioritiesList.add(item);
            filterButton.getItems().add(item);
        }

        Button createButton = new Button("Crear incidencia");

        getChildren().addAll(new Label("Incidencia: "), searchInput, filterButton, createButton);
        setAlignment(Pos.CENTER_LEFT);
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
}
