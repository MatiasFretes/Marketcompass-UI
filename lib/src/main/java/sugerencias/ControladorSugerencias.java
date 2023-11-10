package sugerencias;

import java.util.Observable;
import java.util.Observer;

public class ControladorSugerencias implements Observer{
	
	VistaSugerencias vistaSugerencias;

	public ControladorSugerencias(VistaSugerencias vistaSugerencias) {
		this.vistaSugerencias = vistaSugerencias;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}
