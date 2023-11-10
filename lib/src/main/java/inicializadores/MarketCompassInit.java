package inicializadores;

import modelo.Core;
import modelo.CoreInit;
import recomendacion.ControladorRecomendacion;
import recomendacion.VistaRecomendacion;
import sugerencias.ControladorSugerencias;
import sugerencias.VistaSugerencias;
import sugeridor.Sugeridor;

public class MarketCompassInit {

	public static void main(String[] args) {
		
		VistaRecomendacion vistaRecomendacion = new VistaRecomendacion();
        VistaSugerencias vistaSugerencias = new VistaSugerencias();
		UnificadorVistas vistas = new UnificadorVistas();
		vistas.unirVistas(vistaRecomendacion, vistaSugerencias);

		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();

		new ControladorRecomendacion(core, vistaRecomendacion);

		Sugeridor sugeridor = new Sugeridor();
		core.addObserver(sugeridor);

		ControladorSugerencias controladorSugerencias = new ControladorSugerencias(vistaSugerencias);
		sugeridor.addObserver(controladorSugerencias);
	}
}
