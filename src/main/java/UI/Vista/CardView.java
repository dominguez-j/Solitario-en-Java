package UI.Vista;

import Solitario.Carta;
import javafx.scene.image.ImageView;

public class CardView {

	private Carta carta;
	private ImageView cartaImageView;
	private boolean seleccionada;

	public CardView(Carta carta, ImageView cartaImageView){
		this.carta = carta;
		this.cartaImageView = cartaImageView;
		this.seleccionada = false;
	}

	public Carta getCarta(){ return this.carta; }

	public ImageView getCartaImageView(){ return this.cartaImageView; }

	public boolean isSeleccionada() { return this.seleccionada; }

	public void setSeleccionada() {this.seleccionada = true;}

	//public void deseleccionar() {this.seleccionada = false;}

}
