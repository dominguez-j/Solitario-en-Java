package Controlador;

import Klondike.Klondike;
import Solitario.Solitario;
import Spider.Spider;

public class SolitarioFactory {
	public static Solitario crearSolitario(String selectedGame){
		if("Klondike".equals(selectedGame))
			return new Klondike();
		else if("Spider".equals(selectedGame))
			return new Spider();

		return null;
	}
}
