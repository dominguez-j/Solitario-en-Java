package Interfaz.Controlador;

import Klondike.Klondike;

public class ViewKlondike {
	private Klondike k = null;

	public static void empezarPartida(long seed){
		Klondike k = new Klondike();
		if(seed == -1)
			k.empezarJuego(0);
		else
			k.empezarJuego(0, seed);
	}

	public void setSolitario(Klondike k) {
		this.k = k;
	}
}
