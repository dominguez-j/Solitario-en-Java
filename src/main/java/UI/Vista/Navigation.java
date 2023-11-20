package UI.Vista;

import UI.Controlador.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
	public static void irAlMenu(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
		stage.setScene(new Scene(loader.load(), 800, 600));
		UI_Setter.setStyle(stage);
	}
}
