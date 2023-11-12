package Vista;

import Controlador.GameLoader;
import Solitario.Solitario;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class GameView {

	protected Stage stage;

	protected Scene scene;

	@FXML
	protected MenuBar menuBar;

	@FXML
	protected Canvas gameCanvas;

	@FXML
	protected GraphicsContext gc;

	public void irAlMenu() throws IOException{
		Navigation.irAlMenu(this.stage);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public void actualizarVista(Solitario s){
		cargarTablero(s);
	}

	public void mostrarVentanaDeVictoria() throws IOException {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("¡Victoria!");
		alert.setHeaderText(null);
		alert.setContentText("¡Felicidades, has ganado!");

		IconSetter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());

		alert.getButtonTypes().setAll(new ButtonType("Volver"));

		if(alert.showAndWait().isPresent())
			irAlMenu();
		else
			irAlMenu();
	}

	public void inicializarJuego(Solitario s) throws IOException{
		BorderPane root = GameLoader.crearLoader(s).load();
		scene = new Scene(root, 800, 600);
		root.prefHeight(scene.getHeight());
		root.prefWidth(scene.getWidth());

		gameCanvas = new Canvas(root.getWidth(), root.getHeight());
		gc = gameCanvas.getGraphicsContext2D();
		gc.setFill(Color.DARKGREEN);
		gc.fillRect(0, 0, root.getWidth(), root.getHeight());
		root.setCenter(gameCanvas);

		cargarTablero(s);
	}

	protected abstract void cargarTablero(Solitario s);
}
