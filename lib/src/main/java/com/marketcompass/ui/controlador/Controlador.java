package com.marketcompass.ui.controlador;

import com.marketcompass.modelo.Market;
import com.marketcompass.ui.vista.VistaMarket;

public class Controlador {
	
    public Controlador() {
        Market market = new Market("Mercado 1", "Direccion 1");
        VistaMarket vistaMarket = new VistaMarket();
        vistaMarket.mostrarMarket(market);
    }

}
