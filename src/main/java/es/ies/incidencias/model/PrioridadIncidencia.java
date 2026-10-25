package es.ies.incidencias.model;

public enum PrioridadIncidencia {
    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta"),
    CRITICA("Critica");

    private final String tag;

    private PrioridadIncidencia(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return tag;
    }
}
