package Spider;

import Solitario.*;
import java.util.Deque;
import java.util.LinkedList;

public class MazoSpider extends Mazo {

	public static final int UN_PALO = 1;
	public static final int DOS_PALO = 2;
	public static final int CUATRO_PALO = 4;
	public static final int CANT_PILAS_TABLEAU = 10;
	public static final int CANT_PILAS_FOUNDATION = 8;

	public MazoSpider(){super();}

	@Override
	public void inicializar(int cant_palos){
		if(cant_palos != UN_PALO && cant_palos != DOS_PALO && cant_palos != CUATRO_PALO)
			return;

		for(int j = 0; j < cant_palos; j++){
			for(int k = 0; k < CANT_PILAS_FOUNDATION / cant_palos; k++){
				for(int i = 1; i <= Mazo.CARTAS_POR_PALO; i++)
					this.mazo.add(new Carta(i, Carta.Palo.values()[j]));
			}
		}
	}

	@Override
	public Deque<PilaDeCartas> repartir(){
		PilaDeCartas aux = new PilaDeCartas();
		Deque<PilaDeCartas> mazoDistribuido = new LinkedList<>();

		for(int i = 1; i <= CANT_PILAS_TABLEAU; i++){
			int k = 0;
			if(i < CANT_PILAS_TABLEAU / 2) k = 1;

			for(int j = 0; j < CANT_PILAS_TABLEAU / 2 + k; j++)
				aux.pushCarta(this.mazo.pop());

			aux.getPrimera().setVisible();
			mazoDistribuido.add(aux);
			aux = new PilaDeCartas();
		}

		mazoDistribuido.add(new PilaDeCartas(this.mazo));
		return mazoDistribuido;
	}
}
