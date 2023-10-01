package Solitario;

import java.util.*;

public class PilaDeCartas {

    private Deque<Carta> pila;

    /**
     * Determina si es posible apilar la copia en la pila de cartas.
     *
     * @param copiarAExtraer La pila de cartas que intento apilar.
     * @return true si es posible apilar, false si no es posible.
     */
    public boolean sePuedeApilar(PilaDeCartas copiarAExtraer){return false;}

    /**
     * Devuelve un deque de cartas removidas del deque original en base a la cantidad pasada por parámetro.
     *
     * @param cantidad La cantidad de cartas que se desea extraer del deque original.
     * @return Un deque que contiene las cartas removidas del deque original.
     */
    public Deque<Carta> extraerCartas(int cantidad){
        Deque<Carta> cartasExtraidas = new LinkedList<>();

        for(int i = 0; i < cantidad; i++)
            cartasExtraidas.add(this.popCarta());

        if(this.tamanio() > 0)
            this.getPrimera().setVisible();

        return cartasExtraidas;
    }

    /**
     * Devuelve una copia del deque de cartas en base a la cantidad pasada por parámetro.
     *
     * @param cantidad La cantidad de cartas que se desean copiar del deque original.
     * @return Una copia del deque que contiene las cartas copiadas, o null si falla.
     */
    public Deque<Carta> copiarCartas(int cantidad){
        if(cantidad > this.tamanio())
            return null;

        Deque<Carta> cartasCopiadas = new LinkedList<>();
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

    /**
     * Agrega el deque de cartas pasado al deque del objeto actual.
     *
     * @param Cartas El deque de cartas que se desea agregar al deque del objeto actual.
     */
    public void agregarCartas(Deque<Carta> Cartas){this.pila.addAll(Cartas);}

    public PilaDeCartas(){this.pila = new LinkedList<>();}

    public PilaDeCartas(Deque<Carta> pila){this.pila = pila;}

    public boolean estaVacia(){return this.pila.isEmpty();}

    public int tamanio(){return this.pila.size();}

    public Deque<Carta> getPila(){return this.pila;}

    public Carta getPrimera(){return this.pila.getFirst();}

    public Carta getUltima(){return this.pila.getLast();}

    public void pushCarta(Carta carta){this.pila.push(carta);}

    public Carta popCarta(){return this.pila.pop();}

    public void limpiarPila(){this.pila.clear();}
}