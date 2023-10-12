package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){super();}

    public PilaDeTableauKlondike(PilaDeCartas tableau){super(tableau.getPila());}

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer) {
        if (copiarAExtraer == null || copiarAExtraer.estaVacia())
            return false;

        if (this.estaVacia())
            return sePuedeApilarSobreVacia(copiarAExtraer);

        return sePuedeApilarSobreNoVacia(copiarAExtraer);
    }

    private boolean sePuedeApilarSobreVacia(PilaDeCartas copiarAExtraer) {
        return copiarAExtraer.getUltima().getValor() == Carta.K;
    }

    private boolean sePuedeApilarSobreNoVacia(PilaDeCartas copiarAExtraer) {
        boolean esColorOpuesto = this.getPrimera().esColorOpuesto(copiarAExtraer.getUltima());
        boolean esAntecesor = this.getPrimera().esAntecesor(copiarAExtraer.getUltima());
        return esColorOpuesto && esAntecesor;
    }
}
