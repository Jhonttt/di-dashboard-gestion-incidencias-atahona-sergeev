package es.ies.incidencias.view;

import es.ies.incidencias.model.Incidencia;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
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

        setTop(topBar);
        setCenter(table);
        setBottom(new Footer());

        BorderPane.setMargin(table, new Insets(14, 0, 14, 0));
        setPadding(new Insets(20));
    }

    private void searchIncidencias() {
        String text = topBar.getSearchInput().getText().trim().toLowerCase();

        List<Incidencia> resultados = new ArrayList<>();
        for (Incidencia incidencia : incidencias) {
            String name = incidencia.getName();
            if (name == null) continue;
            if (name.toLowerCase().contains(text)) {
                resultados.add(incidencia);
            }
        }

        table.getItems().setAll(resultados);
        table.sort();
    }
}
