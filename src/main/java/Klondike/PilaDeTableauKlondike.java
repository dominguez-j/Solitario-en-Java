package Klondike;

import Solitario.*;
import java.util.*;

public class PilaDeTableauKlondike extends Pila {
    public PilaDeTableauKlondike(){
        super();
    }

    public PilaDeTableauKlondike(Stack<Carta> tableau){
        super(tableau);
    }

    public void descubrirCarta(){
        if (pila.peek().estaOculta())
            pila.peek().setOculto(false);
    }

    @Override
    public boolean sePuedeApilar(Pila origen){
        boolean ultimaOculta = origen.getPila().lastElement().estaOculta();

        if(ultimaOculta)
            return false;

        boolean estoyVacia = pila.empty();

        if(estoyVacia){
            boolean esK = (origen.getPila().lastElement().getValor() == 13);
            return esK;
        }

        boolean distintoPalo = (pila.peek().getPalo() != origen.getPila().lastElement().getPalo());
        boolean esAntecesor = (pila.peek().esAntecesor(origen.getPila().lastElement()));

        return (distintoPalo && esAntecesor);
    }

    @Override
    public boolean mover(Pila origen){
        return true;
    }
}
