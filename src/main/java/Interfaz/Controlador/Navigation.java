package Interfaz.Controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
	public static void irAlMenu(Stage currentStage) throws IOException {
			FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/Vista/ViewMenuInicio.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 800, 600);
			currentStage.setScene(scene);
	}
}
