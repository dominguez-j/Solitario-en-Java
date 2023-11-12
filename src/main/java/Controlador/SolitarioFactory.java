package Controlador;

import Klondike.Klondike;
import Solitario.Solitario;
import Spider.Spider;

public class SolitarioFactory {
	public static Solitario crearSolitario(String tipoSolitario){
		if("Klondike".equals(tipoSolitario))
			return new Klondike();
		else if("Spider".equals(tipoSolitario))
			return new Spider();

		return null;
	}
}
