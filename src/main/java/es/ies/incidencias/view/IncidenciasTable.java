package es.ies.incidencias.view;

import es.ies.incidencias.model.EstadoIncidencia;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.model.PrioridadIncidencia;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IncidenciasTable extends TableView<Incidencia> {
    private Consumer<Incidencia> onDelete = i -> {};
    private Runnable onStateChange = () -> {};

    public IncidenciasTable(ObservableList<Incidencia> data) {
        this.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        this.setEditable(true);

        TableColumn<Incidencia, String> colName = new TableColumn<>("Nombre");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colName.setPrefWidth(150);

        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setOnEditCommit(
                event -> {
                    Incidencia incidencia = event.getRowValue();
                    incidencia.setName(event.getNewValue());
                });

        TableColumn<Incidencia, EstadoIncidencia> colState = new TableColumn<>("Estado");
        colState.setCellValueFactory(new PropertyValueFactory<>("state"));
        colState.setPrefWidth(100);

        colState.setCellFactory(ComboBoxTableCell.forTableColumn(EstadoIncidencia.values()));
        colState.setOnEditCommit(
                event -> {
                    Incidencia incidencia = event.getRowValue();
                    incidencia.setState(event.getNewValue());
                    onStateChange.run();
                });

        TableColumn<Incidencia, PrioridadIncidencia> colPriority = new TableColumn<>("Prioridad");
        colPriority.setCellValueFactory(new PropertyValueFactory<>("priority"));
        colPriority.setPrefWidth(100);

        colPriority.setCellFactory(ComboBoxTableCell.forTableColumn(PrioridadIncidencia.values()));
        colPriority.setOnEditCommit(
                event -> {
                    Incidencia incidencia = event.getRowValue();
                    incidencia.setPriority(event.getNewValue());
                });

        TableColumn<Incidencia, String> colLastUpdated = new TableColumn<>("Última actualización");
        colLastUpdated.setCellValueFactory(
                cellData -> {
                    LocalDateTime fecha = cellData.getValue().getLastUpdated();
                    if (fecha != null) {
                        java.time.format.DateTimeFormatter formatter =
                                java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        return new javafx.beans.property.SimpleStringProperty(
                                fecha.format(formatter));
                    }
                    return new javafx.beans.property.SimpleStringProperty("");
                });
        colLastUpdated.setPrefWidth(150);

        TableColumn<Incidencia, String> colCreationDate = new TableColumn<>("Fecha de creación");
        colCreationDate.setCellValueFactory(new PropertyValueFactory<>("creationDate"));
        colCreationDate.setPrefWidth(120);

        TableColumn<Incidencia, String> colOptions = new TableColumn<>("Opciones");
        colOptions.setCellValueFactory(new PropertyValueFactory<>("options"));
        colOptions.setPrefWidth(120);

        colOptions.setCellFactory(
                javafx.scene.control.cell.ComboBoxTableCell.forTableColumn(
                        FXCollections.observableArrayList("Abrir", "Eliminar")));
        colOptions.setOnEditCommit(
                event -> {
                    Incidencia incidencia = event.getRowValue();
                    if (incidencia == null) {
                        return;
                    }
                    if ("Eliminar".equals(event.getNewValue())) {
                        Stage ventanaEmergente = new Stage();
                        ventanaEmergente.setTitle("Confirmar eliminación");
                        Label lblConfirmacion = new Label("¿Confirmar eliminación?");
                        ventanaEmergente.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                        ventanaEmergente.initOwner(getScene().getWindow());

                        HBox layoutEmergente = new HBox(15);
                        layoutEmergente.setPadding(new Insets(20));
                        layoutEmergente.setAlignment(Pos.CENTER);

                        Button btnCancelar = new Button("Cancelar");
                        btnCancelar.setOnAction(
                                e -> {
                                    ventanaEmergente.close();
                                });

                        Button btnConfirmar = new Button("Confirmar");
                        btnConfirmar.setOnAction(
                                e -> {
                                    onDelete.accept(incidencia);
                                    ventanaEmergente.close();
                                });

                        VBox vbox = new VBox(10);
                        vbox.setAlignment(Pos.CENTER);
                        vbox.getChildren().addAll(lblConfirmacion, layoutEmergente);

                        layoutEmergente.getChildren().addAll(btnCancelar, btnConfirmar);
                        ventanaEmergente.setScene(new Scene(vbox, 350, 200));
                        ventanaEmergente.show();

                    } else if ("Abrir".equals(event.getNewValue())) {
                        Stage ventanaEmergente = new Stage();
                        ventanaEmergente.setTitle("Detalles de la Incidencia");
                        ventanaEmergente.initModality(javafx.stage.Modality.APPLICATION_MODAL);
                        ventanaEmergente.initOwner(getScene().getWindow());

                        VBox layoutEmergente = new VBox(15);
                        layoutEmergente.setPadding(new Insets(20));
                        layoutEmergente.setAlignment(Pos.CENTER);

                        Label lblTitulo = new Label("Visualizando: " + incidencia.getName());
                        Label lblDetalle =
                                new Label(
                                        "Estado actual: "
                                                + incidencia.getState()
                                                + "\nPrioridad: "
                                                + incidencia.getPriority());

                        TextArea txtDescripcion = new TextArea();
                        txtDescripcion.setWrapText(true);
                        txtDescripcion.setPrefHeight(120);
                        txtDescripcion.setText(incidencia.getContent());

                        Button btnCerrar = new Button("Cerrar");
                        btnCerrar.setOnAction(
                                e -> {
                                    ventanaEmergente.close();
                                    incidencia.setContent(txtDescripcion.getText());
                                    incidencia.updateLastUpdated();
                                    refreshTableItems();
                                });
                        layoutEmergente
                                .getChildren()
                                .addAll(lblTitulo, lblDetalle, txtDescripcion, btnCerrar);

                        ventanaEmergente.setScene(new Scene(layoutEmergente, 350, 200));
                        ventanaEmergente.show();
                    }
                });

        getColumns()
                .addAll(
                        colName,
                        colState,
                        colPriority,
                        colLastUpdated,
                        colCreationDate,
                        colOptions);
        setItems(data);
    }

    public void setOnDelete(Consumer<Incidencia> handler) {
        this.onDelete = handler;
    }

    public void setOnStateChange(Runnable handler) {
        this.onStateChange = handler;
    }

    private void refreshTableItems() {
        this.refresh();
    }
}
