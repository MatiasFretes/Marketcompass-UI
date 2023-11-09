package inicializadores;

import modelo.Core;
import modelo.CoreInit;
import recomendacion.ControladorRecomendacion;
import recomendacion.VistaRecomendacion;
import sugerencias.VistaSugerencias;

public class MarketCompassInit {

	public static void main(String[] args) {
		
		VistaRecomendacion recomendacion = new VistaRecomendacion();
        VistaSugerencias sugerencias = new VistaSugerencias();
		UnificadorVistas vistas = new UnificadorVistas();
		vistas.unirVistas(recomendacion, sugerencias);

		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		
		ControladorRecomendacion controladorRecomendacion = new ControladorRecomendacion(core, recomendacion);

	}

}
