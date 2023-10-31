import Gestor.GestorDePartida;
import Interfaz.Controlador.*;
import Klondike.Klondike;
import Spider.Spider;
import Solitario.Solitario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
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

		if(partida.exists()){
			s = g.cargarPartida(new FileInputStream(partida));
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.getIcons().add(new Image("/Logo/logo.png"));

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ViewMenuInicio.fxml"));
		Parent root = loader.load();
		root.setStyle("-fx-background-color: #0f570f;");
		Scene scene = new Scene(root, 800, 600);

		root.prefWidth(scene.getWidth());
		root.prefHeight(scene.getHeight());

		if (s instanceof Klondike) {
			FXMLLoader klondikeLoader = new FXMLLoader(getClass().getResource("/Vista/ViewKlondike.fxml"));

			ViewKlondike klondikeController = klondikeLoader.getController();
			klondikeController.setSolitario((Klondike) s);
		}else if(s instanceof Spider){
			FXMLLoader spiderLoader = new FXMLLoader(getClass().getResource("/Vista/ViewSpider.fxml"));

			ViewSpider spiderController = spiderLoader.getController();
			spiderController.setSolitario((Spider) s);
		}

		stage.setTitle("Solitario FIUBA");
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void stop() throws IOException {
		if(s != null)
			g.guardarPartida(new FileOutputStream("partida.data"), s);
	}
}
