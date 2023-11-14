package UI.Controlador;

import Klondike.Klondike;
import Solitario.Solitario;
import Solitario.Solitario.TipoSolitario;
import Spider.Spider;

public class SolitarioFactory {
	public static Solitario crearSolitario(String tipoSolitario){

		TipoSolitario tipo = TipoSolitario.valueOf(tipoSolitario);

		switch (tipo) {
			case Klondike:
				return new Klondike();
			case Spider:
				return new Spider();
			default:
				return null;
		}
	}
}
