package Solitario;

import org.junit.Test;
import static org.junit.Assert.*;

public class CartaTest {

    @Test
    public void valor() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);

        //assert
        assertEquals(5, carta.getValor());
    }

    @Test
    public void palo() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);

        //assert
        assertEquals(Carta.Palo.CORAZON, carta.getPalo());
    }

    @Test
    public void esAntecesorDevuelveTrue() {
        //arrange
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.CORAZON);

        //assert
        assertTrue(carta1.esAntecesor(carta2));
    }

    @Test
    public void esAntecesorDevuelveFalse() {
        //arrange
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(6, Carta.Palo.CORAZON);

        //assert
        assertFalse(carta1.esAntecesor(carta2));
    }

    @Test
    public void esColorOpuestoDevuelveTrue() {
        //arrange
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(6, Carta.Palo.TREBOL);

        //assert
        assertTrue(carta1.esColorOpuesto(carta2));
    }

    @Test
    public void esColorOpuestoDevuelveFalse() {
        //arrange
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(6, Carta.Palo.CORAZON);

        //assert
        assertFalse(carta1.esColorOpuesto(carta2));
    }
    @Test
    public void estaOcultaDevuelveTrue() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);

        //assert
        assertTrue(carta.estaOculta());
    }

    @Test
    public void setVisible() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);

        //act
        carta.setVisible();

        //assert
        assertFalse(carta.estaOculta());
    }

    @Test
    public void esMismoPaloDevuelveTrue() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.CORAZON);

        //assert
        assertSame(carta.getPalo(), carta2.getPalo());
    }

    @Test
    public void esMismoPaloDevuelveFalse() {
        //arrange
        Carta carta = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.TREBOL);

        //assert
        assertNotSame(carta.getPalo(), carta2.getPalo());
    }
}