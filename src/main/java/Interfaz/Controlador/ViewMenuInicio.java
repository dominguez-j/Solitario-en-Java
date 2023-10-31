package Interfaz.Controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.*;

import java.io.IOException;
import java.util.Optional;

public class ViewMenuInicio {

	private long seed = -1;
	private int cant_palos = 1;

	@FXML
	private ComboBox<String> gameSelection;

	@FXML
	private ComboBox<String> suitsSelection;

	@FXML
	private ComboBox<String> seedSelection;

	@FXML
	private void handleGameSelection() {
		String selectedGame = gameSelection.getValue();
		suitsSelection.setVisible("Spider".equals(selectedGame));
	}

	@FXML
	private void handleSuitsSelection() {
		cant_palos = Integer.parseInt(suitsSelection.getValue());
	}

	@FXML
	private void handleSeedSelection() {
		String selectedSeed = seedSelection.getValue();
		if ("Semilla personalizada".equals(selectedSeed)) {
			TextInputDialog dialog = new TextInputDialog();
			Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
			stage.getIcons().add(new Image("/Logo/logo.png"));
			dialog.setTitle("Ingrese una semilla personalizada");
			dialog.setHeaderText("Ingrese una semilla personalizada:");

			Optional<String> result = dialog.showAndWait();
			result.ifPresent(s -> seed = Long.parseLong(s));
		}
	}

	@FXML
	private void startGame() {
		String selectedGame = gameSelection.getValue();

		if ("Klondike".equals(selectedGame)) {
			ViewKlondike.empezarPartida(seed);
		} else if ("Spider".equals(selectedGame)) {
			ViewSpider.empezarPartida(cant_palos, seed);
		}
	}

	@FXML
	private void showDevelopers() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Créditos");
		alert.setHeaderText("Esta aplicación fue desarrollada por:");

		Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image("/Logo/logo.png"));

		String desarrolladores = "Jonathan Dominguez - 110057\nMartín Sosa - 98741\nMatías Xu - 109938";

		alert.setContentText(desarrolladores);
		alert.showAndWait();
	}

	@FXML
	private void goToMainMenu() throws IOException {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/ViewMenuInicio.fxml"));
		Parent root = loader.load();
		root.setStyle("-fx-background-color: #0f570f;");

		Scene scene = new Scene(root, 800, 600);
		Stage stage = (Stage) gameSelection.getScene().getWindow();
		stage.setScene(scene);
	}
}
