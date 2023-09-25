package Klondike;

import Solitario.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TalonKlondikeTest {

    @Test
    public void rellenarTalon() {
        //arrange
        PilaDeCartas talon = new PilaDeCartas();
        Waste waste = new Waste();
        TalonKlondike talonKlondike = new TalonKlondike(talon, waste);

        //act
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.TREBOL);
        Carta carta3 = new Carta(7, Carta.Palo.DIAMANTE);

        carta1.setVisible();
        carta2.setVisible();
        carta3.setVisible();

        waste.pushCarta(carta1);
        waste.pushCarta(carta2);
        waste.pushCarta(carta3);

        talonKlondike.rellenarTalon();

        //assert
        assertFalse(talonKlondike.estaVacia());
        assertEquals(3, talonKlondike.tamanio());
        assertTrue(talonKlondike.getPrimera().estaOculta());
    }

    @Test
    public void rellenarTalonCambiaAOcultaTodasLasCartas() {
        //arrange
        PilaDeCartas talon = new PilaDeCartas();
        Waste waste = new Waste();
        TalonKlondike talonKlondike = new TalonKlondike(talon, waste);

        //act
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.TREBOL);
        Carta carta3 = new Carta(7, Carta.Palo.DIAMANTE);
        Carta carta4 = new Carta(10, Carta.Palo.TREBOL);
        Carta carta5 = new Carta(4, Carta.Palo.DIAMANTE);
        Carta carta6 = new Carta(7, Carta.Palo.CORAZON);

        carta1.setVisible();
        carta2.setVisible();
        carta3.setVisible();
        carta4.setVisible();
        carta5.setVisible();
        carta6.setVisible();

        waste.pushCarta(carta1);
        waste.pushCarta(carta2);
        waste.pushCarta(carta3);
        waste.pushCarta(carta4);
        waste.pushCarta(carta5);
        waste.pushCarta(carta6);

        talonKlondike.rellenarTalon();

        //assert
        boolean todoOculto = true;
        for(Carta c : talonKlondike.getPila()){
            if(!c.estaOculta())
                todoOculto = false;
        }

        assertTrue(todoOculto);
    }

    @Test
    public void robarCarta() {
        //arrange
        PilaDeCartas talon = new PilaDeCartas();
        Waste waste = new Waste();
        TalonKlondike talonKlondike = new TalonKlondike(talon, waste);

        //act
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.TREBOL);

        talon.pushCarta(carta1);
        talon.pushCarta(carta2);

        talonKlondike.robarCarta();

        //assert
        assertFalse(talonKlondike.estaVacia());
        assertEquals(1, talonKlondike.tamanio());
        assertFalse(waste.estaVacia());
        assertEquals(waste.getPrimera().getValor(), carta2.getValor());
    }

    @Test
    public void robarCartaConTalonVacioRellenaTalon() {
        //arrange
        PilaDeCartas talon = new PilaDeCartas();
        Waste waste = new Waste();
        TalonKlondike talonKlondike = new TalonKlondike(talon, waste);

        //act
        Carta carta1 = new Carta(5, Carta.Palo.CORAZON);
        Carta carta2 = new Carta(4, Carta.Palo.TREBOL);

        waste.pushCarta(carta1);
        waste.pushCarta(carta2);

        talonKlondike.robarCarta();

        //assert
        assertFalse(talonKlondike.estaVacia());
        assertEquals(2, talonKlondike.tamanio());
        assertTrue(waste.estaVacia());
    }
}

