package Solitario;

import java.util.*;

public class Foundation {
    private final List<PilaDeCartas> foundation;

    public Foundation(List<PilaDeCartas> foundation){
        this.foundation = foundation;
    }

    public boolean estaCompleto(){
        for(PilaDeCartas p : foundation){
            if (p.tamanio() != Mazo.CARTAS_POR_PALO)
                return false;
        }
        return true;
    }

}
