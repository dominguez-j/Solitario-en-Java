package Spider;

import Solitario.*;
import java.util.Iterator;

public class PilaDeTableauSpider extends PilaDeCartas {

	public PilaDeTableauSpider(){super();}

	public PilaDeTableauSpider(PilaDeCartas tableau){super(tableau.getPila());}

	@Override
	public boolean sePuedeApilar(PilaDeCartas copiaAExtraer){
		if (copiaAExtraer.getPila() == null) return false;
		if (copiaAExtraer.estaVacia()) return false;

		boolean esValida = validarPila(copiaAExtraer.getPila().iterator());

		if (!esValida) return false;

		boolean estoyVacia = this.estaVacia();
		if (estoyVacia) return true;

		return this.getPrimera().esAntecesor(copiaAExtraer.getUltima());
	}

	public void moverPilaDeTableauParaFoundation(Foundation foundation){
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

	private boolean validarPila(Iterator<Carta> iterador){
		boolean esAntecesor;
		boolean esMismoPalo;
		boolean estaOculta;
		boolean error = false;
		Carta aux = iterador.next();

		while(iterador.hasNext() && !error){
			Carta c = iterador.next();
			esMismoPalo = aux.esMismoPalo(c);
			esAntecesor  = aux.esAntecesor(c);
			estaOculta = aux.estaOculta();
			if(!esMismoPalo || !esAntecesor || estaOculta)
				error = true;
			aux = c;
		}

		return !error;
	}
}