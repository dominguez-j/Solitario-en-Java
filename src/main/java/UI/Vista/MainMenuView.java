package UI.Vista;

import UI.Controlador.GameController;
import UI.Controlador.GameControllerFactory;
import UI.Controlador.SolitarioFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.Optional;

public class MainMenuView {

	private long seed = 0;
	private boolean noError;

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
			Optional<String> semilla = showSemillaInputDialog();

			if(semilla.isPresent()){
				try {
					seed = Long.parseLong(semilla.get());
				} catch (NumberFormatException e) {
					mostrarError("Número inválido", "Por favor, ingrese un número válido como semilla.");
					noError = false;
				}
			} else
				noError = false;
		}
		updateStartButtonState();
	}

	private Optional<String> showSemillaInputDialog() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Semilla personalizada");
		dialog.setHeaderText("Ingrese una semilla personalizada");

		IconSetter.setIcon((Stage) dialog.getDialogPane().getScene().getWindow());

		return dialog.showAndWait();
	}

	private void mostrarError(String titulo, String mensaje) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle(titulo);
		alert.setHeaderText("");
		alert.setContentText(mensaje);
		IconSetter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());
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
		String selectedGame = gameSelection.getValue();
		GameView gameView = GameViewFactory.crearGameView(selectedGame);

		if (gameView != null) {
			gameView.setStage((Stage)gameSelection.getScene().getWindow());

			GameController gameController = GameControllerFactory.crearGameController(SolitarioFactory.crearSolitario(selectedGame), gameView);
 			gameController.empezarNuevaPartida(suitsSelection.getValue() ,seed != 0 ? String.valueOf(seed) : seedSelection.getValue());
		}
	}

	@FXML
	private void mostrarDesarrolladores() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Créditos");
		alert.setHeaderText("Esta aplicación fue desarrollada por:");

		IconSetter.setIcon((Stage) alert.getDialogPane().getScene().getWindow());

		String desarrolladores = "Jonathan Dominguez - 110057\nMartín Sosa - 98741\nMatías Xu - 109938";

		alert.setContentText(desarrolladores);
		alert.showAndWait();
	}
}
