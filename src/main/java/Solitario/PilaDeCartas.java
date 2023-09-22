package Solitario;

import java.util.*;

public class PilaDeCartas {

    private Deque<Carta> pila;

    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer){return false;}

    public Deque<Carta> extraerCartas(int cantidad){
        Deque<Carta> cartasExtraidas = new ArrayDeque<>();

        for(int i=0; i < cantidad; i++)
            cartasExtraidas.add(this.popCarta());

        if(this.tamanio() > 0)
            this.getPrimera().setVisible();

        return cartasExtraidas;
    }

    public Deque<Carta> copiarCartas(int cantidad){
        Deque<Carta> cartasCopiadas = new ArrayDeque<>();
        boolean error = false;
        Iterator<Carta> iterador = this.pila.iterator();
        int i = 0;

        while(i < cantidad && iterador.hasNext() && !error){
            Carta c = iterador.next();
            if(c.estaOculta())
                error = true;
            else
                cartasCopiadas.add(c);
            i++;
        }

        return !error ? cartasCopiadas : null;
    }

    public void agregarCartas(Deque<Carta> Cartas){
        for(int i = 0; i <= Cartas.size(); i++){
            this.pila.push(Cartas.pollLast());
        }
    }

    public PilaDeCartas(){this.pila = new ArrayDeque<>();}

    public PilaDeCartas(Deque<Carta> pila){this.pila = pila;}

    public boolean estaVacia(){return this.pila.isEmpty();}

    public int tamanio(){return this.pila.size();}

    public Deque<Carta> getPila(){return this.pila;}

    public Carta getPrimera(){return this.pila.getFirst();}

    public Carta getUltima(){return this.pila.getLast();}

    public void pushCarta(Carta carta){this.pila.push(carta);}

    public Carta popCarta(){return this.pila.pop();}
}
