package View;

import Controller.userController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class homeView {
	Stage stage;
	
	public homeView(Stage stage) {
		this.stage = stage;
		show();
	}
	
	public void show() {
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		Label msg = new Label("What would you like to do?");
		Button btnInsert = new Button("Insert menu");
		Button btnUpdate = new Button("Update menu");
		Button btnDelete = new Button("Delete menu");
		btnInsert.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				userController.handleInsert(stage);
			}
		});
		
		btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				userController.handleUpdate(stage);
			}
		});
		
		btnDelete.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				userController.handleDelete(stage);
			}
		});
		
		root.add(msg, 0, 0);
		root.add(btnInsert, 0, 1);
		root.add(btnUpdate, 1, 1);
		root.add(btnDelete, 2, 1);
		
		Scene scene = new Scene(root, 500, 400);
		
		stage.setScene(scene);
		stage.show();
	}
}
