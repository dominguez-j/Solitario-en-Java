package UI.Vista;

import Solitario.Carta;
import Solitario.PilaDeCartas;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class CardView {

	private final Carta carta;
	private final ImageView cartaImageView;
	private boolean seleccionada;
	private final PilaDeCartas referencia;
	private final int posicionEnPila;

	public CardView(Carta carta, ImageView cartaImageView, PilaDeCartas referencia){
		this.carta = carta;
		this.cartaImageView = cartaImageView;
		this.seleccionada = false;
		this.referencia = referencia;
		this.posicionEnPila = getPosicionEnPila();
	}

	public Carta getCarta(){ return this.carta; }

	public ImageView getCartaImageView(){ return this.cartaImageView; }

	public PilaDeCartas getRefenciaPila() { return this.referencia;}

	public boolean isSeleccionada() { return this.seleccionada; }

	public void setSeleccionada() {
		this.seleccionada = true;
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setBrightness(-0.5);
		getCartaImageView().setEffect(colorAdjust);
	}

	public void setDeseleccionada() {
		this.seleccionada = false;
		cartaImageView.setEffect(null);
	}

	private int getPosicionEnPila(){
		ArrayList<Carta> list = new ArrayList<>(this.referencia.getPila());
		return list.indexOf(carta);
	}

	public int getCantidadDeCartasAMover(){
		return this.posicionEnPila +1;
	}
}
