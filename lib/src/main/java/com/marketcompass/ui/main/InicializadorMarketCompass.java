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
import observador.ObservadorDeRecomendaciones;

@SuppressWarnings("deprecation")
public class InicializadorMarketCompass implements Observer{
	static VistaMarketCompass vista;
	static Controlador controlador;
	static ObservadorDeRecomendaciones observadorRecomendaciones;
	static Core core;

	public static void main(String[] args){
		InicializadorMarketCompass x = new InicializadorMarketCompass();
		vista = new VistaMarketCompass();
		vista.addObserver(x);
		vista.inicializar();

		CoreInit coreInit = new CoreInit();
		core = coreInit.inicializar();
		cargarCriterios();
		controlador = new Controlador(core, vista);		

		observadorRecomendaciones = new ObservadorDeRecomendaciones(core.recomendador.recomendadorObservable);

	}
	
	@Override
	public void update(Observable o, Object productos) {
		if(productos instanceof List)
			controlador.solicitarRecomendacion((List) productos);
	}
	
	public static void cargarCriterios() {
	    Set<FiltradorPorCriterio> criterios = core.criterios;
	    FiltradorPorCriterio[] listaCriterios = criterios.toArray(new FiltradorPorCriterio[0]);
	    String[] nombresCriterios = new String[listaCriterios.length+1];
	    for (int i = 0; i < listaCriterios.length; i++) {
	        nombresCriterios[i] = listaCriterios[i].getClass().getSimpleName();
	    }
	    vista.cargarComboBoxCriterio(nombresCriterios, listaCriterios);
	}

	
}
