package Klondike;

import Solitario.*;

public class PilaDeFoundationKlondike extends PilaDeCartas {
    private final Carta.Palo paloDePila;

    public PilaDeFoundationKlondike(Carta.Palo paloDePila){
        super();
        this.paloDePila = paloDePila;
    }

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer){
        boolean esUnaCarta = (copiarAExtraer.tamanio() == 1);
        boolean mismoPalo = (paloDePila == copiarAExtraer.getPrimera().getPalo());
        if(!esUnaCarta && !mismoPalo)
            return false;

        boolean estoyVacia = this.estaVacia();
        boolean esAs = (copiarAExtraer.getPrimera().getValor() == Carta.AS);
        if(estoyVacia && esAs)
            return true;

        boolean esAntecesor = (this.getPrimera().esAntecesor(copiarAExtraer.getPrimera()));
        return esAntecesor;
    }
}
