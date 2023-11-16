package UI.Vista;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorDeSonidos {

	public static void reproducirSonido(String archivo){
		Media sound = new Media(ReproductorDeSonidos.class.getResource("/Sonidos/"+archivo).toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setVolume(0.2);
		mediaPlayer.play();
	}
}
