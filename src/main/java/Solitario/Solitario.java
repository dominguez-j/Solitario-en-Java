package Solitario;

import Vista.ResolucionConfigurable;

import java.io.*;

public abstract class Solitario implements ResolucionConfigurable {

    protected Mazo mazo;
    protected PilaDeCartas talon;
    protected Foundation foundation;
    protected Tableau tableau;

    public void empezarJuego(int cant_palos, long semilla){
        mazo.inicializar(cant_palos);
        mazo.mezclar(semilla);
        llenarJuego();
    }

    public void empezarJuego(int cant_palos){
        mazo.inicializar(cant_palos);
        mazo.mezclar(System.currentTimeMillis());
        llenarJuego();
    }

    public abstract void llenarJuego();

    /**
     * Determina si un movimiento es válido.
     *
     * @param origen   La pila de cartas desde la que se intenta mover.
     * @param destino  La pila de cartas a la que se intenta mover.
     * @param cantidad La cantidad de cartas que se intentan mover.
     * @return true si el movimiento es válido, false en caso contrario.
     */
    public boolean esMovimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        if(cantidad <= 0)
            return false;

        PilaDeCartas copiaAExtraer = new PilaDeCartas(origen.copiarCartas(cantidad));
        return destino.sePuedeApilar(copiaAExtraer);
    }

    /**
     * Mueve las cartas de una pila a otra.
     *
     * @param origen   La pila de cartas desde la que se intenta mover.
     * @param destino  La pila de cartas a la que se intenta mover.
     * @param cantidad La cantidad de cartas que se intentan mover.
     */
    public void moverCartas(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        destino.agregarCartas(origen.extraerCartas(cantidad));
    }

    public boolean verificarVictoria(){return foundation.estaCompleto();}

    public PilaDeCartas getTalon(){return this.talon;}

    public Foundation getFoundation(){return this.foundation;}

    public Tableau getTableau(){return this.tableau;}

    public void guardarPartida(OutputStream os) throws IOException {
        try (ObjectOutputStream solitario = new ObjectOutputStream(os)) {
            solitario.writeObject(this);
        }
    }

    public Solitario cargarPartida(InputStream is) throws IOException, ClassNotFoundException {
        try (ObjectInputStream solitario = new ObjectInputStream(is)) {
            return (Solitario) solitario.readObject();
        }
    }
}
