package Interfaz.Controlador;

import Solitario.Solitario;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ViewKlondike extends GameView {

	@FXML
	private HBox pilasFoundation, pilaTalon, pilaWaste;

	@FXML
	private VBox pilasTableau;

	@Override
	public void actualizarVista(Solitario s) throws IOException {
		Scene scene = new Scene(GameLoader.crearLoader(s).load(), 800, 600);
		stage.setScene(scene);
	}
}
