package Klondike;

import Solitario.*;
import java.util.*;

public class PilaDeFoundationKlondike extends PilaDeCartas {
    private final Carta.Palo paloDePila;

    public PilaDeFoundationKlondike(Carta.Palo paloDePila) {
        super();
        this.paloDePila = paloDePila;
    }

    public PilaDeFoundationKlondike(Carta.Palo paloDePila, PilaDeCartas foundation) {
        super(foundation.getPila());
        this.paloDePila = paloDePila;
    }

    @Override
    public Deque<Carta> copiarCartas(int cantidad) {
        if (cantidad != 1) return null;

        Deque<Carta> cartasCopiadas = new LinkedList<>();
        cartasCopiadas.add(this.getPrimera());

        return cartasCopiadas;
    }

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer) {
        if (noEsUnaCartaValida(copiarAExtraer))
            return false;

        if (this.estaVacia())
            return sePuedeApilarSobrePilaVacia(copiarAExtraer);
        else
            return sePuedeApilarSobrePilaNoVacia(copiarAExtraer);
    }

    private boolean noEsUnaCartaValida(PilaDeCartas copiarAExtraer) {
        return copiarAExtraer == null || copiarAExtraer.tamanio() != 1;
    }

    private boolean sePuedeApilarSobrePilaVacia(PilaDeCartas copiarAExtraer) {
        return copiarAExtraer.getPrimera().getValor() == Carta.AS;
    }

    private boolean sePuedeApilarSobrePilaNoVacia(PilaDeCartas copiarAExtraer) {
        boolean mismoPalo = paloDePila == copiarAExtraer.getPrimera().getPalo();
        boolean esAntecesor = copiarAExtraer.getPrimera().esAntecesor(this.getPrimera());
        return mismoPalo && esAntecesor;
    }
}
