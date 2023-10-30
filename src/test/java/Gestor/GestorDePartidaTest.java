package Gestor;

import Klondike.Klondike;
import Solitario.Solitario;
import Spider.Spider;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class GestorDePartidaTest {

	@Test
	public void guardarYCargarPartidaKlondike() throws IOException, ClassNotFoundException{
		//arrange
		GestorDePartida g = new GestorDePartida();
		Klondike k = new Klondike();
		Solitario solitarioCargado;

		//act
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		g.guardarPartida(byteArrayOutputStream, k);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		solitarioCargado = g.cargarPartida(byteArrayInputStream);

		//assert
		assertNotNull(solitarioCargado);
		assertEquals(solitarioCargado.getClass(), k.getClass());
	}
	@Test
	public void guardarYCargarPartidaSpider() throws IOException, ClassNotFoundException{
		//arrange
		GestorDePartida g = new GestorDePartida();
		Spider s = new Spider();
		Solitario solitarioCargado;

		//act
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		g.guardarPartida(byteArrayOutputStream, s);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		solitarioCargado = g.cargarPartida(byteArrayInputStream);

		//assert
		assertNotNull(solitarioCargado);
		assertEquals(solitarioCargado.getClass(), s.getClass());
	}
}