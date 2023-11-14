package UI.Controlador;

import Solitario.Solitario.TipoSolitario;
import Solitario.Solitario;
import UI.Vista.GameView;

public class GameControllerFactory {

	public static GameController crearGameController(Solitario s, GameView gameView) {
		TipoSolitario tipo = TipoSolitario.valueOf(s.getClass().getSimpleName());

		switch (tipo) {
			case Klondike:
				return new KlondlikeController(s, gameView);
			case Spider:
				return new SpiderController(s, gameView);
			default:
				return null;
		}
	}
}
