package Solitario;

import java.util.*;

public class Foundation {
    private List<Pila> foundation;

    public Foundation(List<Pila> foundation){
        this.foundation = foundation;
    }

    public boolean estaCompleto(){
        for(Pila p : foundation){
            if (p.tamanioPila() != Mazo.CARTAS_POR_PALO)
                return false;
        }
        return true;
    }

}
