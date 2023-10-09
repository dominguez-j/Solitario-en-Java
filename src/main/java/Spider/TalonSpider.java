package Spider;

import Solitario.*;

public class TalonSpider extends PilaDeCartas {

	private Tableau tableau;

	public TalonSpider(PilaDeCartas talon, Tableau tableau){
		super(talon.getPila());
		this.tableau = tableau;
	}

	public void robarCarta(){
		if(this.estaVacia())
			return;

		for(PilaDeCartas p : tableau.getPilasDeTableau()){
			p.pushCarta(this.popCarta());
			p.getPrimera().setVisible();
		}
	}
}
