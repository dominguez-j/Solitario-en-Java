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
    public void empezarJuego(long semilla){
        mazo.inicializar();
        mazo.mezclar(semilla);
        llenarJuego();
    }

    @Override
    public void empezarJuego(){
        mazo.inicializar();
        mazo.mezclar(System.currentTimeMillis());
        llenarJuego();
    }

    private void llenarJuego(){
        Deque<PilaDeCartas> mazoDistribuido = mazo.repartir();
        talon = new TalonKlondike(mazoDistribuido.removeLast(), waste);
        tableau = new Tableau(mazoDistribuido);
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

    @Override
    public boolean esMovimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        if(cantidad <= 0)
            return false;

        PilaDeCartas copiaAExtraer = new PilaDeCartas(origen.copiarCartas(cantidad));
        return destino.sePuedeApilar(copiaAExtraer);
    }

    public Waste getWaste(){return this.waste;}
}
