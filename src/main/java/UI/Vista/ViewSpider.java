package UI.Vista;

import Spider.*;
import Solitario.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewSpider extends GameView {

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}

	@Override
	protected void cargarTablero(Solitario s) {
		Spider sp = (Spider)s;

		double y = 8;
		double x = 14;

		cargarPilaConEventos(sp.getTalon(), x, y, 0.3, 0.8, null);

		x = 234;
		for(PilaDeCartas p : sp.getFoundation().getPilasFoundation()){
			cargarPilaConEventos(p, x, y, 0, 0, null);
			x += 110;
		}

		x = 14;
		for(PilaDeCartas p : sp.getTableau().getPilasDeTableau()){
			y = 210;
			cargarPilaConEventos(p, x, y, 0, 17, null);
			x += 110;
		}

		stage.setScene(scene);
	}

	@Override
	protected void asociarEventoDeClicACarta(ImageView imageView, Carta carta, PilaDeCartas pila) {

	}
}
