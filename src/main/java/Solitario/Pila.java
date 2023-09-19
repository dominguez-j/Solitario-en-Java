package Solitario;

import java.util.*;

public abstract class Pila {

    protected Stack<Carta> pila;

    public boolean sePuedeApilar(Pila origen){
        return false;
    }

    public abstract boolean mover(Pila origen);

    public Pila(){
        this.pila = new Stack<>();
    }

    public Pila(Stack<Carta> pila){
        this.pila = pila;
    }

    public boolean estaVacia(){
        return pila.empty();
    }

    public int tamanioPila(){
        return pila.size();
    }

    public void setPila(Stack<Carta> pila){
        this.pila = pila;
    }

    public Stack<Carta> getPila(){
        return this.pila;
    }


    /*public List<Carta> copiarMovimiento(int indice){
        ArrayList<Carta> copia = new ArrayList<>();
        for(int i = 0; i <= indice; i++)
            copia.add(pila.pop());
        return copia;
    }

    public boolean moverPila(Pila copia){
        return pila.removeAll(copia.getPila());
    }*/


    //Verificar cuando corresponde correr esto


}
