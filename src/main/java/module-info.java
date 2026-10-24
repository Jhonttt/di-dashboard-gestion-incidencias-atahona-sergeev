module es.ies.incidencias {
    requires javafx.controls;
    requires javafx.fxml;

    opens es.ies.incidencias to
            javafx.fxml;

    exports es.ies.incidencias;
}

# Automated fix for issue #22: Cambiar el layout raíz a BorderPane
