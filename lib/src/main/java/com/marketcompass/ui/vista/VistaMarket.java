package com.marketcompass.ui.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.marketcompass.modelo.Market;

public class VistaMarket {
    private JFrame frame;
    private JLabel nombreLabel;
    private JLabel direccionLabel;

    public VistaMarket() {
        frame = new JFrame("Informaci�n del Mercado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        nombreLabel = new JLabel("Nombre del Mercado: ");
        direccionLabel = new JLabel("Direcci�n del Mercado: ");
        
        panel.add(nombreLabel);
        panel.add(direccionLabel);
        
        frame.add(panel);
    }

    public void mostrarMarket(Market market) {
        nombreLabel.setText("Nombre del Mercado: " + market.getNombre());
        direccionLabel.setText("Direcci�n del Mercado: " + market.getDireccion());
        
        frame.pack();
        frame.setVisible(true);
    }
}