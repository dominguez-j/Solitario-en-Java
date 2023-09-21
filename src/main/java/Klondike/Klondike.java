package Klondike;

import Solitario.*;
import java.util.*;

public class Klondike extends Solitario {
    public static final int CANT_PILAS_TABLEAU = 7;
    private Waste waste;

    public Klondike(){
        this.mazo = new MazoKlondike();
        this.waste = new Waste();
    }

    @Override
    public void empezarJuego(){
        mazo.inicializar();
        mazo.mezclar();
        List<PilaDeCartas> mazoDistribuido = mazo.repartir();
        talon = new TalonKlondike(mazoDistribuido.remove(mazoDistribuido.size()-1), waste);
        tableau = new TableauKlondike(mazoDistribuido);
        List<PilaDeCartas> foundation = new ArrayList<>();
        for(Carta.Palo p : Carta.Palo.values())
            foundation.add(new PilaDeFoundationKlondike(p));
        this.foundation = new Foundation(foundation);
    }

    @Override
    public boolean movimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        if(cantidad == 0)
            return false;

        if(destino.sePuedeApilar(origen, cantidad)){
            destino.agregarCartas(origen.extraerCartas(cantidad));
            return true;
        }
        return false;
    }

}
