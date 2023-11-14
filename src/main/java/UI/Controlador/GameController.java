package UI.Controlador;

import Solitario.*;
import UI.Vista.CardView;
import UI.Vista.GameView;

import java.io.IOException;

public abstract class GameController {
	protected Solitario s;
	protected GameView gameView;

	public void continuarPartida() {
		actualizarPantalla();
	}

	public void empezarNuevaPartida(String suits, String seed) {

		if (seed.equals("Semilla aleatoria"))
			s.empezarJuego(Integer.parseInt(suits));
		else
			s.empezarJuego(Integer.parseInt(suits), Long.parseLong(seed));

		inicializarPantalla();
	}

	private void inicializarPantalla() {
		gameView.inicializarJuego(s);
	}

	public void hacerMovimiento(PilaDeCartas origen, PilaDeCartas destino, int cantidad) throws IOException {
		if (!s.verificarVictoria()) {
			if(!s.esMovimientoValido(origen, destino, cantidad))
				return;

			s.moverCartas(origen, destino, cantidad);
			actualizarPantalla();
		}

		if (s.verificarVictoria())
			mostrarMensajeDeVictoria();
	}

	private void actualizarPantalla() {
		gameView.actualizarVista();
	}

	private void mostrarMensajeDeVictoria() throws IOException {
		gameView.mostrarVentanaDeVictoria();
	}

	public abstract void asociarEventoDeClicACarta(CardView cardView, PilaDeCartas pila);
}
