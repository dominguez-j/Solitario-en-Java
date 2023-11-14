package UI.Controlador;

import Solitario.PilaDeCartas;
import Solitario.Solitario;
import Spider.TalonSpider;
import UI.Vista.CardView;
import UI.Vista.GameView;
import javafx.scene.effect.ColorAdjust;

public class SpiderController extends GameController{

	public SpiderController(Solitario s, GameView gameView) {
		this.s = s;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	@Override
	public void asociarEventoDeClicACarta(CardView cardView, PilaDeCartas pila) {
		cardView.getCartaImageView().setOnMouseClicked(event -> {
			if(!cardView.isSeleccionada()){
				if(pila instanceof TalonSpider){
					((TalonSpider) pila).robarCarta(s.getTableau(), s.getFoundation());
					gameView.actualizarVista();
					return;
				}

				if(cardView.getCarta() != null && !cardView.getCarta().estaOculta() && !cardView.isSeleccionada()) {
					ColorAdjust colorAdjust = new ColorAdjust();
					colorAdjust.setBrightness(-0.5);
					cardView.getCartaImageView().setEffect(colorAdjust);
					cardView.setSeleccionada();

				}
			}
		});
	}
}
