package Klondike;

import Solitario.*;
import java.util.*;

public class MazoKlondike extends Mazo {

    public final int CANT_PILAS_TABLEAU = 7;

    public MazoKlondike(){super();}

    @Override
    public void inicializar(int cant_palos) {
        for(Carta.Palo p : Carta.Palo.values()){
            for(int i = 1; i <= Mazo.CARTAS_POR_PALO; i++)
                this.mazo.add(new Carta(i, p));
        }
    }

    @Override
    public Deque<PilaDeCartas> repartir() {
        PilaDeCartas aux = new PilaDeCartas();
        Deque<PilaDeCartas> mazoDistribuido = new LinkedList<>();

        for(int i = CANT_PILAS_TABLEAU -1; i >= 0; i--) {
            for(int j = 0; j < CANT_PILAS_TABLEAU -i; j++){
                aux.pushCarta(this.mazo.pop());
            }
            aux.getPrimera().setVisible();
            mazoDistribuido.add(aux);
            aux = new PilaDeCartas();
        }
        mazoDistribuido.add(new PilaDeCartas(this.mazo));
        return mazoDistribuido;
    }
}

