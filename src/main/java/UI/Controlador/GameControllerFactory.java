package UI.Controlador;

import Solitario.Solitario.TipoSolitario;
import Solitario.Solitario;
import UI.Vista.GameView;

public class GameControllerFactory {

	public static GameController crearGameController(Solitario s, GameView gameView) {
		TipoSolitario tipo = TipoSolitario.valueOf(s.getClass().getSimpleName());

		return switch (tipo) {
			case Klondike -> new KlondikeController(s, gameView);
			case Spider -> new SpiderController(s, gameView);
		};
	}
}
