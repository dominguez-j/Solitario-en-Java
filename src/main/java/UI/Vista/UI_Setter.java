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
			stage.getScene().getStylesheets().add(String.valueOf(UI_Setter.class.getResource("/Estilos/Button.css")));
			stage.getScene().getStylesheets().add(String.valueOf(UI_Setter.class.getResource("/Estilos/ComboBox.css")));
	}

	public static Scene setResolutionSolitario(Parent root, Solitario s){
		return new Scene(root, s.obtenerAncho(), s.obtenerAlto());
	}

	public static Scene setResolutionMenu(Parent root){
		return new Scene(root, 500, 400);
	}
}
