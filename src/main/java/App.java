import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Vista.*;
import Solitario.Solitario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

	private Solitario s;
	private GameController gc;
	private MainMenuView mainMenuView;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		File partida = new File("partida.ser");

		if(partida.exists())
			s = Solitario.cargarPartida(new FileInputStream(partida));
	}

	@Override
	public void start(Stage stage) throws IOException {
		UI_Setter.setIcon(stage);
		stage.setTitle("Solitario FIUBA");
		stage.setResizable(false);
		if(s != null) {
			GameView gameView = GameViewFactory.crearGameView(s.getClass().getSimpleName());
			gameView.setStage(stage);
			gc = GameControllerFactory.crearGameController(s, gameView);
			gc.inicializarPantalla();
		}else{
			FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
			stage.setScene(new Scene(loader.load(), 800, 600));
			mainMenuView = loader.getController();
		}

		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(gc == null)
			gc = mainMenuView.getGameController();

		if(gc != null && !gc.getSolitario().verificarVictoria())
			gc.getSolitario().guardarPartida(new FileOutputStream("partida.ser"));

	}
}
