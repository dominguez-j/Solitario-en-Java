package Klondike;

import Solitario.*;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class KlondikeTest {
    public static int SEED = 42;

    public void mostrarEstado(Klondike k){
        System.out.println("TALON");
        for(Carta c : k.getTalon().getPila()){
            System.out.println(c.getValor() +" "+ c.getPalo() +" "+ c.estaOculta());
        }
        System.out.println("----------------");
        System.out.println("WASTE");
        for(Carta c : k.getWaste().getPila()){
            System.out.println(c.getValor() +" "+ c.getPalo() +" "+ c.estaOculta());
        }
        System.out.println("----------------");
        System.out.println("TABLERO");
        int i = 1;
        for(PilaDeCartas p : k.getTableau().getPilasDeTableau()){
            System.out.println("C " + i);
            for(Carta c : p.getPila())
                System.out.println(c.getValor() +" "+ c.getPalo() +" "+ c.estaOculta());
            System.out.println("++++++++++++++");
            i++;
        }
        System.out.println("----------------");
        System.out.println("FOUNDATION");
        for(PilaDeCartas p : k.getFoundation().getPilasFoundation()){
            System.out.println("F "+ p);
            for(Carta c : p.getPila())
                System.out.println(c.getValor() +" "+ c.getPalo() +" "+ c.estaOculta());
            System.out.println("++++++++++++++");
        }
        System.out.println("----------------");
    }

    @Test
    public void empezarJuegoCreaTodo() {
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
    public void moverUnaCartaDeWasteATableauNoEsValido() {
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        TalonKlondike t = (TalonKlondike) k.getTalon();
        t.robarCarta();
        LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
        PilaDeTableauKlondike c6 = new PilaDeTableauKlondike(pilas_tableau.get(5));

        //assert
        assertTrue(k.esMovimientoValido(k.getWaste(), c6, 1));
    }

    @Test
    public void moverUnaCartaDeWasteATableauEsValido() {
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        TalonKlondike t = new TalonKlondike(k.getTalon(), k.getWaste());
        t.robarCarta();
        LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
        PilaDeTableauKlondike c7 = new PilaDeTableauKlondike(pilas_tableau.get(6));

        //assert
        assertTrue(k.esMovimientoValido(k.getWaste(), c7, 1));
    }

    @Test
    public void moverUnaCartaDeWasteAFoundationEsValido() {
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        TalonKlondike t = new TalonKlondike(k.getTalon(), k.getWaste());
        for (int i = 0; i < 24; i++) {
            t.robarCarta();
        }
        LinkedList<PilaDeCartas> pilas_foundation = new LinkedList<>(k.getFoundation().getPilasFoundation());
        PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(1));

        //assert
        assertTrue(k.esMovimientoValido(k.getWaste(), f, 1));
    }

    @Test
    public void moverUnaCartaDeTableauAFoundationVacioEsValido(){
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        LinkedList<PilaDeCartas> pilas_foundation = new LinkedList<>(k.getFoundation().getPilasFoundation());
        PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(1));

        LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
        PilaDeTableauKlondike c5 = new PilaDeTableauKlondike(pilas_tableau.get(4));

        //assert
        assertTrue(k.esMovimientoValido(c5, f, 1));
    }

    @Test
    public void moverUnaCartaDeTableauAFoundationNoEsValidoPorPalo(){
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        LinkedList<PilaDeCartas> pilas_foundation = new LinkedList<>(k.getFoundation().getPilasFoundation());
        PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.PICA, pilas_foundation.get(3));

        LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
        PilaDeTableauKlondike c5 = new PilaDeTableauKlondike(pilas_tableau.get(4));

        //assert
        assertFalse(k.esMovimientoValido(c5, f, 1));
    }

    @Test
    public void moverUnaCartaDeTableauAFoundationNoEsValidoPorNumero(){
        //arrange
        Klondike k = new Klondike();
        k.empezarJuego(SEED);

        //act
        LinkedList<PilaDeCartas> pilas_foundation = new LinkedList<>(k.getFoundation().getPilasFoundation());
        PilaDeFoundationKlondike f = new PilaDeFoundationKlondike(Carta.Palo.TREBOL, pilas_foundation.get(1));

        LinkedList<PilaDeCartas> pilas_tableau = new LinkedList<>(k.getTableau().getPilasDeTableau());
        PilaDeTableauKlondike c1 = new PilaDeTableauKlondike(pilas_tableau.get(0));

        //assert
        assertFalse(k.esMovimientoValido(c1, f, 1));
    }

    @Test
    public void moverVariasCartasDeTableauAFoundationVacioNoEsValido(){}

    @Test
    public void moverVariasCartasDeTableauAFoundationNoEsValido(){}

    @Test
    public void moverVariasCartasDeTableauATableauEsValido(){}

    @Test
    public void moverVariasCartasDeTableauATableauNoEsValido(){}


    @Test
    public void ganarPartidaCompleta(){
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