package com.marketcompass.ui.main;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import com.marketcompass.ui.controlador.Controlador;
import com.marketcompass.ui.vista.VistaMarketCompass;
import modelo.Core;
import modelo.CoreInit;
import observador.ObservadorDeRecomendaciones;

@SuppressWarnings("deprecation")
public class InicializadorMarketCompass implements Observer{
	static VistaMarketCompass vista;
	static Controlador controlador;
	static Core core;
	

	public static void main(String[] args){
		iniciarVista();
		iniciarCore();
		controlador = new Controlador(core, vista);		
		new ObservadorDeRecomendaciones(core.recomendador.recomendadorObservable);
	}

	private static void iniciarVista() {
		InicializadorMarketCompass x = new InicializadorMarketCompass();
		vista = new VistaMarketCompass();
		vista.addObserver(x);
		vista.inicializar();
	}
	
	private static void iniciarCore() {
		CoreInit coreInit = new CoreInit();
		core = coreInit.inicializar();
	}	

	@Override
	public void update(Observable o, Object productos) {
		if(productos instanceof List)
			controlador.solicitarRecomendacion((List) productos);
	}	
}
