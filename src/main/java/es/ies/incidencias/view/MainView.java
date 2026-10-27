package es.ies.incidencias.view;

import es.ies.incidencias.model.Incidencia;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class MainView extends BorderPane {
    private final ObservableList<Incidencia> incidencias;
    private final IncidenciasTable table;
    private final TopBar topBar;
    private final PauseTransition debounce = new PauseTransition(Duration.millis(300));

    public MainView(ObservableList<Incidencia> incidencias) {
        this.incidencias = incidencias;

        topBar = new TopBar();

        table = new IncidenciasTable(FXCollections.observableArrayList(incidencias));
        table.setPlaceholder(new Label("No hay incidencias que coincidan"));

        debounce.setOnFinished(e -> searchIncidencias());

        topBar.getSearchInput()
                .textProperty()
                .addListener((observable, oldValue, newValue) -> debounce.playFromStart());

        topBar.getStatesList()
                .forEach(
                        item ->
                                item.selectedProperty()
                                        .addListener(
                                                (observable, oldValue, newValue) ->
                                                        searchIncidencias()));

        topBar.getPrioritiesList()
                .forEach(
                        item ->
                                item.selectedProperty()
                                        .addListener(
                                                (observable, oldValue, newValue) ->
                                                        searchIncidencias()));

        setTop(topBar);
        setCenter(table);
        setBottom(new Footer());

        BorderPane.setMargin(table, new Insets(14, 0, 14, 0));
        setPadding(new Insets(20));
    }

    private void searchIncidencias() {
        String text = topBar.getSearchInput().getText().trim().toLowerCase();
        List<String> states = selecteds(topBar.getStatesList());
        List<String> priorities = selecteds(topBar.getPrioritiesList());

        List<Incidencia> results = new ArrayList<>();

        for (Incidencia incidencia : incidencias) {
            String name = incidencia.getName();
            if (name == null || !name.toLowerCase().contains(text)) continue;
            if (!states.isEmpty() && !states.contains(incidencia.getState().toString())) continue;
            if (!priorities.isEmpty() && !priorities.contains(incidencia.getPriority().toString()))
                continue;

            results.add(incidencia);
        }

        table.getItems().setAll(results);
        table.sort();
    }

    private List<String> selecteds(List<CheckMenuItem> filter) {
        return filter.stream().filter(i -> i.isSelected()).map(i -> i.getText()).toList();
    }
}
