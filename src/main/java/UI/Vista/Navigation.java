package UI.Vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
	public static void irAlMenu(Stage stage) throws IOException {
		FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
		stage.setScene(new Scene(loader.load(), 800, 600));
		stage.getScene().getStylesheets().add(Navigation.class.getResource("/Estilos/Button.css").toExternalForm());
		stage.getScene().getStylesheets().add(Navigation.class.getResource("/Estilos/ComboBox.css").toExternalForm());
	}
}
