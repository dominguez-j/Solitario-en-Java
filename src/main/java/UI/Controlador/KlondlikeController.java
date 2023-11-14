package UI.Controlador;

import Klondike.TalonKlondike;
import Solitario.PilaDeCartas;
import Solitario.Solitario;
import UI.Vista.CardView;
import UI.Vista.GameView;
import javafx.scene.effect.ColorAdjust;


public class KlondlikeController extends GameController{

	public KlondlikeController(Solitario s, GameView gameView) {
		this.s = s;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	@Override
	public void asociarEventoDeClicACarta(CardView cardView, PilaDeCartas pila) {
		cardView.getCartaImageView().setOnMouseClicked(event -> {
			if(!cardView.isSeleccionada()){
				if(pila instanceof TalonKlondike){
					((TalonKlondike) pila).robarCarta();
					gameView.actualizarVista();
				}

				if(cardView.getCarta() != null && !cardView.getCarta().estaOculta() && !cardView.isSeleccionada()) {
					ColorAdjust colorAdjust = new ColorAdjust();
					colorAdjust.setBrightness(-0.5);
					cardView.getCartaImageView().setEffect(colorAdjust);
					cardView.setSeleccionada();

				}

			}
			else{
				//cardView.deseleccionar();

				System.out.println("hoal");
			}
		});
	}
}
