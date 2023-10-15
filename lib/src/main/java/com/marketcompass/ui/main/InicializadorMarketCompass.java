package com.marketcompass.ui.main;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.marketcompass.ui.controlador.Controlador;
import com.marketcompass.ui.vista.VistaMarketCompass;

import modelo.Core;
import modelo.CoreInit;
import observable.RecomendadorObservable;
import observador.ObservadorDeRecomendaciones;

@SuppressWarnings("deprecation")
public class InicializadorMarketCompass implements Observer{
		
	static Controlador controlador;
	static ObservadorDeRecomendaciones observadorRecomendaciones;
	public static void main(String[] args){
		
		InicializadorMarketCompass x = new InicializadorMarketCompass();
		VistaMarketCompass vista = new VistaMarketCompass();
		vista.addObserver(x);
		vista.inicializar();
        
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		
		observadorRecomendaciones = new ObservadorDeRecomendaciones(core.recomendador.recomendadorObservable);
		controlador = new Controlador(core, vista);
	}
	
	@Override
	public void update(Observable o, Object productos) {
		if(productos instanceof List)
			controlador.solicitarRecomendacion((List) productos);
	}
}
