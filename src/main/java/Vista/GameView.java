package Vista;

import Controlador.GameController;
import Controlador.GameLoader;
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
		BorderPane root = GameLoader.crearLoader(s).load();
		scene = ResolutionSetter.setResolution(root, s);
		gameCanvas = new Canvas(scene.getWidth(), scene.getHeight());
		gc = gameCanvas.getGraphicsContext2D();
		gc.setFill(Color.DARKGREEN);
		gc.fillRect(0, 0, scene.getWidth(), scene.getHeight());
		root.setCenter(gameCanvas);

		cargarTablero(s);
	}

	protected abstract void cargarTablero(Solitario s);

	protected ImageView crearImageView(Image image, double x, double y){
		ImageView imageView = new ImageView(image);
		imageView.setX(x);
		imageView.setY(y);
		return imageView;
	}

	protected void cargarPilaConEventos(PilaDeCartas pila, double x, double y, double incrementoX, double incrementoY) {
		Image cartaImage = new Image("/Cartas/VACIO.png");
		gc.drawImage(cartaImage, x, y);
		ImageView cartaImageView = crearImageView(cartaImage, x,y);
		asociarEventoDeClicACarta(cartaImageView, null, pila);

		Iterator<Carta> iterador = pila.getPila().descendingIterator();
		while (iterador.hasNext()){
			Carta carta = iterador.next();
			cartaImage = new Image(carta.getImagenSegunEstado());
			gc.drawImage(cartaImage, x, y);
			cartaImageView = crearImageView(cartaImage, x,y);
			asociarEventoDeClicACarta(cartaImageView, carta, pila);
			y += incrementoY;
			x += incrementoX;
		}
	}

	protected abstract void asociarEventoDeClicACarta(ImageView imageView, Carta carta, PilaDeCartas pila);
}
