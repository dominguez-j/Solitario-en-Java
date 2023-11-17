package UI.Vista;

import Solitario.Solitario.TipoSolitario;

public class GameViewFactory {
	public static GameView crearGameView(String tipoSolitario) {
		TipoSolitario tipo = TipoSolitario.valueOf(tipoSolitario);

		return switch (tipo) {
			case Klondike -> new KlondikeView();
			case Spider -> new SpiderView();
		};
	}
}
