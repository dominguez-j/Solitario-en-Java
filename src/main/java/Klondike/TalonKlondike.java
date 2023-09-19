package Klondike;

import Solitario.*;

public class TalonKlondike extends Pila{
    public TalonKlondike(Pila talon){
        super(talon.getPila());
    }

    @Override
    public boolean mover(Pila origen){
        return true;
    }
}
