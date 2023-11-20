package UI.Vista;

import javafx.stage.Stage;

public class Navigation {
	public static void irAlMenu(Stage stage, MainMenuView mv) {
		stage.setScene(mv.getScene());
		UI_Setter.setStyle(stage);
	}
}
