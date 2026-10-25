package es.ies.incidencias.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Incidencia {

    private String name;
    private EstadoIncidencia state;
    private PrioridadIncidencia priority;
    private LocalDateTime lastUpdated;
    private final LocalDate creationDate;
    private final String options = "...";
    private String content = "";

    public Incidencia(
            String name,
            EstadoIncidencia state,
            PrioridadIncidencia priority,
            LocalDateTime lastUpdated,
            LocalDate creationDate) {
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.lastUpdated = lastUpdated;
        this.creationDate = creationDate;
    }

    public Incidencia(String name, EstadoIncidencia state, PrioridadIncidencia priority) {
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.lastUpdated = LocalDateTime.now();
        this.creationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public EstadoIncidencia getState() {
        return state;
    }

    public PrioridadIncidencia getPriority() {
        return priority;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getOptions() {
        return options;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(EstadoIncidencia state) {
        this.state = state;
    }

    public void setPriority(PrioridadIncidencia priority) {
        this.priority = priority;
    }

    public void updateLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }

    public void setContent(String content) {
        this.content = content;
    }
}
