package Solitario;
public abstract class Solitario {
    protected Mazo mazo;
    protected PilaDeCartas talon;
    protected Foundation foundation;
    protected Tableau tableau;

    public abstract void empezarJuego(int semilla);

    public abstract boolean esMovimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad);

    public void moverCartas(PilaDeCartas origen, PilaDeCartas destino, int cantidad){
        destino.agregarCartas(origen.extraerCartas(cantidad));
    }

    public boolean ganarJuego(){return foundation.estaCompleto();}

    public PilaDeCartas getTalon(){return this.talon;}

    public Foundation getFoundation(){return this.foundation;}

    public Tableau getTableau(){return this.tableau;}
}
