package Klondike;

import Solitario.*;
import java.util.*;

public class MazoKlondike extends Mazo {

    public MazoKlondike(){
        super();
    }

    @Override
    public void inicializar() {
        for(Carta.Palo p : Carta.Palo.values()){
            for(int i = 1; i <= Mazo.CARTAS_POR_PALO; i++)
                this.mazo.add(new Carta(i, p));
        }
    }

    @Override
    public List<PilaDeCartas> repartir() {
        PilaDeCartas aux = new PilaDeCartas();

        for(int i = Klondike.CANT_PILAS_TABLEAU -1; i >= 0; i--) {
            for(int j = 0; j < Klondike.CANT_PILAS_TABLEAU -i; j++){
                aux.pushCarta(this.mazo.remove());
            }
            aux.getPila().getLast().setOculto(false);
            this.tableau.add(aux);
            aux = new PilaDeCartas();
        }
        tableau.add(new PilaDeCartas(this.mazo));
        return tableau;
    }
}
