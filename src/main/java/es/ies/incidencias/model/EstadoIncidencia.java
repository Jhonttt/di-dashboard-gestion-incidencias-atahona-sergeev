package es.ies.incidencias.model;

public enum EstadoIncidencia {
    ABIERTA("Abierta"),
    EN_PROCESO("En proceso"),
    RESUELTA("Resuelta");

    private final String tag;

    EstadoIncidencia(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return tag;
    }
}
