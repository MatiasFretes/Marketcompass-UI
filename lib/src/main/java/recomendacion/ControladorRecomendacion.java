package recomendacion;

import java.util.List;
import java.util.stream.Collectors;
import modelo.Core;

public class ControladorRecomendacion {
	
	Core core;
	VistaRecomendacion vistaRecomendacion;
	
	public ControladorRecomendacion(Core core, VistaRecomendacion vistaRecomendacion) {
		this.core = core;
		this.vistaRecomendacion = vistaRecomendacion;
		
		iniciarComboCriterios();
	}
	
	public void iniciarComboCriterios(){
		List<String> criterios = core.criterios.stream().map(c -> c.getClass().getName()).collect(Collectors.toList());
		vistaRecomendacion.actualizarComboBoxCriterio(criterios);
	}
}
