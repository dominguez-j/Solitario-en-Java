package Spider;

import org.junit.Test;
import static org.junit.Assert.*;

public class TalonSpiderTest {
	@Test
	public void robarCartaDisminuyeTamanioDeTalon() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO);
		TalonSpider t = new TalonSpider(s.getTalon());

		//act
		t.robarCarta(s.getTableau(), s.getFoundation());

		//assert
		assertEquals(t.tamanio(), 40);
	}

	@Test
	public void robarCartaAumentaTamanioDeTableau() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO);
		TalonSpider t = new TalonSpider(s.getTalon());
		PilaDeTableauSpider p = new PilaDeTableauSpider(s.getTableau().getPilasDeTableau().getFirst());

		//act
		t.robarCarta(s.getTableau(), s.getFoundation());

		//assert
		assertEquals(p.tamanio(), 7);
	}

	@Test
	public void robarCartaConTalonVacioNoHaceNada() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO);
		TalonSpider t = new TalonSpider(s.getTalon());
		for (int i = 0; i < 5; i++) {
			t.robarCarta(s.getTableau(), s.getFoundation());
		}
		PilaDeTableauSpider p = new PilaDeTableauSpider(s.getTableau().getPilasDeTableau().getFirst());

		//act
		t.robarCarta(s.getTableau(), s.getFoundation());

		//assert
		assertEquals(p.tamanio(), 11);
	}


}