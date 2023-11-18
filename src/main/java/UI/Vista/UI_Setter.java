package UI.Vista;

import Solitario.Solitario;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class UI_Setter {
	public static void setIcon(Stage stage){
		stage.getIcons().add(new Image("/Logo/logo.png"));
	}

	public static void setStyle(Stage stage){
		stage.getScene().getStylesheets().add(UI_Setter.class.getResource("/Estilos/Button.css").toExternalForm());
		stage.getScene().getStylesheets().add(UI_Setter.class.getResource("/Estilos/ComboBox.css").toExternalForm());
	}

	public static Scene setResolution(Parent root, Solitario s){
		return new Scene(root, s.obtenerAncho(), s.obtenerAlto());
	}
}
