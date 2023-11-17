package Solitario;

import java.io.Serializable;
import java.util.*;

public abstract class Mazo implements Serializable {

    public static final int CARTAS_POR_PALO = 13;
    protected Deque<Carta> mazo;

    public Mazo(){this.mazo = new LinkedList<>();}

    public abstract void inicializar(int cant_palos);

    public void mezclar(long semilla){
        List<Carta> aux = new ArrayList<>(mazo);
        Collections.shuffle(aux, new Random(semilla));
        mazo = new LinkedList<>(aux);
    }

    public Deque<Carta> getMazo(){return this.mazo;}

    public abstract Deque<PilaDeCartas> repartir();
}
