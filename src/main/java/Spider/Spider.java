package Spider;

import Solitario.*;
import java.util.*;

public class Spider extends Solitario {

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

	public void empezarJuego(TalonSpider talon, Foundation foundation, Tableau tableau){
		this.talon = talon;
		this.foundation = foundation;
		this.tableau = tableau;
	}

	@Override
	public void llenarJuego(){
		Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
		this.talon = new TalonSpider(mazoDistribuido.removeLast());
		this.tableau = new Tableau(mazoDistribuido);
		Deque<PilaDeCartas> foundation = new LinkedList<>();
		for (int i = 0; i < MazoSpider.CANT_PILAS_FOUNDATION; i++)
			foundation.add(new PilaDeCartas());
		this.foundation = new Foundation(foundation);
	}

	@Override
	public void moverCartas(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
		destino.agregarCartas(origen.extraerCartas(cantidad));
		PilaDeTableauSpider t = new PilaDeTableauSpider(destino);
		t.moverCartasAlFoundationSiEsPosible(this.foundation);
	}
}
