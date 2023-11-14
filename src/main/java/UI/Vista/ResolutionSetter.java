package UI.Vista;

import Solitario.Solitario;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class ResolutionSetter {

	public static Scene setResolution(Parent root, Solitario s){
		return new Scene(root, s.obtenerAncho(), s.obtenerAlto());
	}
}
