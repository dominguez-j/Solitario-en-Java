package UI.Vista;

import Solitario.Solitario.TipoSolitario;

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
