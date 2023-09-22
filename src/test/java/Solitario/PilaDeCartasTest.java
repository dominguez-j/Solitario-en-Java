package Solitario;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class PilaDeCartasTest {

    @Test
    public void extraerCartas() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        pila.pushCarta(new Carta(5, Carta.Palo.CORAZON));
        pila.pushCarta(new Carta(4, Carta.Palo.TREBOL));
        pila.pushCarta(new Carta(3, Carta.Palo.DIAMANTE));
        pila.pushCarta(new Carta(2, Carta.Palo.TREBOL));
        pila.pushCarta(new Carta(1, Carta.Palo.DIAMANTE));

        // act
        Deque<Carta> cartasExtraidas = pila.extraerCartas(3);

        // assert
        assertEquals(3, cartasExtraidas.size());
        assertEquals(2, pila.tamanio());
    }

    @Test
    public void extraerCartasVaciaPila() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        pila.pushCarta(new Carta(5, Carta.Palo.CORAZON));
        pila.pushCarta(new Carta(4, Carta.Palo.TREBOL));
        pila.pushCarta(new Carta(3, Carta.Palo.DIAMANTE));
        pila.pushCarta(new Carta(2, Carta.Palo.TREBOL));
        pila.pushCarta(new Carta(1, Carta.Palo.DIAMANTE));

        // act
        Deque<Carta> cartasExtraidas = pila.extraerCartas(5);

        // assert
        assertTrue(pila.estaVacia());
        assertEquals(5, cartasExtraidas.size());
    }

    @Test
    public void copiarCartas() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        pila.pushCarta(new Carta(5, Carta.Palo.CORAZON));
        pila.getPrimera().setVisible();
        pila.pushCarta(new Carta(4, Carta.Palo.TREBOL));
        pila.getPrimera().setVisible();


        // act
        Deque<Carta> cartasCopiadas = pila.copiarCartas(2);

        // assert
        assertEquals(2, cartasCopiadas.size());
    }

    @Test
    public void agregarCartasRespetaCantidad() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        Deque<Carta> cartas = new ArrayDeque<>();
        cartas.add(new Carta(4, Carta.Palo.CORAZON));
        cartas.add(new Carta(5, Carta.Palo.TREBOL));

        // act
        pila.agregarCartas(cartas);

        // assert
        assertEquals(2, pila.tamanio());
    }

    @Test
    public void agregarCartasRespetaOrden() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        Deque<Carta> cartas = new ArrayDeque<>();
        cartas.add(new Carta(4, Carta.Palo.CORAZON));
        cartas.add(new Carta(5, Carta.Palo.TREBOL));

        // act
        pila.agregarCartas(cartas);
        cartas.add(new Carta(4, Carta.Palo.CORAZON));
        cartas.add(new Carta(5, Carta.Palo.TREBOL));

        // assert
        assertEquals(pila.getPrimera().getValor(), cartas.getFirst().getValor());
    }

    @Test
    public void estaVacia() {
        // arrange
        PilaDeCartas pilaVacia = new PilaDeCartas();
        PilaDeCartas pilaConCarta = new PilaDeCartas();
        pilaConCarta.pushCarta(new Carta(5, Carta.Palo.CORAZON));

        // assert
        assertTrue(pilaVacia.estaVacia());
        assertFalse(pilaConCarta.estaVacia());
    }

    @Test
    public void tamanio() {
        // arrange
        PilaDeCartas pila = new PilaDeCartas();
        pila.pushCarta(new Carta(5, Carta.Palo.CORAZON));
        pila.pushCarta(new Carta(4, Carta.Palo.TREBOL));

        // assert
        assertEquals(2, pila.tamanio());
    }
}
