package Klondike;

import Solitario.*;

import java.util.ArrayDeque;
import java.util.Deque;

public class TalonKlondike extends PilaDeCartas {
    private Waste waste;

    public TalonKlondike(PilaDeCartas talon, Waste waste){
        super(talon.getPila());
        this.waste = waste;
    }

    public void rellenarTalon(){
        for(Carta c : this.waste.getPila()){
            c.setOculta();
            this.pushCarta(c);
        }
        this.waste.limpiarPila();
    }

    @Override
    public Deque<Carta> copiarCartas(int cantidad){
        if (cantidad != 1) {
            return null;
        }

        Deque<Carta> cartasCopiadas = new ArrayDeque<>();
        cartasCopiadas.add(this.getPrimera());

        return cartasCopiadas;
    }

    public void robarCarta(){
        if(this.estaVacia()){
            rellenarTalon();
            return;
        }
        this.waste.pushCarta(this.popCarta());
        this.waste.getPrimera().setVisible();
    }
}
