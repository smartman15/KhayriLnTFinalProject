package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class userQuery {
	static DatabaseConnection db = new DatabaseConnection();
	
	public static void insert(String kode, String nama, int harga, int stok) {
		String query = "INSERT INTO menudb (kodeMenu, namaMenu, hargaMenu, stokMenu) VALUES (?, ?, ?, ?)";
		
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
	
	
	
	public static ObservableList<Menu> getMenu(){
		ObservableList<Menu> menu = FXCollections.observableArrayList();
		String query = "SELECT * FROM menudb";
		
		try {
			PreparedStatement ps = db.ps(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				menu.add(new Menu(rs.getString("kodeMenu"), rs.getString("namaMenu"), rs.getInt("hargaMenu"), rs.getInt("stokMeu")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
}
