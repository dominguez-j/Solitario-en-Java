package UI.Controlador;

import Solitario.Solitario;
import Spider.TalonSpider;
import UI.Vista.CardView;
import UI.Vista.GameView;
public class SpiderController extends GameController{

	public SpiderController(Solitario s, GameView gameView) {
		this.s = s;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	@Override
	public void handlerTalon(CardView cardView){
		((TalonSpider)cardView.getRefenciaPila()).robarCarta(s.getTableau(), s.getFoundation());
		gameView.actualizarVista();
	}

	@Override
	public boolean checkTalon(CardView cardView){
		return cardView.getRefenciaPila() instanceof TalonSpider;
	}
}
