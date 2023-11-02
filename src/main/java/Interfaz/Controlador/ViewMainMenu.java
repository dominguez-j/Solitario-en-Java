package Interfaz.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.util.Optional;

import java.io.IOException;

public class ViewMainMenu {

	private long seed = 0;

	@FXML
	private ComboBox<String> gameSelection, suitsSelection, seedSelection;

	@FXML
	private Button startButton;

	@FXML
	private void handleGameSelection() {
		String selectedGame = gameSelection.getValue();
		if("Klondike".equals(selectedGame))
			suitsSelection.setValue("1");

		suitsSelection.setVisible("Spider".equals(selectedGame));
		updateStartButtonState();
	}

	@FXML
	private void handleSuitsSelection() {
		updateStartButtonState();
	}

	@FXML
	private void handleSeedSelection() {
		String selectedSeed = seedSelection.getValue();

		if ("Semilla personalizada".equals(selectedSeed)) {
			TextInputDialog dialog = new TextInputDialog();
			dialog.setTitle("Semilla personalizada");
			dialog.setHeaderText("Ingrese una semilla personalizada:");

			IconSetter.setIcon((Stage) dialog.getDialogPane().getScene().getWindow());
			Optional<String> respuesta = dialog.showAndWait();

			respuesta.ifPresent(semilla -> {
				try {
					seed = Long.parseLong(semilla);
				} catch (NumberFormatException e) {
					Alert alert = new Alert(Alert.AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Número inválido");
					alert.setContentText("Por favor, ingrese un número válido como semilla.");

					IconSetter.setIcon((Stage)alert.getDialogPane().getScene().getWindow());
					alert.showAndWait();
				}
			});
		}
		updateStartButtonState();
	}

	private void updateStartButtonState() {
		boolean gameSelected = gameSelection.getValue() != null;
		boolean suitsValid = suitsSelection.getValue() != null;
		boolean seedValid = seedSelection.getValue() != null;

		startButton.setDisable(!(gameSelected && suitsValid && seedValid));
	}

	@FXML
	private void empezarJuego() throws IOException {
		String selectedGame = gameSelection.getValue();
		GameView gameView = GameViewFactory.crearGameView(selectedGame);

		if (gameView != null) {
			gameView.setStage((Stage)gameSelection.getScene().getWindow());

			GameController gameController = new GameController(SolitarioFactory.crearSolitario(selectedGame), gameView);
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
