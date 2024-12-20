package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Membuat instance TabelMahasiswa
        TabelMahasiswa tabelMahasiswa = new TabelMahasiswa();

        // Menambahkan tabel ke layout
        VBox vbox = new VBox(tabelMahasiswa.createTable());
        Scene scene = new Scene(vbox, 400, 300);

        // Mengatur properti Stage
        primaryStage.setTitle("Data Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
