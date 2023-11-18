import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Vista.GameViewFactory;
import UI.Vista.GameView;
import Solitario.Solitario;
import UI.Vista.UI_Setter;
import UI.Vista.MainMenuView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;

public class App extends Application {

	private Solitario s;
	private GameController gc;
	FXMLLoader loader;
	File partida;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		partida = new File("partida.ser");

		if(partida.exists())
			s = Solitario.cargarPartida(new FileInputStream(partida));

		loader = new FXMLLoader(getClass().getResource("/UI/ViewMenuInicio.fxml"));
	}

	@Override
	public void start(Stage stage) throws IOException {
		UI_Setter.setIcon(stage);
		stage.setTitle("Solitario FIUBA");
		stage.setResizable(false);
		stage.setScene(new Scene(loader.load(), 800, 600));
		UI_Setter.setStyle(stage);
		if(s != null) {
			GameView gameView = GameViewFactory.crearGameView(s.getClass().getSimpleName());
			gameView.setStage(stage);

			gc = GameControllerFactory.crearGameController(s, gameView);
			gc.inicializarPantalla();
		}
		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(gc == null)
			gc = ((MainMenuView)loader.getController()).getGameController();

		if(gc !=  null)
			gc.getSolitario().guardarPartida(new FileOutputStream("partida.ser"));
	}
}
