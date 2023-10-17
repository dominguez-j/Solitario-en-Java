package Spider;

import Solitario.*;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class SpiderTest {
	public static final int SEED = 42;

	@Test
	public void empezarJuegoDesdeSemillaCreaTodo() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO, SEED);

		//assert
		assertNotNull(s.getTalon());
		assertNotNull(s.getTableau());
		assertNotNull(s.getFoundation());
	}

	@Test
	public void empezarJuegoDesdeSemillaAleatoriaCreaTodo() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO);

		//assert
		assertNotNull(s.getTalon());
		assertNotNull(s.getTableau());
		assertNotNull(s.getFoundation());
	}

	@Test
	public void moverUnaCartaDeTableauNoEsPosiblePorNumero() {
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();


		//act
		p1.pushCarta(new Carta(2,Carta.Palo.DIAMANTE));
		p2.pushCarta(new Carta(7,Carta.Palo.DIAMANTE));

		p1.getPrimera().setVisible();
		p2.getPrimera().setVisible();

		//assert
		assertFalse(s.esMovimientoValido(p1, p2, 1));
	}

	@Test
	public void moverCartaDeTableauAOtraDeDistintoPaloEsValido() {
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();

		//act
		p1.pushCarta(new Carta(2,Carta.Palo.DIAMANTE));
		p2.pushCarta(new Carta(3,Carta.Palo.TREBOL));

		p1.getPrimera().setVisible();
		p2.getPrimera().setVisible();

		//assert
		assertTrue(s.esMovimientoValido(p1, p2, 1));
	}

	@Test
	public void moverCartaDeTableauAOtraDeDistintoPaloNoEsValido() {
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();
		
		p1.pushCarta(new Carta(2,Carta.Palo.DIAMANTE));
		p2.pushCarta(new Carta(5,Carta.Palo.TREBOL));

		p1.getPrimera().setVisible();
		p2.getPrimera().setVisible();
		//assert
		assertFalse(s.esMovimientoValido(p1, p2, 1));
	}

	@Test
	public void moverVariasCartasDeTableauNoEsPosiblePorPalo(){
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();

		//act
		p1.pushCarta(new Carta(4,Carta.Palo.DIAMANTE));
		p1.getPrimera().setVisible();
		p1.pushCarta(new Carta(3,Carta.Palo.TREBOL));
		p1.getPrimera().setVisible();
		p1.pushCarta(new Carta(2,Carta.Palo.DIAMANTE));
		p2.pushCarta(new Carta(5,Carta.Palo.DIAMANTE));

		p1.getPrimera().setVisible();
		p2.getPrimera().setVisible();
		//assert
		assertFalse(s.esMovimientoValido(p1, p2, 3));
	}

	@Test
	public void moverVariasCartasDeTableauNoEsPosiblePorCartaOculta(){
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();

		//act
		p1.pushCarta(new Carta(4,Carta.Palo.DIAMANTE));
		p1.pushCarta(new Carta(3,Carta.Palo.DIAMANTE));
		p1.pushCarta(new Carta(2,Carta.Palo.DIAMANTE));
		p2.pushCarta(new Carta(5,Carta.Palo.DIAMANTE));

		p1.getPrimera().setVisible();
		p2.getPrimera().setVisible();

		//assert
		assertFalse(s.esMovimientoValido(p1, p2, 3));
	}

	@Test
	public void moverVariasCartasLlevaPilaAlFoundation(){
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();
		PilaDeTableauSpider p2 = new PilaDeTableauSpider();

		for (int i = MazoSpider.CARTAS_POR_PALO; i > 0 ; i--) {
			Carta ci = new Carta(i, Carta.Palo.DIAMANTE);
			ci.setVisible();
			if (i > 3){
				p1.pushCarta(ci);
			}
			p2.pushCarta(ci);
		}
		TalonSpider talon = new TalonSpider(new PilaDeCartas());
		Deque<PilaDeCartas> tableau = new LinkedList<>();
		tableau.add(p1);
		tableau.add(p2);
		Tableau tableauSpider = new Tableau(tableau);
		Deque<PilaDeCartas> foundation = new LinkedList<>();
		foundation.add(new PilaDeCartas());
		Foundation foundationSpider = new Foundation(foundation);
		s.empezarJuego(talon, foundationSpider, tableauSpider);

		//act
		s.moverCartas(p2, p1, 3);

		//assert
		assertTrue(s.getFoundation().estaCompleto());
	}

	@Test
	public void robarCartasLlevaPilaAlFoundation(){
		//arrange
		Spider s = new Spider();
		PilaDeTableauSpider p1 = new PilaDeTableauSpider();

		for (int i = MazoSpider.CARTAS_POR_PALO; i > 1 ; i--) {
			Carta ci = new Carta(i, Carta.Palo.DIAMANTE);
			ci.setVisible();
			p1.pushCarta(ci);
		}

		PilaDeCartas talon = new PilaDeCartas();
		Carta c1 = new Carta(Carta.AS, Carta.Palo.DIAMANTE);
		talon.pushCarta(c1);

		TalonSpider talonSpider = new TalonSpider(talon);

		Deque<PilaDeCartas> tableau = new LinkedList<>();
		tableau.add(p1);
		Tableau tableauSpider = new Tableau(tableau);

		Deque<PilaDeCartas> foundation = new LinkedList<>();
		foundation.add(new PilaDeCartas());
		Foundation foundationSpider = new Foundation(foundation);

		s.empezarJuego(talonSpider, foundationSpider, tableauSpider);

		//act
		talonSpider.robarCarta(s.getTableau(), s.getFoundation());

		//assert
		assertTrue(s.verificarVictoria());
	}

	@Test
	public void ganarPartidaCompleta(){
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO, SEED);

		//act
		TalonSpider t = new TalonSpider(s.getTalon());

		LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(s.getTableau().getPilasDeTableau());
		PilaDeTableauSpider c1 = new PilaDeTableauSpider(pilas_tableau.get(0));
		PilaDeTableauSpider c2 = new PilaDeTableauSpider(pilas_tableau.get(1));
		PilaDeTableauSpider c3 = new PilaDeTableauSpider(pilas_tableau.get(2));
		PilaDeTableauSpider c4 = new PilaDeTableauSpider(pilas_tableau.get(3));
		PilaDeTableauSpider c5 = new PilaDeTableauSpider(pilas_tableau.get(4));
		PilaDeTableauSpider c6 = new PilaDeTableauSpider(pilas_tableau.get(5));
		PilaDeTableauSpider c7 = new PilaDeTableauSpider(pilas_tableau.get(6));
		PilaDeTableauSpider c8 = new PilaDeTableauSpider(pilas_tableau.get(7));
		PilaDeTableauSpider c9 = new PilaDeTableauSpider(pilas_tableau.get(8));
		PilaDeTableauSpider c10 = new PilaDeTableauSpider(pilas_tableau.get(9));

		s.moverCartas(c6, c8, 1);
		s.moverCartas(c8, c1, 2);
		s.moverCartas(c7, c6, 1);
		s.moverCartas(c8, c6, 1);
		s.moverCartas(c8, c7, 1);
		s.moverCartas(c7, c8, 2);
		s.moverCartas(c5, c10, 1);
		s.moverCartas(c1, c5, 3);
		s.moverCartas(c1, c5, 1);
		s.moverCartas(c1, c2, 1);
		s.moverCartas(c2, c5, 2);
		s.moverCartas(c1, c4, 1);
		s.moverCartas(c1, c10, 1);
		s.moverCartas(c5, c10, 7);
		s.moverCartas(c6, c10, 3);
		s.moverCartas(c8, c5, 3);
		s.moverCartas(c4, c2, 2);
		s.moverCartas(c2, c5, 3);
		t.robarCarta(s.getTableau(), s.getFoundation());
		s.moverCartas(c4, c3, 1);
		s.moverCartas(c3, c4, 2);
		s.moverCartas(c4, c8, 3);
		s.moverCartas(c4, c5, 1);
		s.moverCartas(c3, c5, 1);
		s.moverCartas(c7, c1, 1);
		s.moverCartas(c2, c5, 1);
		s.moverCartas(c2, c1, 1);
		s.moverCartas(c6, c3, 1);
		s.moverCartas(c3, c6, 2);
		s.moverCartas(c3, c8, 1);
		s.moverCartas(c5, c3, 4);
		s.moverCartas(c3, c5, 3);
		s.moverCartas(c5, c8, 8);
		s.moverCartas(c5, c6, 1);
		s.moverCartas(c6, c4, 4);
		s.moverCartas(c1, c4, 3);
		s.moverCartas(c3, c4, 2);
		s.moverCartas(c9, c6, 1);
		s.moverCartas(c6, c4, 2);
		s.moverCartas(c3, c1, 1);
		t.robarCarta(s.getTableau(), s.getFoundation());
		s.moverCartas(c5, c9, 2);
		s.moverCartas(c5, c9, 1);
		s.moverCartas(c2, c3, 1);
		s.moverCartas(c10, c2, 1);
		s.moverCartas(c4, c10, 1);
		s.moverCartas(c2, c9, 2);
		s.moverCartas(c6, c8, 1);
		s.moverCartas(c7, c6, 1);
		s.moverCartas(c3, c2, 2);
		s.moverCartas(c3, c1, 1);
		s.moverCartas(c4, c3, 12);
		s.moverCartas(c7, c6, 1);
		s.moverCartas(c9, c1, 6);
		s.moverCartas(c4, c10, 1);
		s.moverCartas(c10, c4, 3);
		s.moverCartas(c4, c7, 4);
		s.moverCartas(c7, c8, 4);
		s.moverCartas(c9, c4, 1);
		s.moverCartas(c9, c8, 1);
		s.moverCartas(c5, c8, 1);
		s.moverCartas(c1, c5, 8);
		s.moverCartas(c4, c1, 1);
		s.moverCartas(c7, c4, 1);
		s.moverCartas(c9, c7, 1);
		s.moverCartas(c7, c9, 2);
		t.robarCarta(s.getTableau(), s.getFoundation());
		s.moverCartas(c1, c5, 1);
		s.moverCartas(c1, c3, 3);
		s.moverCartas(c3, c1, 4);
		s.moverCartas(c7, c3, 1);
		s.moverCartas(c1, c8, 3);
		s.moverCartas(c5, c9, 2);
		s.moverCartas(c4, c3, 1);
		s.moverCartas(c4, c3, 1);
		s.moverCartas(c2, c4, 1);
		s.moverCartas(c2, c1, 3);
		s.moverCartas(c2, c4, 1);
		s.moverCartas(c1, c5, 4);
		s.moverCartas(c6, c2, 1);
		s.moverCartas(c6, c2, 3);
		s.moverCartas(c8, c7, 12);
		s.moverCartas(c9, c8, 3);
		s.moverCartas(c8, c3, 3);
		s.moverCartas(c4, c10, 2);
		s.moverCartas(c9, c6, 3);
		s.moverCartas(c2, c9, 4);
		s.moverCartas(c10, c4, 3);
		s.moverCartas(c10, c3, 1);
		t.robarCarta(s.getTableau(), s.getFoundation());
		s.moverCartas(c7, c5, 1);
		s.moverCartas(c4, c7, 1);
		s.moverCartas(c8, c9, 1);
		s.moverCartas(c9, c8, 2);
		s.moverCartas(c6, c7, 1);
		s.moverCartas(c8, c7, 3);
		s.moverCartas(c6, c7, 2);
		s.moverCartas(c5, c7, 1);
		s.moverCartas(c9, c7, 5);
		s.moverCartas(c4, c3, 3);
		s.moverCartas(c3, c4, 4);
		s.moverCartas(c6, c1, 1);
		s.moverCartas(c2, c1, 1);
		s.moverCartas(c10, c9, 1);
		s.moverCartas(c10, c8, 1);
		s.moverCartas(c8, c10, 1);
		s.moverCartas(c10, c8, 2);
		s.moverCartas(c10, c1, 1);
		t.robarCarta(s.getTableau(), s.getFoundation());
		s.moverCartas(c6, c9, 1);
		s.moverCartas(c7, c6, 1);
		s.moverCartas(c5, c7, 1);
		s.moverCartas(c2, c3, 1);
		s.moverCartas(c4, c5, 1);
		s.moverCartas(c8, c1, 1);
		s.moverCartas(c4, c3, 4);
		s.moverCartas(c10, c3, 1);
		s.moverCartas(c1, c5, 1);
		s.moverCartas(c1, c8, 1);
		s.moverCartas(c9, c1, 2);
		s.moverCartas(c6, c9, 1);
		s.moverCartas(c5, c8, 2);
		s.moverCartas(c1, c9, 6);
		s.moverCartas(c8, c9, 5);

		//assert
		assertTrue(s.verificarVictoria());
	}
}