package Spider;

import Solitario.*;

public class TalonSpider extends PilaDeCartas {

	public TalonSpider(PilaDeCartas talon){super(talon.getPila());}

	public void robarCarta(Tableau tableau){
		if(this.estaVacia())
			return;

		for(PilaDeCartas p : tableau.getPilasDeTableau()){
			p.pushCarta(this.popCarta());
			p.getPrimera().setVisible();
		}
	}
}
