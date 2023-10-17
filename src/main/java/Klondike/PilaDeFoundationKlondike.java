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
    public boolean sePuedeApilar(PilaDeCartas copiaAExtraer) {
        if (noEsUnaCartaValida(copiaAExtraer))
            return false;

        if (this.estaVacia())
            return sePuedeApilarSobrePilaVacia(copiaAExtraer);

        return sePuedeApilarSobrePilaNoVacia(copiaAExtraer);
    }

    private boolean noEsUnaCartaValida(PilaDeCartas copiaAExtraer) {
        return copiaAExtraer == null || copiaAExtraer.getPila() == null || copiaAExtraer.tamanio() != 1;
    }

    private boolean sePuedeApilarSobrePilaVacia(PilaDeCartas copiaAExtraer) {
        boolean mismoPalo = paloDePila == copiaAExtraer.getPrimera().getPalo();
        boolean esAs = copiaAExtraer.getPrimera().getValor() == Carta.AS;
        return mismoPalo && esAs;
    }

    private boolean sePuedeApilarSobrePilaNoVacia(PilaDeCartas copiaAExtraer) {
        boolean mismoPalo = paloDePila == copiaAExtraer.getPrimera().getPalo();
        boolean esAntecesor = copiaAExtraer.getPrimera().esAntecesor(this.getPrimera());
        return mismoPalo && esAntecesor;
    }
}
