package Controller;


import View.insertView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class userController {
	public static void handleInsert(Stage stage) {
		new insertView(stage);
	}
	
}
