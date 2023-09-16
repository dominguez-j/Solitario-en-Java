import java.util.List;
import java.util.Stack;

public interface Mazo {
    public static final int CARTAS_POR_PALO = 13;

    public void inicializar();

    public void mezclar();

    public List<Carta> getMazo();

    public List<Stack<Carta>> repartir();
}
