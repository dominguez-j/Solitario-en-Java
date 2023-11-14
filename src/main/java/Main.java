import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Vista.GameViewFactory;
import UI.Vista.GameView;
import Solitario.Solitario;
import UI.Vista.IconSetter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

	private Solitario s = null;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		File partida = new File("partida.data");

		if(partida.exists())
			s = s.cargarPartida(new FileInputStream(partida));
	}

	@Override
	public void start(Stage stage) throws IOException {
		IconSetter.setIcon(stage);

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UI/ViewMenuInicio.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root, 800, 600);

		stage.setTitle("Solitario FIUBA");

		if(s != null) {
			GameView gameView = GameViewFactory.crearGameView(s.getClass().getName());
			gameView.setStage(stage);

			GameController gameController = GameControllerFactory.crearGameController(s, gameView);
			gameController.continuarPartida();
		}

		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(s != null)
			s.guardarPartida(new FileOutputStream("partida.data"));
	}
}
