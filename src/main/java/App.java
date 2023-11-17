import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Vista.GameViewFactory;
import UI.Vista.GameView;
import Solitario.Solitario;
import UI.Vista.IconSetter;
import UI.Vista.MainMenuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.*;

public class App extends Application {

	private Solitario s;
	private GameController gameController;
	FXMLLoader loader;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		File partida = new File("partida.ser");

		if(partida.exists())
			s = Solitario.cargarPartida(new FileInputStream(partida));

		loader = new FXMLLoader(getClass().getResource("/UI/ViewMenuInicio.fxml"));
	}

	@Override
	public void start(Stage stage) throws IOException {
		IconSetter.setIcon(stage);
		stage.setTitle("Solitario FIUBA");
		stage.setResizable(false);
		stage.setScene(new Scene(loader.load(), 800, 600));
		stage.getScene().getStylesheets().add(getClass().getResource("Estilos/Button.css").toExternalForm());
		stage.getScene().getStylesheets().add(getClass().getResource("Estilos/ComboBox.css").toExternalForm());
		if(s != null) {
			GameView gameView = GameViewFactory.crearGameView(s.getClass().getSimpleName());
			gameView.setStage(stage);

			gameController = GameControllerFactory.crearGameController(s, gameView);
			gameController.inicializarPantalla();
		}
		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(gameController == null)
			gameController = ((MainMenuView)loader.getController()).getGameController();

		if(gameController !=  null)
			gameController.getSolitario().guardarPartida(new FileOutputStream("partida.ser"));
	}
}
