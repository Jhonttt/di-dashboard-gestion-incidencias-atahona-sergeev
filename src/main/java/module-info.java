module es.ies.incidencias {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens es.ies.incidencias to
            javafx.fxml;
    opens es.ies.incidencias.model to
            javafx.base;

    exports es.ies.incidencias;
}
