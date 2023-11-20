package UI.Vista;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Navigation {
	public static void irAlMenu(Stage stage, Scene sceneMenu) {
		stage.setScene(sceneMenu);
		UI_Setter.setStyle(stage);
	}
}
