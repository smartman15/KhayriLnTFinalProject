package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class userQuery {
	static DatabaseConnection db = new DatabaseConnection();
	
	public static void insert(String kode, String nama, int harga, int stok) {
		String query = "INSERT INTO menudb (kode, nama, harga, stok) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = db.ps(query);
			ps.setString(1, kode);
			ps.setString(2, nama);
			ps.setInt(3, harga);
			ps.setInt(4, stok);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void update(int harga, int stok, String kode) {
		String query = "UPDATE menudb "
				+ "SET harga = ?, stok = ? "
				+ "WHERE kode = ?";
		
		try {
			PreparedStatement ps = db.ps(query);
			ps.setInt(1, harga);
			ps.setInt(2, stok);
			ps.setString(3, kode);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void delete(String kode) {
		String query = "DELETE FROM menudb WHERE kode = ?";
		
		try {
			PreparedStatement ps = db.ps(query);
			ps.setString(1, kode);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static ObservableList<Menu> getMenu(){
		ObservableList<Menu> menu = FXCollections.observableArrayList();
		String query = "SELECT * FROM menudb";
		
		try {
			PreparedStatement ps = db.ps(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				menu.add(new Menu(rs.getString("kode"), rs.getString("nama"), rs.getInt("harga"), rs.getInt("stok")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	
	public static TableView<Menu> getTable(){
		TableView<Menu> table = new TableView<>();
		TableColumn<Menu, String> kodeCol = new TableColumn<>("kode");
		kodeCol.setCellValueFactory(new PropertyValueFactory<>("kode"));
		
		TableColumn<Menu, String> namaCol = new TableColumn<>("nama");
		namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
		
		TableColumn<Menu, Integer> hargaCol = new TableColumn<>("harga");
		hargaCol.setCellValueFactory(new PropertyValueFactory<>("harga"));
		
		TableColumn<Menu, String> stokCol = new TableColumn<>("stok");
		stokCol.setCellValueFactory(new PropertyValueFactory<>("stok"));
		
		table.getColumns().addAll(kodeCol, namaCol, hargaCol, stokCol);
		table.setItems(userQuery.getMenu());
		return table;
	}

}
