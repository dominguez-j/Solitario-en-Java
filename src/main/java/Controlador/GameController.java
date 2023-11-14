package Controlador;

import Solitario.*;
import Vista.GameView;

import java.io.IOException;

public class GameController {
	private Solitario solitario;
	private GameView gameView;

	public GameController(Solitario solitario, GameView gameView) {
		this.solitario = solitario;
		this.gameView = gameView;
		this.gameView.setController(this);
	}

	public void continuarPartida() {
		actualizarPantalla();
	}

	public void empezarNuevaPartida(String suits, String seed) throws IOException {

		if (seed.equals("Semilla aleatoria"))
			solitario.empezarJuego(Integer.parseInt(suits));
		else
			solitario.empezarJuego(Integer.parseInt(suits), Long.parseLong(seed));

		inicializarPantalla();
	}

	private void inicializarPantalla() throws IOException {
		gameView.inicializarJuego(solitario);
	}

	public void hacerMovimiento(PilaDeCartas origen, PilaDeCartas destino, int cantidad) throws IOException {
		if (!solitario.verificarVictoria()) {
			if(!solitario.esMovimientoValido(origen, destino, cantidad))
				return;

			solitario.moverCartas(origen, destino, cantidad);
			actualizarPantalla();
		}

		if (solitario.verificarVictoria())
			mostrarMensajeDeVictoria();
	}

	private void actualizarPantalla() {
		gameView.actualizarVista(solitario);
	}

	private void mostrarMensajeDeVictoria() throws IOException {
		gameView.mostrarVentanaDeVictoria();
	}
}
