package Solitario;

import java.util.List;

public class Tableau{

    private List<PilaDeCartas> tableau;

    public Tableau(List<PilaDeCartas> tableau){
        this.tableau = tableau;
    }

    public List<PilaDeCartas> getTableau(){
        return this.tableau;
    }
}
