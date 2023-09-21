package Solitario;

import java.util.*;

public class PilaDeCartas {

    private Deque<Carta> pila;

    public boolean sePuedeApilar(PilaDeCartas origen, int cantidad){return false;}

    public List<Carta> extraerCartas(int cantidad){
        List<Carta> cartasExtraidas = new ArrayList<>();

        for(int i=0; i < cantidad; i++)
            cartasExtraidas.add(this.popCarta());

        return cartasExtraidas;
    }

    public void agregarCartas(List<Carta> Cartas){
        this.pila.addAll(Cartas);
    }

    public PilaDeCartas(){this.pila = new ArrayDeque<>();}

    public PilaDeCartas(Deque<Carta> pila){this.pila = pila;}

    public boolean estaVacia(){return this.pila.isEmpty();}

    public int tamanio(){return this.pila.size();}

    public void setPila(Deque<Carta> pila){this.pila = pila;}

    public Deque<Carta> getPila(){return this.pila;}

    public Carta getPrimera(){return this.pila.peek();}

    public Carta getUltima(){return this.pila.getLast();}

    public void pushCarta(Carta carta){this.pila.push(carta);}

    public Carta popCarta(){return this.pila.pop();}
}
