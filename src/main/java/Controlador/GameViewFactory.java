package Controlador;

import Vista.GameView;
import Vista.ViewKlondike;
import Vista.ViewSpider;

public class GameViewFactory {
	public static GameView crearGameView(String tipoSolitario) {
		if ("Klondike".equals(tipoSolitario))
			return new ViewKlondike();
		else if ("Spider".equals(tipoSolitario))
			return new ViewSpider();

		return null;
	}
}
