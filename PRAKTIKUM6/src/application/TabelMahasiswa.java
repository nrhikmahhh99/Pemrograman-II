package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

class TabelMahasiswa {
	public TableView<Mahasiswa> createTable() {
        // Membuat tabel
        TableView<Mahasiswa> tableView = new TableView<>();

        // Membuat kolom NIM
        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));

        // Membuat kolom Nama
        TableColumn<Mahasiswa, String> namaColumn = new TableColumn<>("Nama");
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));

        // Menambahkan kolom ke tabel
        tableView.getColumns().addAll(nimColumn, namaColumn);

        // Menambahkan data ke ObservableList
        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa(1, "Nur Hikmah", "2310817120010"),
            new Mahasiswa(2, "Dina Izzati", "2310817120001"),
            new Mahasiswa(3, "Sheila Sabina", "2310817220028"),
            new Mahasiswa(4, "Raudatul Sholehah", "2310817220002"),
            new Mahasiswa(5, "Zahra Nabila", "2310817320007"),
            new Mahasiswa(6, "Aliya Raffa", "2310817120014"),
            new Mahasiswa(7, "Noviana Nur", "2310817120005"),
            new Mahasiswa(8, "Siti Ratna", "2310817120002"),
            new Mahasiswa(9, "Dessy Nurulita", "2310817220024"),
            new Mahasiswa(10, "Alya Rosaan", "2310817320015")
        );
        tableView.setItems(data);
        return tableView;
    }
}