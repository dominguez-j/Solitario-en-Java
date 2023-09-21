package Solitario;
public abstract class Solitario {
    protected Mazo mazo;
    protected PilaDeCartas talon;
    protected Foundation foundation;
    protected Tableau tableau;

    public abstract void empezarJuego();
    public abstract boolean movimientoValido(PilaDeCartas origen, PilaDeCartas destino, int cantidad);

    public boolean ganarJuego(){
        return foundation.estaCompleto();
    }
}
