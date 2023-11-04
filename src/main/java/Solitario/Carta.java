package Solitario;

import javafx.scene.image.Image;

public class Carta {

    public enum Palo {DIAMANTE, TREBOL, CORAZON, PICA}

	public static final int AS = 1;
    public static final int K = 13;
    private final int valor;
    private final Palo palo;
    private boolean oculta;
    private final Image frente;
    private final Image dorso;

    public Carta(int valor, Palo palo){
        this.valor = valor;
        this.palo = palo;
        this.oculta = true;
        this.frente = new Image(getFrente(palo.name(), valor));
        this.dorso = new Image(getDorso());
    }

    public int getValor(){return this.valor;}

    public Palo getPalo(){return this.palo;}

    public boolean estaOculta(){return this.oculta;}

    public void setVisible(){this.oculta = false;}

    public void setOculta(){this.oculta = true;}

    public boolean esAntecesor(Carta carta){return (carta.getValor() == (this.valor -1));}

    public boolean esColorOpuesto(Carta carta){
        if(this.palo == Palo.TREBOL || this.palo == Palo.PICA)
            return (carta.getPalo() == Palo.CORAZON || carta.getPalo() == Palo.DIAMANTE);
        else
            return (carta.getPalo() == Palo.TREBOL || carta.getPalo() == Palo.PICA);
    }

    public boolean esMismoPalo(Carta carta){return this.getPalo() == carta.getPalo();}

    public Image getobtenerImagenSegunEstado(){
        return estaOculta() ? this.dorso : this.frente;
    }

    private String getFrente(String tipo, int valor){
        return Carta.class.getResource("/Cartas/" + tipo + " " + valor + ".png").getFile();
    }

    private String getDorso(){
        return Carta.class.getResource("/Cartas/DORSO.png").getFile();
    }
}
