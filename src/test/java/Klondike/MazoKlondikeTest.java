package Klondike;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import Solitario.*;

public class MazoKlondikeTest {

    @Test
    public void inicializar() {
        //arrange
        Mazo m = new MazoKlondike();
        List<Carta> cartas = new Stack<>();
        boolean noError = true;
        int j = 0;
        int valorEsperado = 1;

        //act
        m.inicializar();
        cartas = m.getMazo().getPila();


        for(Carta.Palo p : Carta.Palo.values()){
            for(int i = j; i < j+13 && j < 52 && noError; i++){
                if (cartas.get(i).getPalo() != p || cartas.get(i).getValor() != valorEsperado){
                    noError = false;
                }
                valorEsperado++;
            }
            valorEsperado = 1;
            j+=13;
        }

        //assert
        assertTrue(noError);
    }

    @Test
    public void mezclar() {
        //arrange
        Mazo m = new MazoKlondike();
        List<Carta> aux = new Stack<>();

        //act
        m.inicializar();
        aux.addAll(m.getMazo().getPila());
        m.mezclar();

        //assert
        assertNotEquals(aux, m.getMazo().getPila());
    }

    @Test
    public void repartir() {
        //arrange
        Mazo m = new MazoKlondike();
        List<Pila> pilas = new ArrayList<>();
        boolean noError = true;

        //act
        m.inicializar();
        m.mezclar();
        pilas = m.repartir();

        for(int i = 0; i < pilas.size(); i++){
            if(pilas.get(i).tamanioPila() != i+1){
                if(pilas.get(i).tamanioPila() != 24)
                    noError = false;
            }
        }

        //assert
        assertTrue(noError);
    }
}