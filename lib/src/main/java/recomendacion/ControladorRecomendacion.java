package recomendacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Core;
import modelo.Recomendacion;

public class ControladorRecomendacion {
	
	Core core;
	VistaRecomendacion vistaRecomendacion;
	
	public ControladorRecomendacion(Core core, VistaRecomendacion vistaRecomendacion) {
		this.core = core;
		this.vistaRecomendacion = vistaRecomendacion;
		
		iniciarComboCriterios();
		listenerCBCriterios();
		listenerBtnEnviar();
	}
	
	public void iniciarComboCriterios(){
		List<String> criterios = core.obtenerNombresCriterios();
		vistaRecomendacion.actualizarComboBoxCriterio(criterios);
	}
	
    private void listenerCBCriterios() {
        vistaRecomendacion.agregarActionListenerComboBox(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                core.setCriterio(vistaRecomendacion.obtenerSeleccionComboBox());
            }
        });
    }
    
    private void listenerBtnEnviar() {
        vistaRecomendacion.agregarActionListenerBotonEnviar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Recomendacion recomendacion = core.recomendar(vistaRecomendacion.obtenerProductos());
            	vistaRecomendacion.actualizarRecomendacion(recomendacion.getMercado());
            }
        });
    }
}
