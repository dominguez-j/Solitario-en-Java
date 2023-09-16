import java.util.*;

public class Klondike extends Solitario{
    public static final int CANT_PILAS_TABLEAU = 7;
    private Stack<Carta> talon;
    private Stack<Carta> descarte;
    private List<Stack<Carta>> foundation;
    private List<Stack<Carta>> tableau;

    public Klondike(){
        this.talon = new Stack<>();
        this.descarte = new Stack<>();
        this.foundation = new ArrayList<>();
        this.tableau = new ArrayList<>();
    }

    @Override
    public void empezarJuego(){
        this.mazo = new MazoKlondike();
        mazo.inicializar();
        mazo.mezclar();
        tableau = mazo.repartir();
        talon = (Stack<Carta>)tableau.remove(tableau.size()-1);
    }
}
