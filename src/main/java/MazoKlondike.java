import java.util.*;

public class MazoKlondike implements Mazo{

    private Stack<Carta> mazo;

    private List<Stack<Carta>> tableau;

    public MazoKlondike(){
        this.mazo = new Stack<>();
        this.tableau = new ArrayList<>();
    }

    @Override
    public List<Carta> getMazo(){
        return this.mazo;
    }

    @Override
    public void inicializar() {
        for(Carta.Palo p : Carta.Palo.values()){
            for(int i = 1; i <= CARTAS_POR_PALO; i++)
                mazo.push(new Carta(i, p));
        }
    }

    @Override
    public void mezclar() {
        Collections.shuffle(mazo, new Random(System.nanoTime()));
    }

    @Override
    public List<Stack<Carta>> repartir() {
        Stack<Carta> aux = new Stack<>();

        for(int i = Klondike.CANT_PILAS_TABLEAU -1; i >= 0; i--) {
            for(int j = 0; j < Klondike.CANT_PILAS_TABLEAU -i; j++){
                aux.push(mazo.pop());
            }
            tableau.add(aux);
            aux.clear();
        }
        tableau.add(mazo);
        return tableau;
    }
}
