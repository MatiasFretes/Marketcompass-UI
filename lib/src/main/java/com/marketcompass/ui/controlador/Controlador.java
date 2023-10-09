package com.marketcompass.ui.controlador;

import java.util.List;
import com.marketcompass.ui.vista.VistaMarketCompass;
import modelo.Core;
import modelo.Recomendacion;

public class Controlador{
	
	private Core core;
	private VistaMarketCompass vista;
	public Controlador(Core core, VistaMarketCompass vista){
    	this.core = core;
    	this.vista = vista;
    }

	public void solicitarRecomendacion(List<String> productos) {
		Recomendacion recomendacion = core.obtenerRecomendacion(productos);
		vista.actualizarResultado(recomendacion.toString());
	}
}
