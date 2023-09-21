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
        List<Carta> cartas;
        boolean noError = true;
        int j = 0;
        int valorEsperado = 1;

        //act
        m.inicializar();
        cartas = new ArrayList<>(m.getMazo());

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
        Deque<Carta> aux;

        //act
        m.inicializar();
        aux = new ArrayDeque<>(m.getMazo());
        m.mezclar();

        //assert
        assertNotEquals(aux, m.getMazo());
    }

    @Test
    public void repartir() {
        //arrange
        Mazo m = new MazoKlondike();
        List<PilaDeCartas> pilas;
        boolean noError = true;

        //act
        m.inicializar();
        m.mezclar();
        pilas = new ArrayList<>(m.repartir());

        for(int i = 0; i < pilas.size(); i++){
            if(pilas.get(i).tamanio() != i+1){
                if(pilas.get(i).tamanio() != 24)
                    noError = false;
            }
        }

        //assert
        assertTrue(noError);
    }
}