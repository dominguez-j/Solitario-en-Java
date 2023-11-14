package UI.Vista;

import UI.Controlador.GameController;
import Solitario.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Iterator;

public abstract class GameView {

	protected Stage stage;
	protected Scene scene;
	protected GameController gc;
	protected Solitario s;
	protected BorderPane root;
	protected MenuBar menuBar;

	public void irAlMenu() throws IOException{
		Navigation.irAlMenu(this.stage);
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setController(GameController gc){
		this.gc = gc;
	}

	public void actualizarVista(){
		cargarTablero();
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

	public void inicializarJuego(Solitario s) {
		this.s = s;
		root = new BorderPane();
		root.setStyle("-fx-background-color: #006400;");
		scene = ResolutionSetter.setResolution(root, s);
		crearMenuBar();
		cargarTablero();
	}

	private void crearMenuBar(){
		menuBar = new MenuBar();
		Menu opcionesMenu = new Menu("Opciones");
		MenuItem irAlMenu = new MenuItem("Ir al Menú Principal");

		irAlMenu.setOnAction(event -> {
			try {
				this.irAlMenu();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

		opcionesMenu.getItems().add(irAlMenu);
		menuBar.getMenus().add(opcionesMenu);
		root.setTop(menuBar);
	}

	protected abstract void cargarTablero();

	protected ImageView crearImageView(Image image, double x, double y){
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(image.getWidth()/1.25);
		imageView.setFitHeight(image.getHeight()/1.25);
		imageView.setX(x);
		imageView.setY(y);
		return imageView;
	}

	protected void cargarPilaConEventos(PilaDeCartas pila, double x, double y, double incrementoX, double incrementoY, String palo) {
		ImageView cartaImageView = crearImageView(new Image(palo == null ? "/Cartas/VACIO.png": "/Cartas/"+palo+" VACIO.png"), x,y);
		gc.asociarEventoDeClicACarta(new CardView(null, cartaImageView), pila);
		root.getChildren().add(cartaImageView);

		Iterator<Carta> iterador = pila.getPila().descendingIterator();
		while (iterador.hasNext()){
			Carta carta = iterador.next();
			cartaImageView = crearImageView(new Image(carta.getImagenSegunEstado()), x,y);
			gc.asociarEventoDeClicACarta(new CardView(carta, cartaImageView), pila);
			root.getChildren().add(cartaImageView);
			y += incrementoY;
			x += incrementoX;
		}
	}
}
