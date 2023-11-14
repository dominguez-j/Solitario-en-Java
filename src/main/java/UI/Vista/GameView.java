package UI.Vista;

import UI.Controlador.GameController;
import UI.Controlador.GameLoader;
import Solitario.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Iterator;

public abstract class GameView {

	protected Stage stage;
	protected Scene scene;
	protected GameController controller;
	@FXML
	private BorderPane root;

	@FXML
	protected MenuBar menuBar;

	public void irAlMenu() throws IOException{
		Navigation.irAlMenu(this.stage);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setController(GameController controller){
		this.controller = controller;
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
		root = GameLoader.crearLoader(s).load();
		scene = ResolutionSetter.setResolution(root, s);

		cargarTablero(s);
	}

	protected abstract void cargarTablero(Solitario s);

	protected ImageView crearImageView(Image image, double x, double y){
		ImageView imageView = new ImageView(image);
		imageView.setX(x);
		imageView.setY(y);
		return imageView;
	}

	protected void cargarPilaConEventos(PilaDeCartas pila, double x, double y, double incrementoX, double incrementoY, String palo) {
		ImageView cartaImageView = crearImageView(new Image(palo == null ? "/Cartas/VACIO.png": "/Cartas/"+palo+" VACIO.png"), x,y);
		asociarEventoDeClicACarta(cartaImageView, null, pila);
		root.getChildren().add(cartaImageView);

		Iterator<Carta> iterador = pila.getPila().descendingIterator();
		while (iterador.hasNext()){
			Carta carta = iterador.next();
			cartaImageView = crearImageView(new Image(carta.getImagenSegunEstado()), x,y);
			asociarEventoDeClicACarta(cartaImageView, carta, pila);
			root.getChildren().add(cartaImageView);
			y += incrementoY;
			x += incrementoX;
		}
	}

	protected abstract void asociarEventoDeClicACarta(ImageView imageView, Carta carta, PilaDeCartas pila);
}
