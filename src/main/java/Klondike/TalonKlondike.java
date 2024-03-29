package Klondike;

import Solitario.*;

public class TalonKlondike extends PilaDeCartas {

    private final Waste waste;

    public TalonKlondike(PilaDeCartas talon, Waste waste){
        super(talon.getPila());
        this.waste = waste;
    }

    /**
     * Transfiere las cartas del waste al talon.
     * Todas las cartas se ocultan antes de transferirlas al talon.
     */
    public void rellenarTalon(){
        for(Carta c : this.waste.getPila()){
            c.setOculta();
            this.pushCarta(c);
        }
        this.waste.limpiarPila();
    }

    /**
     * Roba una carta del talon y la coloca en el waste.
     * Si el talon está vacío, se rellena automáticamente llamando a rellenarTalon().
     */
    public void robarCarta(){
        if(this.estaVacia()){
            rellenarTalon();
            return;
        }
        this.waste.pushCarta(this.popCarta());
        this.waste.getPrimera().setVisible();
    }
}
