import UI.Controlador.GameController;
import UI.Vista.*;
import Solitario.Solitario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

	private Solitario s;
	private MainMenuView mv;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init(){
		File partida = new File("partida.ser");

		if(partida.exists()){
			try{
				s = Solitario.cargarPartida(new FileInputStream(partida));
			} catch (IOException | ClassNotFoundException e) {
				s = null;
			}
		}

		try{
			FXMLLoader loader = new FXMLLoader(Navigation.class.getResource("/UI/ViewMenuInicio.fxml"));
			loader.load();
			mv = loader.getController();
			mv.setScene(UI_Setter.setResolutionMenu(mv.getRoot()));
		}
		catch (IOException e){
			mostrarError(e.getMessage(), "Error al cargar la interfaz");
			stop();
		}
	}

	@Override
	public void start(Stage stage) {
		UI_Setter.setIcon(stage);
		stage.setTitle("Solitario FIUBA");
		stage.setResizable(false);
		mv.setStage(stage);

		if(s != null)
			mv.continuarJuego(s);
		else
			Navigation.irAlMenu(stage, mv.getScene());

		stage.show();
	}

	@Override
	public void stop(){
		if(mv.getGameController() != null){
			GameController gc = mv.getGameController();
			if(!gc.getSolitario().verificarVictoria()){
				try{
					gc.getSolitario().guardarPartida(new FileOutputStream("partida.ser"));
				}
				catch (IOException e){
					mostrarError(e.getMessage(),"Error al guardar la partida");
				}
			}
		}
	}

	private void mostrarError(String mensaje, String header){
		Alert alert = new Alert(Alert.AlertType.ERROR);
		UI_Setter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());
		alert.setTitle("Error");
		alert.setHeaderText(header);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}
}
