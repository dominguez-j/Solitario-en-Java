package Klondike;

import Solitario.*;

public class TalonKlondike extends PilaDeCartas {
    private Waste waste;

    public TalonKlondike(PilaDeCartas talon, Waste waste){
        super(talon.getPila());
        this.waste = waste;
    }

    public void rellenarTalon(){
        for(Carta c : waste.getPila()){
            c.setOculto(true);
            this.getPila().add(c);
        }
    }

    public void robarCarta(){
        if(this.estaVacia())
            rellenarTalon();
        this.waste.pushCarta(this.popCarta());
        this.waste.getPila().getLast().setOculto(false);
    }
}
