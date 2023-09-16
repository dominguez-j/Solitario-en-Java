import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.junit.Assert.*;

public class MazoKlondikeTest {

    @Test
    public void inicializar() {
        //arrange
        Mazo m = new MazoKlondike();

        //act
        m.inicializar();

        //assert
    }

    @Test
    public void mezclar() {
        //arrange
        Mazo m = new MazoKlondike();
        List<Carta> aux = new Stack<>();

        //act
        m.inicializar();
        aux = m.getMazo();
        m.mezclar();

        //assert
        assertNotEquals(aux, m.getMazo());//Falla
    }

    @Test
    public void repartir() {
        //arrange
        Mazo m = new MazoKlondike();

        //act

        //assert
    }
}