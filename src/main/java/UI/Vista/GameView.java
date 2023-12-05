package UI.Vista;

import UI.Controlador.GameController;
import Solitario.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Iterator;

public abstract class GameView {

	protected Stage stage;
	protected GameController gc;
	protected Solitario s;
	protected BorderPane root;
	protected MenuBar menuBar;
	private Scene sceneMainMenu;

	public void irAlMenu() {
		Navigation.irAlMenu(this.stage, this.sceneMainMenu);
	}

	public void actualizarVista(){
		cargarTablero();
	}

	public void mostrarVentanaDeVictoria() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("¡Victoria!");
		alert.setHeaderText(null);
		alert.setContentText("¡Felicidades, has ganado!");

		UI_Setter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());

		alert.getButtonTypes().setAll(new ButtonType("Volver"));

		alert.showAndWait();
		irAlMenu();
	}

	public void inicializarJuego(Solitario s) {
		setSolitario(s);
		root = new BorderPane();
		root.setStyle("-fx-background-color: #006400;");
		stage.setScene(UI_Setter.setResolutionSolitario(root, s));
		crearMenuBar();
		cargarTablero();
	}

	private void crearMenuBar(){
		menuBar = new MenuBar();
		Menu opcionesMenu = new Menu("Opciones");
		MenuItem irAlMenu = new MenuItem("Ir al Menú Principal");

		irAlMenu.setOnAction(event -> {
			this.irAlMenu();
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
		addCartaImageView(null, crearImageView(new Image(palo == null ? "/Cartas/VACIO.png": "/Cartas/"+palo+" VACIO.png"), x, y), pila);

		Iterator<Carta> iterador = pila.getPila().descendingIterator();
		while (iterador.hasNext()){
			Carta carta = iterador.next();
			addCartaImageView(carta, crearImageView(new Image(carta.getImagenSegunEstado()), x, y), pila);
			y += incrementoY;
			x += incrementoX;
		}
	}

	private void addCartaImageView(Carta carta, ImageView cartaImageView, PilaDeCartas pila){
		gc.asociarEventoDeClicACarta(new CardView(carta, cartaImageView, pila));
		root.getChildren().add(cartaImageView);
	}
	
	public void setSolitario(Solitario s){
		this.s = s;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setController(GameController gc){
		this.gc = gc;
	}
	
	public void setSceneMenuView(Scene sceneMainMenu) {
		this.sceneMainMenu = sceneMainMenu;
	}

	protected void cargarPilaTableauConEventos(double x , Solitario s){
		for(PilaDeCartas p : s.getTableau().getPilasDeTableau()){
			double y = 200;
			cargarPilaConEventos(p, x, y, 0, 35, null);
			x += 90;
		}
	}
}
