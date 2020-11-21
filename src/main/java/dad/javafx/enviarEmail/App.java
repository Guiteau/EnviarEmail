package dad.javafx.enviarEmail;

import dad.javafx.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	
	Controller controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		controller = new Controller();
		
		controller.getButton_cerrar().setOnAction((event) -> {
			  primaryStage.close();
		});
		
		Scene escena = new Scene(controller.getView(), 620, 500);
		
		primaryStage.getIcons().add(new Image("email-send-icon-32x32.png"));
		primaryStage.setScene(escena);
		primaryStage.setTitle("Enviar email\t");
		primaryStage.show();
		
		
	}

	public static void main(String[] args) {

		launch(args);
		
	}

}
