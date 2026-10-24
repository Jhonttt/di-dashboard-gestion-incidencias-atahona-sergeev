package es.ies.incidencias.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Incidencia {

    private String name;
    private String state;
    private String priority;
    private LocalDateTime lastUpdated;
    private LocalDate creationDate;
    private final String options = "...";
    private String content = "";

    public Incidencia(
            String name,
            String state,
            String priority,
            LocalDateTime lastUpdated,
            LocalDate creationDate) {
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.lastUpdated = lastUpdated;
        this.creationDate = creationDate;
    }

    public Incidencia(String name, String state, String priority) {
        this.name = name;
        this.state = state;
        this.priority = priority;
        this.lastUpdated = LocalDateTime.now();
        this.creationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getPriority() {
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

    public void setState(String state) {
        this.state = state;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void updateLastUpdated() {
        this.lastUpdated = LocalDateTime.now();
    }

    public void setContent(String content) {
        this.content = content;
    }
}
