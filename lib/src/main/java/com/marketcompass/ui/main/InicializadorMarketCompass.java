package com.marketcompass.ui.main;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import com.marketcompass.ui.controlador.Controlador;
import com.marketcompass.ui.vista.VistaMarketCompass;

import extensible.FiltradorPorCriterio;
import modelo.Core;
import modelo.CoreInit;

@SuppressWarnings("deprecation")
public class InicializadorMarketCompass implements Observer{
	static VistaMarketCompass vista;
	static Controlador controlador;
	static Core core;
	public static void main(String[] args){
		
		InicializadorMarketCompass x = new InicializadorMarketCompass();
		vista = new VistaMarketCompass();
		vista.addObserver(x);
		vista.inicializar();
		
        
		CoreInit coreInit = new CoreInit();
		core = coreInit.inicializar();
		controlador = new Controlador(core, vista);				
		//Selector criterios
		cargarCriterios();
		
		
	}
	
	@Override
	public void update(Observable o, Object productos) {
		if(productos instanceof List)
			controlador.solicitarRecomendacion((List) productos);
	}
	
	//Acá le pasaria el nombre de los filtradores disponibles esto puede ser un string y lo carga en el combo box como opcion
	
//	public static void cargarCriterios() {
//		 	Set<FiltradorPorCriterio> criterios = core.criterios;
//		    String[] listaCriterios = new String[criterios.size()];
//		    int i = 0;
//		    for (FiltradorPorCriterio criterio : criterios) {
//		        String nombreClase = criterio.getClass().getSimpleName();
//		        listaCriterios[i] = nombreClase;
//		        i++;
//		    }
//	}
	
	public static void cargarCriterios() {
	    Set<FiltradorPorCriterio> criterios = core.criterios;

	    FiltradorPorCriterio[] listaCriterios = criterios.toArray(new FiltradorPorCriterio[0]);
	    String[] nombresCriterios = new String[listaCriterios.length];
	    for (int i = 0; i < listaCriterios.length; i++) {
	        nombresCriterios[i] = listaCriterios[i].getClass().getSimpleName();
	    }
	    vista.cargarComboBoxCriterio(nombresCriterios, listaCriterios);
	}

	
}
