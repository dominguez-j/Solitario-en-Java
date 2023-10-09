package Spider;

import Solitario.Carta;
import Solitario.PilaDeCartas;
import org.junit.Test;

import static org.junit.Assert.*;

public class TalonSpiderTest {
	@Test
	public void robarCarta() {
		//arrange
		Spider s = new Spider();
		s.empezarJuego(MazoSpider.UN_PALO);
		TalonSpider t = (TalonSpider) s.getTalon();

		//act
		t.robarCarta(s.getTableau());

		//assert
	}
}