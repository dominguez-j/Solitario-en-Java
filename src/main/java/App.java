import UI.Controlador.GameController;
import UI.Vista.*;
import Solitario.Solitario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

	private Solitario s;
	private MainMenuView mv;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws IOException, ClassNotFoundException {
		File partida = new File("partida.ser");

		if(partida.exists())
			s = Solitario.cargarPartida(new FileInputStream(partida));

		FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
		loader.load();
		mv = loader.getController();
		mv.setScene(UI_Setter.setResolutionMenu(mv.getRoot()));
	}

	@Override
	public void start(Stage stage){
		UI_Setter.setIcon(stage);
		stage.setTitle("Solitario FIUBA");
		stage.setResizable(false);
		mv.setStage(stage);

		if(s != null)
			mv.continuarJuego(s);
		else
			Navigation.irAlMenu(stage, mv);

		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(mv.getGameController() != null){
			GameController gc = mv.getGameController();
			if(!gc.getSolitario().verificarVictoria())
				gc.getSolitario().guardarPartida(new FileOutputStream("partida.ser"));
		}
	}
}
