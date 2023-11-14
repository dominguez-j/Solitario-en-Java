package Vista;

import Klondike.*;
import Solitario.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewKlondike extends GameView{

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}

	@Override
	protected void cargarTablero(Solitario s) {
		Klondike k = (Klondike)s;
		ImageView cartaImageView;
		Image cartaImage;

		double y = 8;
		double x = 14;

		cargarPilaConEventos(k.getTalon(), x, y, 0.3, 0.8);

		y = 8;
		x = 150;
		cargarPilaConEventos(k.getWaste(), x, y, 0, 0);

		x = 344;
		for(Carta.Palo p : Carta.Palo.values()){
			cartaImage = new Image("/Cartas/"+p.name()+" VACIO.png");
			gc.drawImage(cartaImage, x, y);
			cartaImageView = new ImageView(cartaImage);
			asociarEventoDeClicACarta(cartaImageView, null, k.getFoundation().getPilasFoundation().iterator().next());
			x += 110;
		}

		x = 344;
		for(PilaDeCartas p : k.getFoundation().getPilasFoundation()){
			cargarPilaConEventos(p, x, y, 0, 0);
			x += 110;
		}

		x = 14;
		for(PilaDeCartas p : k.getTableau().getPilasDeTableau()){
			y = 210;
			cargarPilaConEventos(p, x, y, 0, 17);
			x += 110;
		}

		stage.setScene(scene);
	}

	@Override
	protected void asociarEventoDeClicACarta(ImageView imageView, Carta carta, PilaDeCartas pila) {

	}

}
