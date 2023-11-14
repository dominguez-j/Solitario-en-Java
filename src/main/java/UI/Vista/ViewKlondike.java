package UI.Vista;

import Klondike.*;
import Solitario.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewKlondike extends GameView {

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}

	@Override
	protected void cargarTablero(Solitario s) {
		Klondike k = (Klondike)s;

		double y = 35;
		double x = 14;

		cargarPilaConEventos(k.getTalon(), x, y, 0.3, 0.8, null);

		y = 35;
		x = 150;
		cargarPilaConEventos(k.getWaste(), x, y, 0, 0, null);

		x = 344;
		int index_palo = 0;
		for(PilaDeCartas p : k.getFoundation().getPilasFoundation()){
			cargarPilaConEventos(p, x, y, 0, 0, Carta.Palo.values()[index_palo].name());
			x += 110;
			index_palo++;
		}

		x = 14;
		for(PilaDeCartas p : k.getTableau().getPilasDeTableau()){
			y = 210;
			cargarPilaConEventos(p, x, y, 0, 17, null);
			x += 110;
		}

		stage.setScene(scene);
	}

	@Override
	protected void asociarEventoDeClicACarta(ImageView imageView, Carta carta, PilaDeCartas pila) {
		imageView.setOnMouseClicked(event -> {
			if(event.getClickCount() == 1)
				if(carta != null)
					System.out.println(carta.getPalo() +" "+ carta.getValor() );
				

		});
	}
}
