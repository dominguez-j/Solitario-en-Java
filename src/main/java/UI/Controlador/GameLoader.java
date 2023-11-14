package UI.Controlador;

import Solitario.Solitario;
import javafx.fxml.FXMLLoader;

public class GameLoader {

	public static FXMLLoader crearLoader(Solitario s){
		return new FXMLLoader(GameLoader.class.getResource("/UI/View" + s.getClass().getSimpleName() +".fxml"));
	}
}
