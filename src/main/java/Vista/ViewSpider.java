package Vista;

import Controlador.GameLoader;
import Solitario.Solitario;
import javafx.scene.Scene;

import java.io.IOException;


public class ViewSpider extends GameView {

	@Override
	public void inicializarJuego(Solitario s) {

	}
	@Override
	public void actualizarVista(Solitario s) throws IOException {
		Scene scene = new Scene(GameLoader.crearLoader(s).load(), 800, 600);
		stage.setScene(scene);
	}
}
