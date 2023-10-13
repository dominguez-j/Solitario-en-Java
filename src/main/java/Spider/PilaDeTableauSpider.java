package Spider;

import Solitario.*;
import java.util.Iterator;

public class PilaDeTableauSpider extends PilaDeCartas {

	public PilaDeTableauSpider(){super();}

	public PilaDeTableauSpider(PilaDeCartas tableau){super(tableau.getPila());}

	@Override
	public boolean sePuedeApilar(PilaDeCartas copiaAExtraer){
		if (noEsUnTamanioDePilaValido(copiaAExtraer)) return false;

		boolean esValida = validarPila(copiaAExtraer.getPila().iterator());

		if (!esValida) return false;

		if (this.estaVacia()) return true;

		return this.getPrimera().esAntecesor(copiaAExtraer.getUltima());
	}

	private boolean noEsUnTamanioDePilaValido(PilaDeCartas copiaAExtraer) {
		return copiaAExtraer.getPila() == null || copiaAExtraer.tamanio() != 1;
	}

	/**
	 * Intenta mover cartas del tableau al foundation si se cumplen las condiciones.
	 *
	 * @param foundation El objeto que representa el foundation en el juego.
	 */
	public void moverCartasAlFoundationSiEsPosible(Foundation foundation){
		if (this.tamanio() < Mazo.CARTAS_POR_PALO) return;

		Iterator<Carta> iterador = this.getPila().iterator();
		if (iterador.next().getValor() != Carta.AS) return;

		boolean esValida = validarPila(iterador);

		if (!esValida) return;

		for (PilaDeCartas f : foundation.getPilasFoundation()) {
			if (f.estaVacia()) {
				f.agregarCartas(this.extraerCartas(Mazo.CARTAS_POR_PALO));
				break;
			}
		}
	}

	/**
	 * Verifica si una pila de cartas en el tableau de Spider cumple con las condiciones para ser movida al foundation.
	 *
	 * @param iterador Iterador que recorre las cartas en la pila de tableau.
	 * @return True si la pila es válida para ser movida al foundation, false en caso contrario.
	 */
	private boolean validarPila(Iterator<Carta> iterador){
		boolean error = false;
		Carta aux = iterador.next();

		while(iterador.hasNext() && !error){
			Carta c = iterador.next();
			if(!aux.esMismoPalo(c) || !aux.esAntecesor(c) || aux.estaOculta())
				error = true;
			aux = c;
		}

		return !error;
	}
}