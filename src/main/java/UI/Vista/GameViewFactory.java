package UI.Vista;

import Solitario.Solitario.TipoSolitario;
import UI.Vista.GameView;
import UI.Vista.KlondikeView;
import UI.Vista.SpiderView;

public class GameViewFactory {
	public static GameView crearGameView(String tipoSolitario) {
		TipoSolitario tipo = TipoSolitario.valueOf(tipoSolitario);

		switch (tipo) {
			case Klondike:
				return new KlondikeView();
			case Spider:
				return new SpiderView();
			default:
				return null;
		}
	}
}
