package es.ies.incidencias;

import es.ies.incidencias.data.SampleData;
import es.ies.incidencias.model.Incidencia;
import es.ies.incidencias.view.MainView;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<Incidencia> incidencias = SampleData.incidencias();

        Scene scene = new Scene(new MainView(incidencias), 820, 500);
        stage.setTitle("Gestor de incidencias");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
