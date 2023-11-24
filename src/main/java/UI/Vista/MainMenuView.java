package UI.Vista;

import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Controlador.SolitarioFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Solitario.Solitario;

import java.util.Optional;

public class MainMenuView {

	private long seed = 0;
	private boolean noError;
	private GameController gameController;
	private Stage stage;
	private Scene scene;

	@FXML
	private BorderPane root;

	@FXML
	private ComboBox<String> gameSelection, suitsSelection, seedSelection;

	@FXML
	private Button startButton;

	@FXML
	private void handleGameSelection() {
		String selectedGame = gameSelection.getValue();

		seedSelection.setDisable(selectedGame == null);

		if ("Klondike".equals(selectedGame))
			suitsSelection.setValue("4");

		suitsSelection.setDisable(!("Spider".equals(selectedGame)));
		updateStartButtonState();
	}

	@FXML
	private void handleSuitsSelection() {
		updateStartButtonState();
	}

	@FXML
	private void handleSeedSelection() {
		String selectedSeed = seedSelection.getValue();
		noError = true;
		if ("Semilla personalizada".equals(selectedSeed)) {
			Optional<String> semilla = showSeedInputDialog();

			if(semilla.isPresent()){
				try {
					seed = Long.parseLong(semilla.get());
				} catch (NumberFormatException e) {
					mostrarError();
					noError = false;
				}
			} else
				noError = false;
		}
		updateStartButtonState();
	}

	private Optional<String> showSeedInputDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Semilla personalizada");
		dialog.setHeaderText("Ingrese una semilla personalizada");

		UI_Setter.setIcon((Stage) dialog.getDialogPane().getScene().getWindow());

		return dialog.showAndWait();
	}

	private void mostrarError() {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Número inválido");
		alert.setHeaderText("");
		alert.setContentText("Por favor, ingrese un número válido como semilla.");
		UI_Setter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());
		alert.showAndWait();
	}

	private void updateStartButtonState() {
		boolean gameValid = gameSelection.getValue() != null;
		boolean suitsValid = suitsSelection.getValue() != null;
		boolean seedValid = seedSelection.getValue() != null && noError;

		startButton.setDisable(!(gameValid && suitsValid && seedValid));
	}

	@FXML
	private void empezarJuego() {
		GameView gameView = GameViewFactory.crearGameView(gameSelection.getValue());
		gameView.setStage((Stage)gameSelection.getScene().getWindow());
		gameView.setSceneMenuView(getScene());
		gameController = GameControllerFactory.crearGameController(SolitarioFactory.crearSolitario(gameSelection.getValue()), gameView);
		gameController.empezarNuevaPartida(suitsSelection.getValue() ,seed != 0 ? String.valueOf(seed) : seedSelection.getValue());
	}

	public void continuarJuego(Solitario s){
		GameView gameView = GameViewFactory.crearGameView(s.getClass().getSimpleName());
		gameView.setStage(this.stage);
		gameView.setSceneMenuView(getScene());
		gameController = GameControllerFactory.crearGameController(s, gameView);
		gameController.inicializarPantalla();
	}

	@FXML
	private void mostrarDesarrolladores() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Créditos");
		alert.setHeaderText("Esta aplicación fue desarrollada por:");

		UI_Setter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());

		String desarrolladores = "Jonathan Dominguez - 110057\nMartín Sosa - 98741\nMatías Xu - 109938";

		alert.setContentText(desarrolladores);
		alert.showAndWait();
	}

	public GameController getGameController(){
		return this.gameController;
	}

	public BorderPane getRoot(){
		return this.root;
	}

	public void setStage(Stage stage){
		this.stage = stage;
	}

	public void setScene(Scene scene){
		this.scene = scene;
	}

	public Scene getScene(){
		return this.scene;
	}
}
