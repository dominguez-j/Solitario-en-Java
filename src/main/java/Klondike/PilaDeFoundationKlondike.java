package Klondike;

import Solitario.*;
import java.util.*;

public class PilaDeFoundationKlondike extends PilaDeCartas {
  private final Carta.Palo paloDePila;

  public PilaDeFoundationKlondike(Carta.Palo paloDePila) {
    super();
    this.paloDePila = paloDePila;
  }

  public PilaDeFoundationKlondike(Carta.Palo paloDePila, PilaDeCartas foundation) {
    super(foundation.getPila());
    this.paloDePila = paloDePila;
  }

  @Override
  public Deque<Carta> copiarCartas(int cantidad) {
    if (cantidad != 1) return null;

    Deque<Carta> cartasCopiadas = new LinkedList<>();
    cartasCopiadas.add(this.getPrimera());

    return cartasCopiadas;
  }

  @Override
  public boolean sePuedeApilar(PilaDeCartas copiarAExtraer) {
    boolean esUnaCarta = (copiarAExtraer.tamanio() == 1);
    boolean mismoPalo = (this.paloDePila == copiarAExtraer.getPrimera().getPalo());
    if (!esUnaCarta || !mismoPalo) return false;

    boolean estoyVacia = this.estaVacia();
    boolean esAs = (copiarAExtraer.getPrimera().getValor() == Carta.AS);

    if (estoyVacia) {
      return esAs;
    }

    boolean esAntecesor = (this.getPrimera().esAntecesor(copiarAExtraer.getPrimera()));
    return esAntecesor;
  }
}
