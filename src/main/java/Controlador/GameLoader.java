package Controlador;

import Solitario.Solitario;
import javafx.fxml.FXMLLoader;

public class GameLoader {

	public static FXMLLoader crearLoader(Solitario s){
		return new FXMLLoader(GameLoader.class.getResource("/Vista/View"+ s.getClass().getSimpleName() +".fxml"));
	}
}
