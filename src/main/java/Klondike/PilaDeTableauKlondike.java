package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){
        super();
    }

    public PilaDeTableauKlondike(PilaDeCartas tableau){
        super(tableau.getPila());
    }

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer){
        boolean ultimaOculta = copiarAExtraer.getUltima().estaOculta();
        if(ultimaOculta)
            return false;

        boolean estoyVacia = this.estaVacia();
        if(estoyVacia){
            boolean esK = copiarAExtraer.getUltima().getValor() == Carta.K;
            return esK;
        }

        boolean mismoPalo = (this.getPrimera().esMismoPalo(copiarAExtraer.getUltima()));
        boolean esAntecesor = (this.getPrimera().esAntecesor(copiarAExtraer.getUltima()));
        return (!mismoPalo && esAntecesor);
    }
}
