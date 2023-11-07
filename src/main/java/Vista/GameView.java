package Vista;

import Vista.Navigation;
import Solitario.Solitario;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class GameView {

	protected Stage stage;

	@FXML
	protected MenuBar menuBar;

	public void irAlMenu() throws IOException {
		Navigation.irAlMenu((Stage) menuBar.getScene().getWindow());
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public abstract void actualizarVista(Solitario s) throws IOException;

	public void mostrarVentanaDeVictoria(){

	}
	public abstract void inicializarJuego(Solitario s);
}
