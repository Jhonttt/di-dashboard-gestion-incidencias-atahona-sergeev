package es.ies.incidencias.data;

import es.ies.incidencias.model.Incidencia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class SampleData {
    private SampleData() {}

    public static ObservableList<Incidencia> incidencias() {
        return FXCollections.observableArrayList(
                new Incidencia(
                        "Error en pasarela de pago",
                        "Abierta",
                        "Crítica",
                        LocalDateTime.parse(
                                "2025-09-23T09:30:00",
                                DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                        LocalDate.parse("2025-09-01")),
                new Incidencia(
                        "Fallo de renderizado en UI",
                        "En proceso",
                        "Media",
                        LocalDateTime.parse(
                                "2025-12-20T10:30:00",
                                DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                        LocalDate.parse("2025-12-03")),
                new Incidencia(
                        "Actualizar dependencias Maven",
                        "Resueltas",
                        "Baja",
                        LocalDateTime.parse(
                                "2026-01-18T11:00:00",
                                DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                        LocalDate.parse("2026-01-05")),
                new Incidencia(
                        "Fuga de memoria en controlador",
                        "Abierta",
                        "Alta",
                        LocalDateTime.parse(
                                "2026-03-15T12:00:00",
                                DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                        LocalDate.parse("2026-03-07")),
                new Incidencia(
                        "Error 404 en imágenes de perfil",
                        "En proceso",
                        "Baja",
                        LocalDateTime.parse(
                                "2026-05-12T13:00:00",
                                DateTimeFormatter.ofPattern("yyyy-M-d'T'H:mm:ss")),
                        LocalDate.parse("2026-05-09")));
    }
}
