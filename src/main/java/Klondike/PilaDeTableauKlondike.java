package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){super();}

    public PilaDeTableauKlondike(PilaDeCartas tableau){super(tableau.getPila());}

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiaAExtraer) {
        if (copiaAExtraer == null || copiaAExtraer.estaVacia())
            return false;

        if (this.estaVacia())
            return sePuedeApilarSobreVacia(copiaAExtraer);

        return sePuedeApilarSobreNoVacia(copiaAExtraer);
    }

    private boolean sePuedeApilarSobreVacia(PilaDeCartas copiaAExtraer) {
        return copiaAExtraer.getUltima().getValor() == Carta.K;
    }

    private boolean sePuedeApilarSobreNoVacia(PilaDeCartas copiarAExtraer) {
        boolean esColorOpuesto = this.getPrimera().esColorOpuesto(copiarAExtraer.getUltima());
        boolean esAntecesor = this.getPrimera().esAntecesor(copiarAExtraer.getUltima());
        return esColorOpuesto && esAntecesor;
    }
}
