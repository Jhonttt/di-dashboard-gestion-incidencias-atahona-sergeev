package es.ies.incidencias.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Footer extends HBox {
    public Footer() {
        super(20);

        getChildren()
                .addAll(
                        new Label("Total de incidencias: 33"),
                        new Label("Abiertas: 33"),
                        new Label("En proceso: 33"),
                        new Label("Resueltas: 33"));

        setAlignment(Pos.CENTER_LEFT);
    }
}
