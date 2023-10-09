package com.marketcompass.ui.main;



import java.util.List;
import java.util.Observable;
import java.util.Observer;

import com.marketcompass.ui.controlador.Controlador;
import com.marketcompass.ui.vista.VistaMarketCompass;

import modelo.Core;
import modelo.CoreInit;


@SuppressWarnings("deprecation")
public class InicializadorMarketCompass implements Observer{
		
	static Controlador controlador;
	public static void main(String[] args){
		
		InicializadorMarketCompass x = new InicializadorMarketCompass();
		VistaMarketCompass vista = new VistaMarketCompass();
		vista.addObserver(x);
		vista.inicializar();
        
		CoreInit coreInit = new CoreInit();
		Core core = coreInit.inicializar();
		
		controlador = new Controlador(core, vista);
		
	}
	
	@Override
	public void update(Observable o, Object productos) {
		if(productos instanceof List)
			controlador.solicitarRecomendacion((List) productos);
	}
}
