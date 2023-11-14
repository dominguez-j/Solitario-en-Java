package UI.Vista;

import javafx.scene.image.Image;
import javafx.stage.Stage;

public class IconSetter {
	public static void setIcon(Stage stage){
		stage.getIcons().add(new Image("/Logo/logo.png"));
	}
}
