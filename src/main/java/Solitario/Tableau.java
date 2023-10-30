package Solitario;

import java.util.*;

public class Tableau {

    private final Deque<? extends PilaDeCartas> tableau;

    public Tableau(Deque<? extends PilaDeCartas> tableau){this.tableau = tableau;}

    public Deque<? extends PilaDeCartas> getPilasDeTableau(){return this.tableau;}

}
