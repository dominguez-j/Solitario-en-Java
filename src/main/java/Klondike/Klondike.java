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
        Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
        talon = new TalonKlondike(mazoDistribuido.removeLast(), waste);
        tableau = new TableauKlondike(mazoDistribuido);
        List<PilaDeCartas> foundation = new ArrayList<>();
        for(Carta.Palo p : Carta.Palo.values())
            foundation.add(new PilaDeFoundationKlondike(p));
        this.foundation = new Foundation(foundation);
    }

    @Override
    public boolean esMovimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        if(cantidad <= 0)
            return false;

        PilaDeCartas copiaAExtraer = new PilaDeCartas(origen.copiarCartas(cantidad));
        if(!copiaAExtraer.estaVacia())
            return destino.sePuedeApilar(copiaAExtraer);
        return false;
    }
}
