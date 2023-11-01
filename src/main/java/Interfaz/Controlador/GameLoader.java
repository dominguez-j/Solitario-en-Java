package Interfaz.Controlador;

import Klondike.Klondike;
import Spider.Spider;
import Solitario.Solitario;
import javafx.fxml.FXMLLoader;

public class GameLoader {

	public static FXMLLoader crearLoader(Solitario s){

		if(s instanceof Klondike)
			return new FXMLLoader(GameLoader.class.getResource("/Vista/ViewKlondike.fxml"));
		else if (s instanceof Spider)
			return new FXMLLoader(GameLoader.class.getResource("/Vista/ViewSpider.fxml"));

		return null;
	}
}
