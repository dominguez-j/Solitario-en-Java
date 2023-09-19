package Solitario;

import java.util.*;

public abstract class Solitario {
    protected Mazo mazo;
    protected Pila talon;
    protected Foundation foundation;
    protected Tableau tableau;
    public abstract void empezarJuego();
    public abstract boolean movimiento(Pila origen, Pila destino);

    public boolean ganarJuego(){
        return foundation.estaCompleto();
    }
}
