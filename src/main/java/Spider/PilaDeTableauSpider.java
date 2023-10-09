package Spider;

import Solitario.*;
import java.util.Iterator;

public class PilaDeTableauSpider extends PilaDeCartas {

	public PilaDeTableauSpider(){super();}

	public PilaDeTableauSpider(PilaDeCartas tableau){super(tableau.getPila());}

	@Override
	public boolean sePuedeApilar(PilaDeCartas copiaAExtraer){
		if(copiaAExtraer.getPila() == null) return false;

		boolean estaVacia = copiaAExtraer.estaVacia();
		if(estaVacia) return false;

		boolean esAntecesor;
		boolean esMismoPalo;
		boolean error = false;
		Iterator<Carta> iterador = copiaAExtraer.getPila().iterator();
		Carta aux = iterador.next();

		while(iterador.hasNext() && !error){
			Carta c = iterador.next();
			esMismoPalo = aux.esMismoPalo(c);
			esAntecesor  = aux.esAntecesor(c);
			if(!esMismoPalo || !esAntecesor)
				error = true;
			aux = c;
		}
		if(error)
			return false;

		boolean estoyVacia = this.estaVacia();
		if(estoyVacia) return true;

		return this.getPrimera().esAntecesor(copiaAExtraer.getUltima());
	}

	//!estaOculta() && esK -> {esAntecesor && esMismoPalo} que sea una pila de 13 => getPrimera() == esAs
}