package Solitario;

import java.util.*;

public abstract class Mazo{

    public static final int CARTAS_POR_PALO = 13;
    protected Deque<Carta> mazo;
    protected Deque<PilaDeCartas> mazoDistribuido;

    public Mazo(){
        this.mazo = new ArrayDeque<>();
        this.mazoDistribuido = new ArrayDeque<>();
    }

    public abstract void inicializar();

    public void mezclar(){
        List<Carta> aux = new ArrayList<>(mazo);
        Collections.shuffle(aux, new Random(System.nanoTime()));
        mazo = new ArrayDeque<>(aux);
    }

    public Deque<Carta> getMazo(){
        return this.mazo;
    }

    public abstract Deque<PilaDeCartas> repartir();
}
