package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class TampilanDataController {
	@FXML
    private TextField namaPelangganField;
    @FXML
    private TextField emailPelangganField;
    @FXML
    private TextField teleponPelangganField;
    @FXML
    private TableView<Pelanggan> tabelPelanggan;
    @FXML
    private TableColumn<Pelanggan, String> kolomNamaPelanggan;
    @FXML
    private TableColumn<Pelanggan, String> kolomEmailPelanggan;
    @FXML
    private TableColumn<Pelanggan, String> kolomTeleponPelanggan;
    @FXML
    private Button buttonAddPelanggan, buttonEditPelanggan, buttonDeletePelanggan;
    private ObservableList<Pelanggan> pelangganList;

    @FXML
    private TextField judulBukuField;
    @FXML
    private TextField penulisBukuField;
    @FXML
    private TextField hargaBukuField;
    @FXML
    private TextField stokBukuField;
    @FXML
    private TableView<Buku> tabelBuku;
    @FXML
    private TableColumn<Buku, String> kolomJudulBuku;
    @FXML
    private TableColumn<Buku, String> kolomPenulisBuku;
    @FXML
    private TableColumn<Buku, Double> kolomHargaBuku;
    @FXML
    private TableColumn<Buku, Integer> kolomStokBuku;
    @FXML
    private Button buttonAddBuku, buttonEditBuku, buttonDeleteBuku;
    private ObservableList<Buku> bukuList;

    @FXML
    private TextField jumlahPenjualanField;
    @FXML
    private TextField totalHargaPenjualanField;
    @FXML
    private TextField tanggalPenjualanField;
    @FXML
    private TableView<Penjualan> tabelPenjualan;
    @FXML
    private TableColumn<Penjualan, Integer> kolomJumlahPenjualan;
    @FXML
    private TableColumn<Penjualan, Double> kolomHargaPenjualan;
    @FXML
    private TableColumn<Penjualan, String> kolomTanggalPenjualan;
    @FXML
    private Button buttonAddPenjualan, buttonEditPenjualan, buttonDeletePenjualan;
    private ObservableList<Penjualan> penjualanList;
        
    public void initialize() {
        initializePelanggan();
        initializeBuku();
        initializePenjualan();
    }

    private void initializePelanggan() {
    	kolomNamaPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
    	kolomEmailPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
    	kolomTeleponPelanggan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelepon()));
        loadDataPelanggan();
    }

    private void initializeBuku() {
    	kolomJudulBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudul()));
    	kolomPenulisBuku.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPenulis()));
    	kolomHargaBuku.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getHarga()).asObject());
    	kolomStokBuku.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStok()).asObject());
        loadDataBuku();
    }

    private void initializePenjualan() {
    	kolomJumlahPenjualan.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getJumlah()).asObject());
    	kolomHargaPenjualan.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalHarga()).asObject());
    	kolomTanggalPenjualan.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTanggal()));
        loadDataPenjualan();
    }

    private void loadDataPelanggan() {
        pelangganList = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnect.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM data_pelanggan")) {
            while (rs.next()) {
                pelangganList.add(new Pelanggan(rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelPelanggan.setItems(pelangganList);
    }

    private void loadDataBuku() {
        bukuList = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnect.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM data_buku")) {
            while (rs.next()) {
                bukuList.add(new Buku(rs.getString("judul"), rs.getString("penulis"), rs.getDouble("harga"), rs.getInt("stok")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelBuku.setItems(bukuList);
    }

    private void loadDataPenjualan() {
        penjualanList = FXCollections.observableArrayList();
        try (Connection conn = DatabaseConnect.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM data_penjualan")) {
            while (rs.next()) {
                penjualanList.add(new Penjualan(rs.getInt("jumlah"), rs.getDouble("total_harga"), rs.getString("tanggal")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelPenjualan.setItems(penjualanList);
    }

    @FXML
    private void handleAddPelanggan() {
        try {
            String nama = namaPelangganField.getText();
            String email = emailPelangganField.getText();
            String telepon = teleponPelangganField.getText();

            DatabaseConnect.addPelanggan(nama, email, telepon);
            pelangganList.add(new Pelanggan(nama, email, telepon)); 

            clearFields();
            showAlert("Berhasil", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan data: " + e.getMessage());
        }
    }

    @FXML
    private void handleEditPelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Silakan pilih pelanggan untuk diedit.");
                return;
            }

            String name = selectedPelanggan.getNama();
            String nama = namaPelangganField.getText();
            String email = emailPelangganField.getText();
            String telepon = teleponPelangganField.getText();

            if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
                showAlert("Warning", "Semua kolom harus diisi.");
                return;
            }

            DatabaseConnect.updatePelanggan(nama, email, telepon);

            selectedPelanggan.setNama(nama);
            selectedPelanggan.setEmail(email);
            selectedPelanggan.setTelepon(telepon);

            tabelPelanggan.refresh();
            clearFields();
            showAlert("Berhasil", "Data berhasil diperbarui!");
        } catch (Exception e) {
            showAlert("Error", "Gagal memperbarui data: " + e.getMessage());
        }
    }

    @FXML
    private void handleDeletePelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Silakan pilih pelanggan yang akan dihapus.");
                return;
            }

            DatabaseConnect.deletePelanggan(String.valueOf(selectedPelanggan.getNama()));

            pelangganList.remove(selectedPelanggan);

            clearFields();
            showAlert("Berhasil", "Data berhasil dihapus!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menghapus data: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleAddBuku() {
        try {
            String judul = judulBukuField.getText();
            String penulis = penulisBukuField.getText();
            int harga = Integer.parseInt(hargaBukuField.getText());
            int stok = Integer.parseInt(stokBukuField.getText());

            DatabaseConnect.addBuku(judul, penulis, harga, stok);

            bukuList.add(new Buku(judul, penulis, harga, stok)); 

            clearFields();
            showAlert("Berhasil", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan data: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleEditBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Silakan pilih buku yang akan diedit.");
                return;
            }

            String judul = judulBukuField.getText();
            String penulis = penulisBukuField.getText();
            int harga = Integer.parseInt(hargaBukuField.getText());
            int stok = Integer.parseInt(stokBukuField.getText());

            if (judul.isEmpty() || penulis.isEmpty()) {
                showAlert("Warning", "Semua kolom harus diisi.");
                return;
            }

            DatabaseConnect.updateBuku(judul, penulis, harga, stok);

            selectedBuku.setJudul(judul);
            selectedBuku.setPenulis(penulis);
            selectedBuku.setHarga(harga);
            selectedBuku.setStok(stok);

            tabelBuku.refresh();
            clearFields();
            showAlert("Berhasil", "Data buku berhasil diperbarui!");
        } catch (Exception e) {
            showAlert("Error", "Gagal memperbarui data buku: " + e.getMessage());
        }
    }

    @FXML
    private void handleDeleteBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Silakan pilih buku yang akan dihapus.");
                return;
            }

            DatabaseConnect.deleteBuku(String.valueOf(selectedBuku.getJudul()));

            bukuList.remove(selectedBuku);

            clearFields();
            showAlert("Berhasil", "Data buku berhasil dihapus!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menghapus data buku: " + e.getMessage());
        }
    }

    
    @FXML
    private void handleAddPenjualan() {
        try {
            int jumlah = Integer.parseInt(jumlahPenjualanField.getText());
            double totalHarga = Double.parseDouble(totalHargaPenjualanField.getText());
            String tanggal = tanggalPenjualanField.getText();

            DatabaseConnect.addPenjualan(jumlah, totalHarga, tanggal);

            penjualanList.add(new Penjualan(jumlah, totalHarga, tanggal));

            clearFields();
            showAlert("Berhasil", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            showAlert("Error", "Gagal menambahkan data: " + e.getMessage());
        }
    }
    
    @FXML
    private void handleEditPenjualan() {
        try {
            Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
            if (selectedPenjualan == null) {
                showAlert("Warning", "Silakan pilih penjualan yang akan diedit.");
                return;
            }

            int penjualan = selectedPenjualan.getJumlah();
            int jumlah = Integer.parseInt(jumlahPenjualanField.getText());
            int totalHarga = Integer.parseInt(totalHargaPenjualanField.getText());
            String tanggal = tanggalPenjualanField.getText();

            if (jumlah <= 0 || totalHarga <= 0 || tanggal.isEmpty()) {
                showAlert("Warning", "Semua kolom harus diisi dan valid.");
                return;
            }

            DatabaseConnect.updatePenjualan(jumlah, totalHarga, String.valueOf(tanggal));

            selectedPenjualan.setJumlah(jumlah);
            selectedPenjualan.setTotalHarga(totalHarga);
            selectedPenjualan.setTanggal(tanggal);

            tabelPenjualan.refresh();
            clearFields();
            showAlert("Berhasil", "Data penjualan berhasil diperbarui!");
        } catch (Exception e) {
            showAlert("Error", "Gagal memperbarui data penjualan: " + e.getMessage());
        }
    }

    @FXML
    private void handleDeletePenjualan() {
        try {
            Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
            if (selectedPenjualan == null) {
                showAlert("Warning", "Silakan pilih penjualan yang akan dihapus.");
                return;
            }

            int jumlah = 0;
			DatabaseConnect.deletePenjualan(jumlah);

            penjualanList.remove(selectedPenjualan);

            clearFields();
            showAlert("Berhasil", "Data penjualan berhasil dihapus!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete sale data: " + e.getMessage());
        }
    }

    
    private void clearFields() {
        namaPelangganField.clear();
        emailPelangganField.clear();
        teleponPelangganField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
}
