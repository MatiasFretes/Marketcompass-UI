package com.marketcompass.ui.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import com.marketcompass.modelo.Inicializador;
import com.marketcompass.modelo.Recomendador;
import com.marketcompass.ui.vista.VistaMarketCompass;
import org.apache.commons.math3.util.Pair;

public class Controlador {
	
	public static String PATH_JSON = "";
	public static String PATH_JAR = "";
	
    public Controlador() throws Exception {

    	Inicializador core = new Inicializador();
    	core.inicializar(PATH_JSON, PATH_JAR);
    	
    	Recomendador recomendador = new Recomendador();
        DefaultListModel<String> productosDelUsuario = VistaMarketCompass.listProductos;
        List<String> lista = new ArrayList<>();
        
        for (int i = 0; i < productosDelUsuario.size(); i++) {
            lista.add(productosDelUsuario.get(i));
        }

        Pair<String, List<String>> mercadoRecomendado = recomendador.recomendar(lista);
        
        String resultadoMensaje = "Se recomienda el mercado " + mercadoRecomendado.getKey() +
                " para comprar " + mercadoRecomendado.getValue();

        VistaMarketCompass.actualizarResultado(resultadoMensaje);
        
    }

}
