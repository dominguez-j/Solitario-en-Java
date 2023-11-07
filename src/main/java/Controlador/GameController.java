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
	}

	public void continuarPartida() throws IOException {
		actualizarPantalla();
	}

	public void empezarNuevaPartida(String suits, String seed) {

		if (seed.equals("Semilla aleatoria"))
			solitario.empezarJuego(Integer.parseInt(suits));
		else
			solitario.empezarJuego(Integer.parseInt(suits), Long.parseLong(seed));

		inicializarPantalla();
	}

	private void inicializarPantalla() {
		gameView.inicializarJuego(solitario);
	}

	public void hacerMovimiento(PilaDeCartas origen, PilaDeCartas destino, int cantidad) throws IOException {
		if (!solitario.verificarVictoria()) {
			if(!solitario.esMovimientoValido(origen, destino, cantidad)){
				//Hacer algo cuando no es válido
				return;
			}
			solitario.moverCartas(origen, destino, cantidad);
			actualizarPantalla();

			if (solitario.verificarVictoria())
				mostrarMensajeDeVictoria();
		}
	}

	private void actualizarPantalla() throws IOException {
		gameView.actualizarVista(solitario);
	}

	private void mostrarMensajeDeVictoria() {
		gameView.mostrarVentanaDeVictoria();
	}
}
