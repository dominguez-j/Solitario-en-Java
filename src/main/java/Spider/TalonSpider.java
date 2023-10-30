package Spider;

import Solitario.*;

public class TalonSpider extends PilaDeCartas {

	public TalonSpider(PilaDeCartas talon){super(talon.getPila());}

	/**
	 * Roba carta del talon y reparte una en cada pila del tableau
	 * Si el talon está vacío, no sucede nada.
	 */
	public void robarCarta(Tableau tableau, Foundation foundation){
		if(this.estaVacia()) return;

		for(PilaDeCartas p : tableau.getPilasDeTableau()){
			p.pushCarta(this.popCarta());
			p.getPrimera().setVisible();
			PilaDeTableauSpider t = new PilaDeTableauSpider(p);
			t.moverCartasAlFoundationSiEsPosible(foundation);
		}
	}
}
