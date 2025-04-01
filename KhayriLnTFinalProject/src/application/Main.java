package application;
	
import View.homeView;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		new homeView(primaryStage);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
