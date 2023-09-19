package Solitario;

import java.util.List;

public abstract class Tableau{

    private List<Pila> tableau;

    public Tableau(List<Pila> tableau){
        this.tableau = tableau;
    }
}
