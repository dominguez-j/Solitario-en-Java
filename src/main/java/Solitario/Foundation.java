package Solitario;

import java.util.*;

public class Foundation {
    private Deque<? extends PilaDeCartas> foundation;

    public Foundation(Deque<? extends PilaDeCartas> foundation){this.foundation = foundation;}

    public Deque<? extends PilaDeCartas> getPilasFoundation(){return this.foundation;}

    public boolean estaCompleto(){
        for(PilaDeCartas p : foundation){
            if (p.tamanio() != Mazo.CARTAS_POR_PALO)
                return false;
        }
        return true;
    }

}
