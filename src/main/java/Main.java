import Gestor.GestorDePartida;
import Interfaz.Controlador.*;
import Solitario.Solitario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

	private GestorDePartida g;
	private Solitario s = null;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		g = new GestorDePartida();
		File partida = new File("partida.data");

		if(partida.exists())
			s = g.cargarPartida(new FileInputStream(partida));
	}

	@Override
	public void start(Stage stage) throws IOException {
		IconSetter.setIcon(stage);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ViewMenuInicio.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root, 800, 600);

		root.prefWidth(scene.getWidth());
		root.prefHeight(scene.getHeight());
		stage.setTitle("Solitario FIUBA");

		if(s != null) {
			GameView gameView = GameLoader.crearLoader(s).getController();
			gameView.setStage(stage);

			GameController gameController = new GameController(s, gameView);
			gameController.continuarPartida();
		}

		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(s != null)
			g.guardarPartida(new FileOutputStream("partida.data"), s);
	}
}