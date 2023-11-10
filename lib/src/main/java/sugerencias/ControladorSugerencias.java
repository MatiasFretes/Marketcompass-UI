package sugerencias;

import java.util.Observable;
import java.util.Observer;

import sugeridor.Sugeridor;

public class ControladorSugerencias implements Observer{
	
	VistaSugerencias vistaSugerencias;

	public ControladorSugerencias(VistaSugerencias vistaSugerencias) {
		this.vistaSugerencias = vistaSugerencias;
	}

	@Override
	public void update(Observable o, Object productosSugeridos) {
		if(o instanceof Sugeridor){
			vistaSugerencias.actualizarSugerencias(productosSugeridos.toString());
		}
	}
}
