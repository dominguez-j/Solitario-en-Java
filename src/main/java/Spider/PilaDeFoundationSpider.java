package Spider;

import Solitario.Carta;
import Solitario.PilaDeCartas;

import java.util.Deque;

public class PilaDeFoundationSpider extends PilaDeCartas {

	public PilaDeFoundationSpider() {
		super();
	}

	public PilaDeFoundationSpider(PilaDeCartas foundation) {
		super(foundation.getPila());
	}

	@Override
	public Deque<Carta> copiarCartas(int cantidad) {return null;}
}
