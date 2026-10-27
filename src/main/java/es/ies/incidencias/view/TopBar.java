package es.ies.incidencias.view;

import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.PrioridadIncidencia;
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

    public TopBar() {
        super(10);

        searchInput.setPromptText("Ej.: Error al iniciar sesión en la aplicación");
        HBox.setHgrow(searchInput, Priority.ALWAYS);

        MenuButton filterButton = new MenuButton("Filtros");

        MenuItem estados = new MenuItem("Estados:");
        estados.setDisable(true);

        MenuItem prioridades = new MenuItem("Prioridades:");
        prioridades.setDisable(true);

        filterButton.getItems().add(estados);

        for (EstadoIncidencia estado : EstadoIncidencia.values()) {
            filterButton.getItems().add(new CheckMenuItem(estado.toString()));
        }

        filterButton.getItems().addAll(new SeparatorMenuItem(), prioridades);

        for (PrioridadIncidencia prioridad : PrioridadIncidencia.values()) {
            filterButton.getItems().add(new CheckMenuItem(prioridad.toString()));
        }

        Button createButton = new Button("Crear incidencia");

        getChildren().addAll(new Label("Incidencia: "), searchInput, filterButton, createButton);
        setAlignment(Pos.CENTER_LEFT);
    }

    public TextField getSearchInput() {
        return searchInput;
    }
}
