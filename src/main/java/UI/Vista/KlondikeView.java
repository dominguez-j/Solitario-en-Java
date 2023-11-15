package UI.Vista;

import Klondike.*;
import Solitario.*;

public class KlondikeView extends GameView {
	@Override
	protected void cargarTablero() {
		Klondike k = (Klondike)s;
		double y = 35;
		double x = 14;
		root.getChildren().clear();
		root.setTop(menuBar);

		cargarPilaConEventos(k.getTalon(), x, y, 0.3, 0.8, null);

		y = 35;
		x = 130;
		cargarPilaConEventos(k.getWaste(), x, y, 0, 0, null);

		x = 337;
		int index_palo = 0;
		for(PilaDeCartas p : k.getFoundation().getPilasFoundation()){
			cargarPilaConEventos(p, x, y, 0, 0, Carta.Palo.values()[index_palo].name());
			x += 90;
			index_palo++;
		}

		x = 40;
		for(PilaDeCartas p : k.getTableau().getPilasDeTableau()){
			y = 200;
			cargarPilaConEventos(p, x, y, 0, 35, null);
			x += 90;
		}

		stage.setScene(scene);
	}
}
