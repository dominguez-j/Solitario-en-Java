package Klondike;

import Solitario.*;

import java.io.Serializable;
import java.util.Deque;
import java.util.LinkedList;

public class Waste extends PilaDeCartas implements Serializable {

    public Waste(){super();}

    @Override
    public Deque<Carta> copiarCartas(int cantidad){
        if(cantidad != 1) return null;

        Deque<Carta> cartasCopiadas = new LinkedList<>();
        cartasCopiadas.add(this.getPrimera());

        return cartasCopiadas;
    }
}
