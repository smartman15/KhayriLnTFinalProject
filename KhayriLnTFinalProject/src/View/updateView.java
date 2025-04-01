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

public class updateView {
	Stage stage;
	private BorderPane root = new BorderPane();
	private GridPane gridPane = new GridPane();
	private TextField fieldHarga = new TextField();
	private TextField fieldStok = new TextField();
	
	public updateView(Stage stage) {
		this.stage = stage;
		show();
	}
	
	public void show() {
		root.setCenter(gridPane);
		gridPane.setAlignment(Pos.CENTER);
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
		root.setBottom(table);
		
		Label labelHarga = new Label("Harga:");
		Label labelStok = new Label("Stok:");
		Label msg = new Label("Please select a menu");
		Label notif = new Label();
		Button btnUpdate = new Button("Update data");
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Menu menu = table.getSelectionModel().getSelectedItem();
				String kode = menu.getKode();
				int harga = Integer.parseInt(fieldHarga.getText().trim());
				int stok = Integer.parseInt(fieldStok.getText().trim());
				
				userQuery.update(harga, stok, kode);
				notif.setText("horeee, menu berhasil diupdate :3");
				table.setItems(userQuery.getMenu());
				
			}
		});
		
		gridPane.add(labelHarga, 0, 0);
		gridPane.add(fieldHarga, 1, 0);
		gridPane.add(labelStok, 0, 1);
		gridPane.add(fieldStok, 1, 1);
		gridPane.add(btnUpdate, 0, 2);
		gridPane.add(notif, 1, 2);
		gridPane.add(msg, 0, 3);
		
		Scene scene = new Scene(root, 500, 400);
		stage.setScene(scene);
		stage.show();
	}
}
