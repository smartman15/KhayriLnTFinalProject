package View;

import Controller.userController;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class deleteView {
	Stage stage;
	BorderPane root = new BorderPane();
	GridPane gridPane = new GridPane();
	
	public deleteView(Stage stage) {
		this.stage = stage;
		show();
	}
	
	public void show() {
		Button back = new Button("Balik ke home");
		back.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				userController.handleHome(stage);
			}
		});
		root.setTop(back);
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
		
		Button btnDelete = new Button("Delete menu");
		Label label = new Label("Pilih menu untuk dihapuskan");
		Label notif = new Label();
		
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				Menu menu = table.getSelectionModel().getSelectedItem();
				if(menu == null) {
					notif.setText("Tolong pilih menu terlebih dahulu");
				}
				else {
					String kode = menu.getKode();
					userQuery.delete(kode);
					notif.setText("Menu berhasil dihapuskan :))");
					
					table.setItems(userQuery.getMenu());
				}
				
			}
		});
		
		gridPane.add(label, 0, 0);
		gridPane.add(btnDelete, 0, 1);
		gridPane.add(notif, 0, 2);
		
		Scene scene = new Scene(root, 500, 400);
		stage.setScene(scene);
		stage.show();
	}
}
