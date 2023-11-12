package Vista;

import Spider.*;
import Solitario.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Iterator;

public class ViewSpider extends GameView{

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}


	@Override
	protected void cargarTablero(Solitario s) {
		Spider sp = (Spider)s;

		double y = 8;
		double x = 14;

		gc.drawImage(new Image("/Cartas/VACIO.png"), x, y);
		Iterator<Carta> iterador = sp.getTalon().getPila().descendingIterator();

		while (iterador.hasNext()){
			gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);
			y += 0.8;
			x += 0.3;
		}


		x = 234;
		for(PilaDeCartas p : sp.getFoundation().getPilasFoundation()){
			gc.drawImage(new Image("/Cartas/VACIO.png"), x, y);
			iterador = p.getPila().descendingIterator();

			while (iterador.hasNext())
				gc.drawImage(new Image(iterador.next().getImagenSegunEstado()), x, y);

			x += 110;
		}


		x = 14;
		for(PilaDeCartas p : sp.getTableau().getPilasDeTableau()){
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
