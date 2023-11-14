package UI.Controlador;

import Klondike.*;
import Solitario.Solitario;
import UI.Vista.CardView;
import UI.Vista.GameView;

public class KlondikeController extends GameController{

	public KlondikeController(Solitario s, GameView gameView) {
		this.s = s;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	@Override
	public void handlerTalon(CardView cardView){
		((TalonKlondike)cardView.getRefenciaPila()).robarCarta();
		gameView.actualizarVista();
	}

	@Override
	public boolean checkTalon(CardView cardView){
		return cardView.getRefenciaPila() instanceof TalonKlondike;
	}
}


