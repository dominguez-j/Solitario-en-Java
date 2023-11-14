package UI.Vista;

import Spider.*;
import Solitario.*;
import javafx.scene.effect.ColorAdjust;
import javafx.stage.Stage;

import java.io.IOException;

public class SpiderView extends GameView {

	@Override
	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage)menuBar.getScene().getWindow());
	}

	@Override
	protected void cargarTablero() {
		Spider sp = (Spider)s;
		double y = 35;
		double x = 14;
		root.getChildren().clear();
		root.setTop(menuBar);

		cargarPilaConEventos(sp.getTalon(), x, y, 0.3, 0.8, null);

		x = 194;
		for(PilaDeCartas p : sp.getFoundation().getPilasFoundation()){
			cargarPilaConEventos(p, x, y, 0, 0, null);
			x += 90;
		}

		x = 14;
		for(PilaDeCartas p : sp.getTableau().getPilasDeTableau()){
			y = 200;
			cargarPilaConEventos(p, x, y, 0, 35, null);
			x += 90;
		}

		stage.setScene(scene);
	}
}
