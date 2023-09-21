package Solitario;

import java.util.*;

public abstract class Mazo{

    public static final int CARTAS_POR_PALO = 13;
    protected Deque<Carta> mazo;
    protected List<PilaDeCartas> tableau;

    public Mazo(){
        this.mazo = new ArrayDeque<>();
        this.tableau = new ArrayList<>();
    }

    public abstract void inicializar();

    public void mezclar(){
        List<Carta> aux = new ArrayList<>(mazo);
        Collections.shuffle(aux, new Random(System.nanoTime()));
        mazo = new ArrayDeque<Carta>(mazo);
    }

    public Deque<Carta> getMazo(){
        return this.mazo;
    }

    public abstract List<PilaDeCartas> repartir();
}
