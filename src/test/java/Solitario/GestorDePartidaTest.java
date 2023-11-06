package Solitario;

import Klondike.Klondike;
import Spider.Spider;
import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class GestorDePartidaTest {

	@Test
	public void guardarYCargarPartidaKlondike() throws IOException, ClassNotFoundException{
		//arrange
		Klondike k = new Klondike();
		Solitario solitarioCargado;

		//act
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		k.guardarPartida(byteArrayOutputStream);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		solitarioCargado = k.cargarPartida(byteArrayInputStream);

		//assert
		assertNotNull(solitarioCargado);
		assertEquals(solitarioCargado.getClass(), k.getClass());
	}
	@Test
	public void guardarYCargarPartidaSpider() throws IOException, ClassNotFoundException{
		//arrange
		Spider s = new Spider();
		Solitario solitarioCargado;

		//act
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		s.guardarPartida(byteArrayOutputStream);

		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		solitarioCargado = s.cargarPartida(byteArrayInputStream);

		//assert
		assertNotNull(solitarioCargado);
		assertEquals(solitarioCargado.getClass(), s.getClass());
	}
}