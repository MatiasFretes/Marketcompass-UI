package com.marketcompass.ui.controlador;

import java.util.List;
import java.util.Set;

import com.marketcompass.ui.vista.VentanaHistoricoRecomendacion;
import com.marketcompass.ui.vista.VistaMarketCompass;
import extensible.FiltradorPorCriterio;
import model.DB_Recomendacion;
import modelo.Core;
import modelo.Recomendacion;
import service.HistoricoRecomendacionesService;

public class Controlador{
	
	private Core core;
	private VistaMarketCompass vista;
	private HistoricoRecomendacionesService historicoService;
	
	public Controlador(Core core, VistaMarketCompass vista){
    	this.core = core;
    	this.vista = vista;
    	cargarCriterios();
    	historicoService = new HistoricoRecomendacionesService();
    }
	
	public void solicitarRecomendacion(List<String> productos) {
		List<DB_Recomendacion> recomendacionesHistorial = historicoService.consultarRecomendacionesPorProductosYCriterio(productos, vista.criterioSeleccionado.getClass().getSimpleName());
		if(!recomendacionesHistorial.isEmpty()) {
			VentanaHistoricoRecomendacion ventanaHistorial = new VentanaHistoricoRecomendacion(this, recomendacionesHistorial.get(0).getPeticionUsuario(), recomendacionesHistorial.get(0).getCriterioNombre(), recomendacionesHistorial.get(0).getMercadoNombre());
            ventanaHistorial.mostrarVentana();
		} else {
			pedirRecomendacionAlCore(productos);
		}
		solicitarSugerencias(productos);
	}

	public void pedirRecomendacionAlCore(List<String> productos) {
		Recomendacion recomendacion = core.obtenerRecomendacion(vista.criterioSeleccionado, productos);
		vista.actualizarResultado(recomendacion.toString());
	}
	
	public void cargarCriterios() {
	    Set<FiltradorPorCriterio> criterios = this.core.criterios;
	    FiltradorPorCriterio[] listaCriterios = criterios.toArray(new FiltradorPorCriterio[0]);
	    String[] nombresCriterios = new String[listaCriterios.length];
	    for (int i = 0; i < listaCriterios.length; i++) {
	        nombresCriterios[i] = listaCriterios[i].getClass().getSimpleName();
	    }
	    vista.cargarComboBoxCriterio(nombresCriterios, listaCriterios);
	}
	
	public void solicitarSugerencias(List<String> productos) {
		List<String> sugerencias = core.obtenerSugerencias(productos);
		
		if(sugerencias.size() > 4)
			sugerencias = sugerencias.subList(0, 3);
		
		vista.obtenerSugerencias(sugerencias);
	}
}