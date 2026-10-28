package es.ies.incidencias.view;

import atlantafx.base.theme.Styles;
import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.Incidencia;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Footer extends HBox {
    private final Label total = new Label();
    private final Label abiertas = new Label();
    private final Label enProceso = new Label();
    private final Label resueltas = new Label();

    public Footer() {
        super(20);

        for (Label l : List.of(total, abiertas, enProceso, resueltas)) {
            l.getStyleClass().add(Styles.TEXT_CAPTION);
        }

        getChildren().addAll(total, abiertas, enProceso, resueltas);
        setAlignment(Pos.CENTER_LEFT);
        update(List.of());
    }

    public void update(List<Incidencia> incidencias) {
        total.setText("Total de incidencias: " + incidencias.size());
        abiertas.setText("Abiertas: " + count(incidencias, EstadoIncidencia.ABIERTA));
        enProceso.setText("En proceso: " + count(incidencias, EstadoIncidencia.EN_PROCESO));
        resueltas.setText("Resueltas: " + count(incidencias, EstadoIncidencia.RESUELTA));
    }

    private static long count(List<Incidencia> incidencias, EstadoIncidencia state) {
        return incidencias.stream().filter(i -> i.getState() == state).count();
    }
}
