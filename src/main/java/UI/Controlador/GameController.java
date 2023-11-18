package UI.Controlador;

import Solitario.*;
import UI.Vista.CardView;
import UI.Vista.GameView;
import UI.Vista.ReproductorDeSonidos;

import java.io.File;
import java.io.IOException;


public abstract class GameController {
	protected Solitario s;
	protected GameView gameView;
	protected CardView cartaSeleccionada;

	public Solitario getSolitario(){
		return this.s;
	}

	public void empezarNuevaPartida(String suits, String seed) {

		if (seed.equals("Semilla aleatoria"))
			s.empezarJuego(Integer.parseInt(suits));
		else
			s.empezarJuego(Integer.parseInt(suits), Long.parseLong(seed));

		inicializarPantalla();
	}

	public void inicializarPantalla() {
		gameView.inicializarJuego(s);
	}

	public void hacerMovimiento(PilaDeCartas origen, PilaDeCartas destino, int cantidad) throws IOException {
		if (!s.verificarVictoria()) {
			if(s.esMovimientoValido(origen, destino, cantidad)){
				s.moverCartas(origen, destino, cantidad);
				ReproductorDeSonidos.reproducirSonido("Sonido Carta.mp3");
			}
		}
		actualizarPantalla();
		if(s.verificarVictoria()){
			ReproductorDeSonidos.reproducirSonido("Sonido Victoria.mp3");
			mostrarMensajeDeVictoria();
			File partida = new File("partida.ser");
			partida.delete();
		}
	}

	protected void actualizarPantalla() {
		gameView.actualizarVista();
	}

	private void mostrarMensajeDeVictoria() throws IOException {
		gameView.mostrarVentanaDeVictoria();
	}

	public void asociarEventoDeClicACarta(CardView cardView){
		cardView.getCartaImageView().setOnMouseClicked(event -> {
			if (esUnaSeleccion(cardView)) {
				if (esUnaCartaValidaParaSeleccionar(cardView))
					handleSeleccionDeCarta(cardView);
				else if (checkTalon(cardView))
					handlerTalon(cardView);

			} else if(esUnMovimiento(cardView)) {
				try {
					handleMovimiento(cardView);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			else
				handleDeseleccionDeCarta(cardView);
		});
	}

	public abstract void handlerTalon(CardView cardView);

	public abstract boolean checkTalon(CardView cardView);

	public boolean esUnMovimiento(CardView cardView) {
		return !cardView.isSeleccionada() && cartaSeleccionada != null;
	}

	public boolean esUnaSeleccion(CardView cardView){
		return !cardView.isSeleccionada() && cartaSeleccionada == null;
	}

	public boolean esUnaCartaValidaParaSeleccionar(CardView cardView){
		return cardView.getCarta() != null && !cardView.getCarta().estaOculta();
	}

	public void handleSeleccionDeCarta(CardView cardView){
		cardView.setSeleccionada();
		cartaSeleccionada = cardView;
	}

	public void handleDeseleccionDeCarta(CardView cardView){
		cardView.setDeseleccionada();
		cartaSeleccionada = null;
	}

	public void handleMovimiento(CardView cardView) throws IOException {
		hacerMovimiento(cartaSeleccionada.getRefenciaPila(), cardView.getRefenciaPila(), cartaSeleccionada.getCantidadDeCartasAMover());
		cartaSeleccionada = null;
	}
}
