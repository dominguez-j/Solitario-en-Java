package UI.Controlador;

import Klondike.Klondike;
import Solitario.Solitario;
import Solitario.Solitario.TipoSolitario;
import Spider.Spider;

public class SolitarioFactory {
	public static Solitario crearSolitario(String tipoSolitario){

		TipoSolitario tipo = TipoSolitario.valueOf(tipoSolitario);

		return switch (tipo) {
			case Klondike -> new Klondike();
			case Spider -> new Spider();
		};
	}
}
