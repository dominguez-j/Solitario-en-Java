package Klondike;

import Solitario.*;

public class PilaDeFoundationKlondike extends Pila {
    private final Carta.Palo paloDePila;
    public PilaDeFoundationKlondike(Carta.Palo paloDePila){
        super();
        this.paloDePila = paloDePila;
    }

    @Override
    public boolean sePuedeApilar(Pila origen){
        boolean esUnaCarta = (origen.tamanioPila() == 1);
        boolean mismoPalo = (paloDePila == origen.getPila().peek().getPalo());

        if(!esUnaCarta && !mismoPalo)
            return false;

        boolean esAntecesor = (pila.peek().esAntecesor(origen.getPila().peek()));

        if(esAntecesor)
            return true;

        boolean estoyVacia = pila.empty();
        boolean esAs = (origen.getPila().peek().getValor() == 1);

        return (estoyVacia && esAs);
    }

    @Override
    public boolean mover(Pila origen){
        return true;
    }
}
