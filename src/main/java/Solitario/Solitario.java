package Solitario;
public abstract class Solitario {
    protected Mazo mazo;
    protected PilaDeCartas talon;
    protected Foundation foundation;
    protected Tableau tableau;

    public abstract void empezarJuego(long semilla);

    public abstract void empezarJuego();

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

    public boolean ganarJuego(){return foundation.estaCompleto();}

    public PilaDeCartas getTalon(){return this.talon;}

    public Foundation getFoundation(){return this.foundation;}

    public Tableau getTableau(){return this.tableau;}
}
