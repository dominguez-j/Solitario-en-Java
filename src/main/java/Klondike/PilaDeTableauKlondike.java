package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){super();}

    public PilaDeTableauKlondike(PilaDeCartas tableau){super(tableau.getPila());}

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer){
        if(copiarAExtraer.getPila() == null) return false;

        boolean estaVacia = copiarAExtraer.estaVacia();
        if(estaVacia) return false;

        boolean estoyVacia = this.estaVacia();
        if(estoyVacia){
            boolean esK = copiarAExtraer.getUltima().getValor() == Carta.K;
            return esK;
        }

        boolean esColorOpuesto = (this.getPrimera().esColorOpuesto(copiarAExtraer.getUltima()));
        boolean esAntecesor = (this.getPrimera().esAntecesor(copiarAExtraer.getUltima()));
        return (esColorOpuesto && esAntecesor);
    }
}
