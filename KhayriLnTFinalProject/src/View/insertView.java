package View;

import Model.Menu;
import Model.userQuery;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class insertView {
	Stage stage;
	private BorderPane root = new BorderPane();
	private GridPane gridPane = new GridPane();
	private TextField fieldKode = new TextField();
	private TextField fieldNama = new TextField();
	private TextField fieldHarga = new TextField();
	private TextField fieldStok = new TextField();
	
	public insertView(Stage stage) {
		this.stage = stage;
		show();
	}
	
	public void show() {
		root.setCenter(gridPane);
		gridPane.setAlignment(Pos.CENTER);
		TableView<Menu> table = new TableView<>();
		TableColumn<Menu, String> kodeCol = new TableColumn<>("kodeMenu");
		kodeCol.setCellValueFactory(new PropertyValueFactory<>("kodeMenu"));
		
		TableColumn<Menu, String> namaCol = new TableColumn<>("namaMenu");
		namaCol.setCellValueFactory(new PropertyValueFactory<>("namaMenu"));
		
		TableColumn<Menu, Integer> hargaCol = new TableColumn<>("hargaMenu");
		hargaCol.setCellValueFactory(new PropertyValueFactory<>("hargaMenu"));
		
		TableColumn<Menu, String> stokCol = new TableColumn<>("stokMenu");
		stokCol.setCellValueFactory(new PropertyValueFactory<>("stokMenu"));
		
		table.getColumns().addAll(kodeCol, namaCol, hargaCol, stokCol);
		table.setItems(userQuery.getMenu());
		root.setBottom(table);
		
		Label kode = new Label("Kode: ");
		Label nama = new Label("Nama: ");
		Label harga = new Label("Harga: ");
		Label stok = new Label("Stok: ");
		
		Button btnInsert = new Button("Insert menu");
		btnInsert.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				String kode = fieldKode.getText().trim();
				String nama = fieldNama.getText().trim();
				int harga = Integer.parseInt(fieldHarga.getText().trim());
				int stok = Integer.parseInt(fieldStok.getText().trim());
				
				userQuery.insert(kode, nama, harga, stok);
				table.setItems(userQuery.getMenu());
			}
		});
		
		gridPane.add(kode, 0, 0);
		gridPane.add(fieldKode, 1, 0);
		gridPane.add(nama, 0, 1);
		gridPane.add(fieldNama, 1, 1);
		gridPane.add(harga, 0, 2);
		gridPane.add(fieldHarga, 1, 2);
		gridPane.add(stok, 0, 3);
		gridPane.add(fieldStok, 1, 3);
		gridPane.add(btnInsert, 0, 4);
		
		Scene scene = new Scene(root, 500, 400);
		
		stage.setScene(scene);
		stage.show();
	}
}
