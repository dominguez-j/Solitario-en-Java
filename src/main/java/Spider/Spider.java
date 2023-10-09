package Spider;

import Solitario.*;
import java.util.*;

public class Spider extends Solitario {

	public static final int CANT_PILAS_TABLEAU = 10;
	public static final int CANT_PILAS_FOUNDATION = 8;

	public Spider(){this.mazo = new MazoSpider();}

	public void empezarJuego(int cant_palos, long semilla){
		mazo.inicializar(cant_palos);
		mazo.mezclar(semilla);
		llenarJuego();
	}

	public void empezarJuego(int cant_palos){
		mazo.inicializar(cant_palos);
		mazo.mezclar(System.currentTimeMillis());
		llenarJuego();
	}

	@Override
	public void llenarJuego(){
		Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
		this.talon = new TalonSpider(talon);
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
