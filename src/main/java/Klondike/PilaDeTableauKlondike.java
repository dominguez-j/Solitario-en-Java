package Klondike;

import Solitario.*;

public class PilaDeTableauKlondike extends PilaDeCartas {
    public PilaDeTableauKlondike(){super();}

    public PilaDeTableauKlondike(PilaDeCartas tableau){super(tableau.getPila());}

    @Override
    public boolean sePuedeApilar(PilaDeCartas copiaAExtraer) {
        if (noEsUnaPilaValida(copiaAExtraer))
            return false;

        if (this.estaVacia())
            return sePuedeApilarSobreVacia(copiaAExtraer);

        return sePuedeApilarSobreNoVacia(copiaAExtraer);
    }

    private boolean noEsUnaPilaValida(PilaDeCartas copiaAExtraer) {
        return copiaAExtraer == null || copiaAExtraer.getPila() == null ||copiaAExtraer.estaVacia();
    }

    private boolean sePuedeApilarSobreVacia(PilaDeCartas copiaAExtraer) {
        boolean esK = copiaAExtraer.getUltima().getValor() == Carta.K;
        boolean estaOculta = copiaAExtraer.getUltima().estaOculta();
        return esK && !estaOculta;
    }

    private boolean sePuedeApilarSobreNoVacia(PilaDeCartas copiaAExtraer) {
        boolean esColorOpuesto = this.getPrimera().esColorOpuesto(copiaAExtraer.getUltima());
        boolean esAntecesor = this.getPrimera().esAntecesor(copiaAExtraer.getUltima());
        return esColorOpuesto && esAntecesor;
    }
}
