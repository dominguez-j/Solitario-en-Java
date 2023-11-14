package UI.Controlador;

import Solitario.*;
import UI.Vista.CardView;
import UI.Vista.GameView;

import java.io.IOException;

public abstract class GameController {
	protected Solitario s;
	protected GameView gameView;
	protected CardView cartaSeleccionada;

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
			if(s.esMovimientoValido(origen, destino, cantidad))
				s.moverCartas(origen, destino, cantidad);
		}
		if(s.verificarVictoria())
			mostrarMensajeDeVictoria();
	}

	private void actualizarPantalla() {
		gameView.actualizarVista();
	}

	private void mostrarMensajeDeVictoria() {
		gameView.mostrarVentanaDeVictoria();
	}

	public void asociarEventoDeClicACarta(CardView cardView){
		cardView.getCartaImageView().setOnMouseClicked(event -> {
			if (!cardView.isSeleccionada() && cartaSeleccionada == null) {
				if (cardView.getCarta() != null && !cardView.getCarta().estaOculta()) {
					cardView.setSeleccionada();
					cartaSeleccionada = cardView;
				}else if (checkTalon(cardView)) {
					handlerTalon(cardView);
				}
			} else if(!cardView.isSeleccionada() && cartaSeleccionada != null){
				try {
					hacerMovimiento(cartaSeleccionada.getRefenciaPila(), cardView.getRefenciaPila(), cartaSeleccionada.getCantidadDeCartasAMover());
					cartaSeleccionada = null;
					gameView.actualizarVista();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			else {
				cardView.setDeseleccionada();
				cartaSeleccionada = null;
			}
		});
	};

	public abstract void handlerTalon(CardView cardView);

	public abstract boolean checkTalon(CardView cardView);
}
