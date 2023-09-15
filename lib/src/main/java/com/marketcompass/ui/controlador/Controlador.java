package com.marketcompass.ui.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import com.marketcompass.modelo.Recomendador;
import com.marketcompass.ui.vista.VistaMarketCompass;

public class Controlador {
	
    public Controlador() {

        Recomendador recomendador = new Recomendador(null);
        
        DefaultListModel<String> productosDelUsuario = VistaMarketCompass.listProductos;
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < productosDelUsuario.size(); i++) {
            lista.add(productosDelUsuario.get(i));
        }

        List<String>productosRecibidos = recomendador.PruebaUI(lista);
        
        for (String string : productosRecibidos) {
			System.out.println(string);
		}
        
    }

}
