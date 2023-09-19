package Klondike;

import Solitario.*;
import java.util.*;

public class Klondike extends Solitario {
    public static final int CANT_PILAS_TABLEAU = 7;
    private Waste waste;

    @Override
    public void empezarJuego(){
        this.mazo = new MazoKlondike();
        mazo.inicializar();
        mazo.mezclar();

        List<Pila> mazoDistribuido = mazo.repartir();
        talon = new TalonKlondike(mazoDistribuido.remove(mazoDistribuido.size()-1));
        tableau = new TableauKlondike(mazoDistribuido);

        waste = new Waste();
        /*foundation = new ArrayList<Pila>();
        for(Carta.Palo p : Carta.Palo.values())
            foundation.add(new PilaDeFoundationKlondike(p));*/
    }

    @Override
    public boolean movimiento(Pila origen, Pila destino){
        return destino.sePuedeApilar(origen) ? destino.mover(origen) : false;
    }

}
