package Controller;


import View.insertView;
import View.updateView;
import javafx.stage.Stage;

public class userController {
	public static void handleInsert(Stage stage) {
		new insertView(stage);
	}
	
	public static void handleUpdate(Stage stage) {
		new updateView(stage);
	}
}
