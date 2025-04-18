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
		TableView<Menu> table = userQuery.getTable();
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
				String textHarga = fieldHarga.getText();
				String textStok = fieldStok.getText();
				
				if(menu == null) {
					notif.setText("Tolong pilih menu terlebih dahulu");
				}
				else if(textHarga.isEmpty() || textStok.isEmpty()) {
					notif.setText("Tolong isi text field terlebih dahulu");
				}
				else {
					String kode = menu.getKode();
					int harga = Integer.parseInt(textHarga.trim());
					int stok = Integer.parseInt(textStok.trim());
					userQuery.update(harga, stok, kode);
					notif.setText("horeee, menu berhasil diupdate :3");
					
					
					table.setItems(userQuery.getMenu());
				}
				
				
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
