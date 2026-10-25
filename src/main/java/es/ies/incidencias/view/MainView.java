package es.ies.incidencias.view;

import es.ies.incidencias.model.Incidencia;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
    public MainView(ObservableList<Incidencia> incidencias) {
        IncidenciasTable table = new IncidenciasTable(incidencias);

        setTop(new TopBar());
        setCenter(table);
        setBottom(new Footer());

        BorderPane.setMargin(table, new Insets(14, 0, 14, 0));
        setPadding(new Insets(20));
    }
}
