package UI.Controlador;

import Klondike.*;
import Solitario.Solitario;
import UI.Vista.CardView;
import UI.Vista.GameView;
import UI.Vista.ReproductorDeSonidos;

public class KlondikeController extends GameController{

	public KlondikeController(Solitario s, GameView gameView) {
		this.s = s;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	@Override
	public void handlerTalon(CardView cardView){
		if(cardView.getRefenciaPila().estaVacia())
			ReproductorDeSonidos.reproducirSonido("Sonido Talon.mp3");
		else
			ReproductorDeSonidos.reproducirSonido("Sonido Carta.mp3");

		((TalonKlondike)cardView.getRefenciaPila()).robarCarta();
		actualizarPantalla();
	}

	@Override
	public boolean checkTalon(CardView cardView){
		return cardView.getRefenciaPila() instanceof TalonKlondike;
	}
}


