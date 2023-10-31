package Interfaz.Controlador;

import Spider.Spider;

public class ViewSpider {
	private Spider s = null;

	public static void empezarPartida(int cant_palos, long seed){
		Spider s = new Spider();
		if(seed == -1)
			s.empezarJuego(cant_palos);
		else
			s.empezarJuego(cant_palos, seed);
	}

	public void setSolitario(Spider s) {
		this.s = s;
	}
}
