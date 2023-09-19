package Klondike;

import Solitario.*;
import java.util.*;

public class MazoKlondike implements Mazo {

    private Pila mazo;
    private List<Pila> tableau;

    public MazoKlondike(){
        this.mazo = new PilaDeTableauKlondike();
        this.tableau = new ArrayList<>();
    }

    @Override
    public Pila getMazo(){
        return this.mazo;
    }

    @Override
    public void inicializar() {
        for(Carta.Palo p : Carta.Palo.values()){
            for(int i = 1; i <= Mazo.CARTAS_POR_PALO; i++)
                mazo.getPila().push(new Carta(i, p));
        }
    }

    @Override
    public void mezclar() {
        Collections.shuffle(mazo.getPila(), new Random(System.nanoTime()));
    }

    @Override
    public List<Pila> repartir() {
        Stack<Carta> aux = new Stack<>();

        for(int i = Klondike.CANT_PILAS_TABLEAU -1; i >= 0; i--) {
            for(int j = 0; j < Klondike.CANT_PILAS_TABLEAU -i; j++){
                aux.push(mazo.getPila().pop());
            }
            tableau.add(new PilaDeTableauKlondike(aux));
            aux = new Stack<>();
        }
        tableau.add(mazo);
        return tableau;
    }
}
