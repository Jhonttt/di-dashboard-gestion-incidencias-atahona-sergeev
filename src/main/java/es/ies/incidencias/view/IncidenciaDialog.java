package es.ies.incidencias.view;

import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.model.PrioridadIncidencia;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Window;

public class IncidenciaDialog extends Dialog<Incidencia> {

    public IncidenciaDialog(Window owner) {
        initOwner(owner);
        setTitle("Crear incidencia");

        TextField name = new TextField();
        Platform.runLater(() -> name.requestFocus());
        name.setPromptText("Error en la base de datos");

        ComboBox<PrioridadIncidencia> priority =
                new ComboBox<>(FXCollections.observableArrayList(PrioridadIncidencia.values()));
        priority.getSelectionModel().selectFirst();

        ComboBox<EstadoIncidencia> state =
                new ComboBox<>(FXCollections.observableArrayList(EstadoIncidencia.values()));
        state.getSelectionModel().selectFirst();

        VBox box =
                new VBox(
                        10,
                        new Label("Nombre:"),
                        name,
                        new Label("Prioridad:"),
                        priority,
                        new Label("Estado:"),
                        state);
        box.setPadding(new Insets(10));
        getDialogPane().setContent(box);

        ButtonType createButton = new ButtonType("Crear", ButtonBar.ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);
        getDialogPane().setPrefSize(300, 360);

        getDialogPane()
                .lookupButton(createButton)
                .disableProperty()
                .bind(name.textProperty().isEmpty());

        setResultConverter(
                btn -> {
                    if (btn != createButton) return null;
                    return new Incidencia(name.getText(), state.getValue(), priority.getValue());
                });
    }
}
