package Spider;

import Klondike.Klondike;
import org.junit.Test;

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

}