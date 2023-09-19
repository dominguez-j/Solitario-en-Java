package Solitario;

import java.util.List;

public interface Mazo {
    public static final int CARTAS_POR_PALO = 13;

    public void inicializar();

    public void mezclar();

    public Pila getMazo();

    public List<Pila> repartir();
}
