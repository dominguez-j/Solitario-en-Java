package UI.Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
	public static void irAlMenu(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root, 800, 600);
		stage.setScene(scene);
	}
}
