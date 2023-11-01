package Interfaz.Controlador;

import Solitario.Solitario;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewKlondike extends GameView {

	@Override
	public void actualizarVista(Solitario s) throws IOException {

		Scene scene = new Scene(GameLoader.crearLoader(s).load(), 800, 600);
		stage.setScene(scene);
	}
}