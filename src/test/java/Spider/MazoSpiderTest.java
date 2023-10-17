package Spider;

import Solitario.Carta;
import Solitario.PilaDeCartas;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazoSpiderTest {

	@Test
	public void inicializarConUnPalo() {
		//arrange
		MazoSpider m = new MazoSpider();
		List<Carta> cartas;
		boolean noError = true;
		int j = 0;
		int valorEsperado = 1;
		//act
		m.inicializar(MazoSpider.UN_PALO);
		cartas = new ArrayList<>(m.getMazo());

		for(int h = 0; h < MazoSpider.UN_PALO; h++){
			for(int k = 0; k < MazoSpider.CANT_PILAS_FOUNDATION / MazoSpider.UN_PALO; k++){
				for(int i = j; i < j+13 && j < 104 && noError; i++){
					if (cartas.get(i).getPalo() != Carta.Palo.values()[h] || cartas.get(i).getValor() != valorEsperado){
						noError = false;
					}
					valorEsperado++;
				}
				valorEsperado = 1;
				j+=13;
			}
		}

		//assert
		assertTrue(noError);
	}

	@Test
	public void inicializarConDosPalo() {
		//arrange
		MazoSpider m = new MazoSpider();
		List<Carta> cartas;
		boolean noError = true;
		int j = 0;
		int valorEsperado = 1;

		//act
		m.inicializar(MazoSpider.DOS_PALO);
		cartas = new ArrayList<>(m.getMazo());

		for(int h = 0; h < MazoSpider.DOS_PALO; h++){
			for(int k = 0; k < MazoSpider.CANT_PILAS_FOUNDATION / MazoSpider.DOS_PALO; k++){
				for(int i = j; i < j+13 && j < 104 && noError; i++){
					if (cartas.get(i).getPalo() != Carta.Palo.values()[h] || cartas.get(i).getValor() != valorEsperado){
						noError = false;
					}
					valorEsperado++;
				}
				valorEsperado = 1;
				j+=13;
			}
		}

		//assert
		assertTrue(noError);
	}

	@Test
	public void inicializarConCuatroPalo() {
		//arrange
		MazoSpider m = new MazoSpider();
		List<Carta> cartas;
		boolean noError = true;
		int j = 0;
		int valorEsperado = 1;

		//act
		m.inicializar(MazoSpider.CUATRO_PALO);
		cartas = new ArrayList<>(m.getMazo());

		for(int h = 0; h < MazoSpider.CUATRO_PALO; h++){
			for(int k = 0; k < MazoSpider.CANT_PILAS_FOUNDATION / MazoSpider.CUATRO_PALO; k++){
				for(int i = j; i < j+13 && j < 104 && noError; i++){
					if (cartas.get(i).getPalo() != Carta.Palo.values()[h] || cartas.get(i).getValor() != valorEsperado){
						noError = false;
					}
					valorEsperado++;
				}
				valorEsperado = 1;
				j+=13;
			}
		}

		//assert
		assertTrue(noError);
	}

	@Test
	public void repartir() {
		//arrange
		MazoSpider m = new MazoSpider();
		List<PilaDeCartas> pilas;
		boolean noError = true;

		//act
		m.inicializar(MazoSpider.UN_PALO);
		m.mezclar(1);
		pilas = new ArrayList<>(m.repartir());

		for (PilaDeCartas pila : pilas) {
			if (pila.tamanio() != 6) {
				if (pila.tamanio() != 5) {
					if (pila.tamanio() != 50)
						noError = false;
				}
			}
		}

		//assert
		assertTrue(noError);
	}
}