package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){
        super();
    }

    public PilaDeTableauKlondike(PilaDeCartas tableau){
        super(tableau.getPila());
    }

    public void descubrirCarta(){
        if (this.getPrimera().estaOculta())
            this.getPrimera().setOculto(false);
    }

    @Override
    public boolean sePuedeApilar(PilaDeCartas origen, int cantidad){
        if(origen.getUltima().estaOculta())
            return false;

        if(this.estaVacia())
            return origen.getUltima().getValor() == Carta.K;


        boolean mismoPalo = (this.getPrimera().esMismoPalo(origen.getUltima()));
        boolean esAntecesor = (this.getPrimera().esAntecesor(origen.getUltima()));

        return (!mismoPalo && esAntecesor);
    }
}
