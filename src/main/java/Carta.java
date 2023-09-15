public class Carta {
    public enum Palo {DIAMANTE, TREBOL, CORAZON, PICA};
    private final int valor;
    private final Palo palo;
    private boolean oculto;

    public Carta(int valor, Palo palo){
        this.valor = valor;
        this.palo = palo;
        this.oculto = true;
    }

    public int getValor(){return this.valor;}

    public Palo getPalo(){return this.palo;}

    public boolean estaOculto(){return this.oculto;}

    public void setOculto(boolean oculto){this.oculto = oculto;}

    public boolean esAntecesor(Carta carta){
        return (carta.getValor() == (this.valor -1));
    }

    //Esto debe ser propio de Klondike
    public boolean esColorOpuesto(Carta carta){
        if(this.palo == Palo.TREBOL || this.palo == Palo.PICA)
            return (carta.getPalo() == Palo.CORAZON || carta.getPalo() == Palo.DIAMANTE);
        else
            return (carta.getPalo() == Palo.TREBOL || carta.getPalo() == Palo.PICA);
    }

    //Esto debe ser propio de Klondike
    public boolean sePuedeApilar(Carta carta){
        return (esColorOpuesto(carta) && esAntecesor(carta));
    }
}
