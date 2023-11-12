package Vista;


import Klondike.*;
import Solitario.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Iterator;

public class ViewKlondike extends GameView {

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}

	@Override
	protected void cargarTablero(Solitario s) {
		Klondike k = (Klondike)s;

		double y = 8;
		double x = 14;

		gc.drawImage(new Image("/Cartas/VACIO.png"), x, y);
		Iterator<Carta> iterador = k.getTalon().getPila().descendingIterator();

		while (iterador.hasNext()){
			gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);
			y += 0.8;
			x += 0.3;
		}

		y = 8;
		x = 150;
		gc.drawImage(new Image("/Cartas/VACIO.png"), x, y);

		iterador = k.getWaste().getPila().descendingIterator();

		while (iterador.hasNext())
			gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);


		x = 344;
		for(Carta.Palo p : Carta.Palo.values()){
			gc.drawImage(new Image("/Cartas/"+p.name()+" VACIO.png"), x, y);
			x += 110;
		}

		x = 344;
		for(PilaDeCartas p : k.getFoundation().getPilasFoundation()){
			iterador = p.getPila().descendingIterator();

			while (iterador.hasNext())
				gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);

			x += 110;
		}


		x = 14;
		for(PilaDeCartas p : k.getTableau().getPilasDeTableau()){
			iterador = p.getPila().descendingIterator();

			y = 210;

			while (iterador.hasNext()){
				gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);
				y += 17;
			}
			x += 110;
		}

		stage.setScene(scene);
	}
}
