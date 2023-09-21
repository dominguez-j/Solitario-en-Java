package Klondike;

import Solitario.*;

public class PilaDeFoundationKlondike extends PilaDeCartas {
    private final Carta.Palo paloDePila;

    public PilaDeFoundationKlondike(Carta.Palo paloDePila){
        super();
        this.paloDePila = paloDePila;
    }

    @Override
    public boolean sePuedeApilar(PilaDeCartas origen, int cantidad){
        boolean esUnaCarta = (origen.tamanio() == 1);
        boolean mismoPalo = (paloDePila == origen.getPrimera().getPalo());
        if(!esUnaCarta && !mismoPalo)
            return false;

        boolean esAntecesor = (this.getPrimera().esAntecesor(origen.getPrimera()));

        if(esAntecesor)
            return true;

        boolean estoyVacia = this.estaVacia();
        boolean esAs = (origen.getPrimera().getValor() == Carta.AS);
        return (estoyVacia && esAs);
    }
}
