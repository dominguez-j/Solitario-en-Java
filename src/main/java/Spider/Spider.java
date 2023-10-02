package Spider;

import Solitario.*;
import java.util.*;

public class Spider extends Solitario {

	public static final int CANT_PILAS_TABLEAU = 10;
	public static final int CANT_PILAS_FOUNDATION = 8;

	public Spider(){
		this.mazo = new MazoSpider();
	}

	@Override
	public void empezarJuego(long semilla){
		mazo.inicializar();
		mazo.mezclar(semilla);
		llenarJuego();
	}

	@Override
	public void empezarJuego(){
		mazo.inicializar();
		mazo.mezclar(System.currentTimeMillis());
		llenarJuego();
	}

	private void llenarJuego(){
		Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
		this.talon = new TalonSpider(mazoDistribuido.removeLast());
		this.tableau = new Tableau(mazoDistribuido);
		Deque<PilaDeCartas> foundation = new LinkedList<>();
		this.foundation = new Foundation(foundation);
	}

	public void empezarJuego(TalonSpider talon, Foundation foundation, Tableau tableau){
		this.talon = talon;
		this.foundation = foundation;
		this.tableau = tableau;
	}
}
