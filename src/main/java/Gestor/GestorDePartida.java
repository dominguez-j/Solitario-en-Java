package Gestor;

import java.io.*;
import Solitario.Solitario;

public class GestorDePartida implements Serializable {

	public GestorDePartida(){}

	public void guardarPartida(OutputStream os, Solitario s) throws IOException {
		try (ObjectOutputStream solitario = new ObjectOutputStream(os)) {
			solitario.writeObject(s);
		}
	}

	public Solitario cargarPartida(InputStream is) throws IOException, ClassNotFoundException {
		try (ObjectInputStream solitario = new ObjectInputStream(is)) {
			return (Solitario) solitario.readObject();
		}
	}
}
