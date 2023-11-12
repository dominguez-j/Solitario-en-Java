package Vista;

import Klondike.Klondike;
import Solitario.Solitario;
import Spider.Spider;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ResolutionSetter {

	public static Scene setResolution(Parent root, Solitario s){
		if(s instanceof Klondike)
			return new Scene(root, 800, 800);
		else if(s instanceof Spider)
			return new Scene(root, 1130, 800);

		return null;
	}
}
