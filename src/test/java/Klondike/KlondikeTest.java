package Klondike;

import Solitario.*;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class KlondikeTest {
	public static final int SEED = 42;

	@Test
	public void empezarJuegoDesdeSemillaCreaTodo() {
		//arrange
		Klondike k = new Klondike();
		k.empezarJuego(SEED);


		//assert
		assertNotNull(k.getTalon());
		assertNotNull(k.getTableau());
		assertNotNull(k.getFoundation());
		assertNotNull(k.getWaste());
	}

	@Test
	public void empezarJuegoDesdeSemillaAleatoriaCreaTodo() {
		//arrange
		Klondike k = new Klondike();
		k.empezarJuego();


		//assert
		assertNotNull(k.getTalon());
		assertNotNull(k.getTableau());
		assertNotNull(k.getFoundation());
		assertNotNull(k.getWaste());
	}

	@Test
	public void moverUnaCartaDeWasteATableauNoEsValidoPorPalo() {
		//arrange
		Klondike k = new Klondike();

		Waste waste = new Waste();
		PilaDeTableauKlondike pilaTableau = new PilaDeTableauKlondike();
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);
		Carta carta_tableau = new Carta(8, Carta.Palo.CORAZON);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_tableau.setVisible();
		pilaTableau.pushCarta(carta_tableau);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilaTableau, 1));
	}

	@Test
	public void moverUnaCartaDeWasteATableauNoEsValidoPorNumero() {
		//arrange
		Klondike k = new Klondike();

		Waste waste = new Waste();
		PilaDeTableauKlondike pilaTableau = new PilaDeTableauKlondike();
		Carta carta_waste = new Carta(6, Carta.Palo.DIAMANTE);
		Carta carta_tableau = new Carta(8, Carta.Palo.TREBOL);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_tableau.setVisible();
		pilaTableau.pushCarta(carta_tableau);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilaTableau, 1));
	}

	@Test
	public void moverUnaCartaDeWasteATableauEsValido() {
		//arrange
		Klondike k = new Klondike();

		Waste waste = new Waste();
		PilaDeTableauKlondike pilaTableau = new PilaDeTableauKlondike();
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);
		Carta carta_tableau = new Carta(8, Carta.Palo.TREBOL);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_tableau.setVisible();
		pilaTableau.pushCarta(carta_tableau);

		//assert
		assertTrue(k.esMovimientoValido(waste, pilaTableau, 1));
	}

	@Test
	public void moverUnaCartaDeWasteATableauVacioNoEsValidoPorNumero() {
		//arrange
		Klondike k = new Klondike();

		Waste waste = new Waste();
		PilaDeTableauKlondike pilaTableau = new PilaDeTableauKlondike();
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilaTableau, 1));
	}

	@Test
	public void moverUnaCartaDeWasteATableauVacioEsValido() {
		//arrange
		Klondike k = new Klondike();

		Waste waste = new Waste();
		PilaDeTableauKlondike pilaTableau = new PilaDeTableauKlondike();
		Carta carta_waste = new Carta(13, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);

		//assert
		assertTrue(k.esMovimientoValido(waste, pilaTableau, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationEsValido() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);
		Carta carta_foundation = new Carta(6, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_foundation.setVisible();
		pilafoundation.pushCarta(carta_foundation);

		//assert
		assertTrue(k.esMovimientoValido(waste, pilafoundation, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationNoEsValidoPorNumero() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);
		Carta carta_foundation = new Carta(5, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_foundation.setVisible();
		pilafoundation.pushCarta(carta_foundation);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilafoundation, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationNoEsValidoPorPalo() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation1 = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);
		Carta carta_foundation1 = new Carta(6, Carta.Palo.TREBOL);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);
		carta_foundation1.setVisible();
		pilafoundation1.pushCarta(carta_foundation1);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilafoundation1, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationVacioNoEsValidoPorNumero() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_waste = new Carta(7, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilafoundation, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationVacioNoEsValidoPorPalo() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_waste = new Carta(1, Carta.Palo.TREBOL);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);

		//assert
		assertFalse(k.esMovimientoValido(waste, pilafoundation, 1));
	}

	@Test
	public void moverUnaCartaDeWasteAFoundationVacioEsValido() {
		//arrange
		Klondike k = new Klondike();
		Waste waste = new Waste();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_waste = new Carta(1, Carta.Palo.DIAMANTE);

		//act
		carta_waste.setVisible();
		waste.pushCarta(carta_waste);


		//assert
		assertTrue(k.esMovimientoValido(waste, pilafoundation, 1));
	}

	@Test
	public void moverUnaCartaDeFoundationATableauNoEsValidoPorPalo(){
		//arrange
		Klondike k = new Klondike();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_foundation = new Carta(1, Carta.Palo.DIAMANTE);
		PilaDeTableauKlondike pilatableau = new PilaDeTableauKlondike();
		Carta carte_tableau = new Carta(2, Carta.Palo.CORAZON);

		//act
		carta_foundation.setVisible();
		pilafoundation.pushCarta(carta_foundation);
		carte_tableau.setVisible();
		pilatableau.pushCarta(carte_tableau);

		//assert
		assertFalse(k.esMovimientoValido(pilafoundation, pilatableau, 1));
	}

	@Test
	public void moverUnaCartaDeFoundationATableauNoEsValidoPorNumero(){
		//arrange
		Klondike k = new Klondike();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_foundation = new Carta(1, Carta.Palo.DIAMANTE);
		PilaDeTableauKlondike pilatableau = new PilaDeTableauKlondike();
		Carta carte_tableau = new Carta(3, Carta.Palo.TREBOL);

		//act
		carta_foundation.setVisible();
		pilafoundation.pushCarta(carta_foundation);
		carte_tableau.setVisible();
		pilatableau.pushCarta(carte_tableau);

		//assert
		assertFalse(k.esMovimientoValido(pilafoundation, pilatableau, 1));
	}

	@Test
	public void moverUnaCartaDeFoundationATableauEsValido(){
		//arrange
		Klondike k = new Klondike();
		PilaDeFoundationKlondike pilafoundation = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		Carta carta_foundation = new Carta(1, Carta.Palo.DIAMANTE);
		PilaDeTableauKlondike pilatableau = new PilaDeTableauKlondike();
		Carta carte_tableau = new Carta(2, Carta.Palo.TREBOL);

		//act
		carta_foundation.setVisible();
		pilafoundation.pushCarta(carta_foundation);
		carte_tableau.setVisible();
		pilatableau.pushCarta(carte_tableau);

		//assert
		assertTrue(k.esMovimientoValido(pilafoundation, pilatableau, 1));
	}

	@Test
	public void moverUnaCartaDeTableauAFoundationVacioEsValido() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		Carta carta_tableau = new Carta(Carta.AS, Carta.Palo.TREBOL);
		carta_tableau.setVisible();
		//act
		c1.pushCarta(carta_tableau);
		//assert
		assertTrue(k.esMovimientoValido(c1, f, 1));
	}

	@Test
	public void moverUnaCartaDeTableauAFoundationNoEsValidoPorPalo() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		Carta carta_foundation = new Carta(Carta.AS, Carta.Palo.TREBOL);
		Carta carta_tableau = new Carta(2, Carta.Palo.DIAMANTE);
		carta_tableau.setVisible();
		carta_foundation.setVisible();
		//act
		f.pushCarta(carta_foundation);
		c1.pushCarta(carta_tableau);
		//assert
		assertFalse(k.esMovimientoValido(c1, f, 1));
	}

	@Test
	public void moverUnaCartaDeTableauAFoundationNoEsValidoPorNumero() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		Carta carta_foundation = new Carta(Carta.AS, Carta.Palo.TREBOL);
		Carta carta_tableau = new Carta(3, Carta.Palo.TREBOL);
		carta_tableau.setVisible();
		carta_foundation.setVisible();
		//act
		f.pushCarta(carta_foundation);
		c1.pushCarta(carta_tableau);
		//assert
		assertFalse(k.esMovimientoValido(c1, f, 1));
	}

	@Test
	public void moverVariasCartasDeTableauAFoundationVacioNoEsValido() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);

		for (int i =4; i >= 1; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c1.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c1.pushCarta(c);
			}

		}

		assertFalse(k.esMovimientoValido(c1, f, 3));
	}

	@Test
	public void moverVariasCartasDeTableauAFoundationNoEsValido() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		Carta carta_foundation = new Carta(Carta.AS, Carta.Palo.TREBOL);
		f.pushCarta(carta_foundation);

		for (int i =4; i >= 1; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c1.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c1.pushCarta(c);
			}
		}
		assertFalse(k.esMovimientoValido(c1, f, 3));
	}

	@Test
	public void moverVariasCartasDeTableauATableauEsValido() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeTableauKlondike c2 = new PilaDeTableauKlondike();


		for (int i =4; i >= 1; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c1.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c1.pushCarta(c);
			}
		}

		for (int i =9; i >= 5; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c2.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c2.pushCarta(c);
			}
		}

		assertTrue(k.esMovimientoValido(c1, c2, 4));
	}

	@Test
	public void moverVariasCartasDeTableauATableauNoEsValido() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeTableauKlondike c2 = new PilaDeTableauKlondike();


		for (int i =4; i >= 1; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c1.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c1.pushCarta(c);
			}
		}

		for (int i =9; i >= 5; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.CORAZON);
				c.setVisible();
				c2.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.PICA);
				c.setVisible();
				c2.pushCarta(c);
			}
		}

		assertFalse(k.esMovimientoValido(c1, c2, 4));
	}

	@Test
	public void moverVariasCartasDeTableauATableauNoEsValidoPorCartaOculta() {
		//arrange
		Klondike k = new Klondike();
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		PilaDeTableauKlondike c2 = new PilaDeTableauKlondike();

		//act
		for (int i =4; i >= 1; i--) {

			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				if (i==4) c.setOculta();
				c1.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c1.pushCarta(c);
			}
		}

		for (int i =9; i >= 5; i--) {
			if (i % 2 == 0) {
				Carta c = new Carta(i, Carta.Palo.TREBOL);
				c.setVisible();
				c2.pushCarta(c);
			}
			else {
				Carta c = new Carta(i, Carta.Palo.DIAMANTE);
				c.setVisible();
				c2.pushCarta(c);
			}
		}

		//assert
		assertFalse(k.esMovimientoValido(c1, c2, 4));
	}

	@Test
	public void ganarPartida() {
		//arrange
		Klondike k = new Klondike();
		MazoKlondike m = new MazoKlondike();
		m.inicializar();
		PilaDeFoundationKlondike CORAZON = new PilaDeFoundationKlondike(Carta.Palo.CORAZON);
		PilaDeFoundationKlondike TREBOL = new PilaDeFoundationKlondike(Carta.Palo.TREBOL);
		PilaDeFoundationKlondike DIAMANTE = new PilaDeFoundationKlondike(Carta.Palo.DIAMANTE);
		PilaDeFoundationKlondike PICA = new PilaDeFoundationKlondike(Carta.Palo.PICA);
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike();
		int i = 0;
		for(Carta c : m.getMazo()){
			if ((c.getValor() == 13) && (c.getPalo() == Carta.Palo.CORAZON)){
				c1.pushCarta(c);
				continue;
			}
			if (i < 13) { DIAMANTE.pushCarta(c);}
			if (i < 26 && i > 12) { TREBOL.pushCarta(c); }
			if (i < 38 && i > 25) { CORAZON.pushCarta(c); }
			if ( i > 37) { PICA.pushCarta(c); }
			i++;
		}
		LinkedList<PilaDeFoundationKlondike> array = new LinkedList<>();
		array.push(DIAMANTE);
		array.push(TREBOL);
		array.push(CORAZON);
		array.push(PICA);
		Foundation foundation = new Foundation(array);
		LinkedList<PilaDeTableauKlondike> a = new LinkedList<>();
		a.push(c1);
		Tableau t = new Tableau(a);
		Waste w = new Waste();
		PilaDeCartas p = new PilaDeCartas();
		TalonKlondike ta = new TalonKlondike(p, w);
		k.empezarJuego(ta, w, foundation, t);

		//act
		k.moverCartas(c1, CORAZON, 1);

		//assert
		assertTrue(k.ganarJuego());
	}

	@Test
	public void ganarPartidaCompleta() {
		//arrange
		Klondike k = new Klondike();
		k.empezarJuego(SEED);

		//act
		TalonKlondike t = (TalonKlondike) k.getTalon();

		LinkedList<PilaDeCartas> pilas_foundation = new LinkedList<>(k.getFoundation().getPilasFoundation());
		PilaDeFoundationKlondike CORAZON = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(0));
		PilaDeFoundationKlondike TREBOL = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(1));
		PilaDeFoundationKlondike DIAMANTE = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(2));
		PilaDeFoundationKlondike PICA = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(3));


		LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
		PilaDeTableauKlondike c1 = new PilaDeTableauKlondike(pilas_tableau.get(0));
		PilaDeTableauKlondike c2 = new PilaDeTableauKlondike(pilas_tableau.get(1));
		PilaDeTableauKlondike c3 = new PilaDeTableauKlondike(pilas_tableau.get(2));
		PilaDeTableauKlondike c4 = new PilaDeTableauKlondike(pilas_tableau.get(3));
		PilaDeTableauKlondike c5 = new PilaDeTableauKlondike(pilas_tableau.get(4));
		PilaDeTableauKlondike c6 = new PilaDeTableauKlondike(pilas_tableau.get(5));
		PilaDeTableauKlondike c7 = new PilaDeTableauKlondike(pilas_tableau.get(6));


		k.moverCartas(c5, TREBOL, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), c7, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), c4, 1);
		k.moverCartas(c3, c1, 1);
		k.moverCartas(c5, c6, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c2, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), c4, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(c3, c2, 1);
		k.moverCartas(c3, c4, 1);
		k.moverCartas(c4, c3, 4);
		k.moverCartas(c4, c3, 1);
		k.moverCartas(c5, c4, 1);
		k.moverCartas(c7, c3, 2);
		k.moverCartas(c7, DIAMANTE, 1);
		k.moverCartas(c1, DIAMANTE, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c2, 1);
		k.moverCartas(c4, c2, 2);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c3, 1);
		k.moverCartas(c5, c3, 1);
		k.moverCartas(c5, c3, 1);
		k.moverCartas(c1, c3, 1);
		k.moverCartas(c7, c1, 1);
		k.moverCartas(k.getWaste(), c5, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), CORAZON, 1);
		k.moverCartas(c6, CORAZON, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c1, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), c5, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c1, 1);
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c1, 1);
		k.moverCartas(c2, c1, 6);
		k.moverCartas(c2, PICA, 1);
		k.moverCartas(c7, PICA, 1);
		k.moverCartas(c6, PICA, 1);
		k.moverCartas(c7, CORAZON, 1);
		k.moverCartas(c6, c5, 1);
		k.moverCartas(c6, TREBOL, 1);
		k.moverCartas(c3, TREBOL, 1);
		k.moverCartas(c1, TREBOL, 1);
		k.moverCartas(c6, c5, 1);
		k.moverCartas(c6, c4, 1);
		k.moverCartas(c6, DIAMANTE, 1);
		k.moverCartas(c3, DIAMANTE, 1);
		k.moverCartas(c1, DIAMANTE, 1);
		k.moverCartas(c3, TREBOL, 1);
		k.moverCartas(c3, DIAMANTE, 1);
		k.moverCartas(k.getWaste(), c3, 1);
		k.moverCartas(k.getWaste(), TREBOL, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), c4, 1);
		k.moverCartas(c3, c4, 1);
		k.moverCartas(c3, TREBOL, 1);
		k.moverCartas(k.getWaste(), TREBOL, 1);
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c5, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), CORAZON, 1);
		t.robarCarta();
		t.robarCarta();
		k.moverCartas(k.getWaste(), c2, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), DIAMANTE, 1);
		k.moverCartas(c3, DIAMANTE, 1);
		k.moverCartas(c5, DIAMANTE, 1);
		k.moverCartas(k.getWaste(), DIAMANTE, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), CORAZON, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), PICA, 1);
		t.robarCarta();
		k.moverCartas(k.getWaste(), PICA, 1);
		k.moverCartas(c1, PICA, 1);
		k.moverCartas(c4, CORAZON, 1);
		k.moverCartas(c1, CORAZON, 1);
		k.moverCartas(c4, PICA, 1);
		k.moverCartas(c1, PICA, 1);
		k.moverCartas(c3, PICA, 1);
		k.moverCartas(c4, CORAZON, 1);
		k.moverCartas(c1, CORAZON, 1);
		k.moverCartas(c3, CORAZON, 1);
		k.moverCartas(c4, TREBOL, 1);
		k.moverCartas(c5, TREBOL, 1);
		k.moverCartas(c3, TREBOL, 1);
		k.moverCartas(c1, PICA, 1);
		k.moverCartas(c5, DIAMANTE, 1);
		k.moverCartas(c7, DIAMANTE, 1);
		k.moverCartas(c7, PICA, 1);
		k.moverCartas(c1, CORAZON, 1);
		k.moverCartas(c3, CORAZON, 1);
		k.moverCartas(c1, PICA, 1);
		k.moverCartas(c2, PICA, 1);
		k.moverCartas(c1, DIAMANTE, 1);
		k.moverCartas(c5, TREBOL, 1);
		k.moverCartas(c3, TREBOL, 1);
		k.moverCartas(c5, CORAZON, 1);

		//assert
		assertTrue(k.ganarJuego());
	}
}