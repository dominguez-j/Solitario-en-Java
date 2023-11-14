package Klondike;

import Solitario.*;
import UI.Vista.ResolucionConfigurable;

import java.io.Serializable;
import java.util.*;

public class Klondike extends Solitario implements Serializable, ResolucionConfigurable {

    private Waste waste;

    public Klondike(){
        this.mazo = new MazoKlondike();
        this.waste = new Waste();
    }

    @Override
    public void llenarJuego(){
        Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
        this.talon = new TalonKlondike(mazoDistribuido.removeLast(), waste);
        this.tableau = new Tableau(new LinkedList<>(mazoDistribuido.stream().map(x -> new PilaDeTableauKlondike(x)).toList()));
        Deque<PilaDeCartas> foundation = new LinkedList<>();
        for(Carta.Palo p : Carta.Palo.values())
            foundation.add(new PilaDeFoundationKlondike(p));
        this.foundation = new Foundation(foundation);
    }

    public void empezarJuego(TalonKlondike talon, Waste waste, Foundation foundation, Tableau tableau){
        this.talon = talon;
        this.waste = waste;
        this.foundation = foundation;
        this.tableau = tableau;
    }

    public Waste getWaste(){return this.waste;}

    @Override
    public int obtenerAncho(){
        return 700;
    }

    @Override
    public int obtenerAlto(){
        return 800;
    }
}
