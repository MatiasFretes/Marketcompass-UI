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
        frame = new JFrame("Información del Mercado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        
        nombreLabel = new JLabel("Nombre del Mercado: ");
        direccionLabel = new JLabel("Dirección del Mercado: ");
        
        panel.add(nombreLabel);
        panel.add(direccionLabel);
        
        frame.add(panel);
    }

    public void mostrarMarket(Market market) {
        nombreLabel.setText("Nombre del Mercado: " + market.getNombre());
        direccionLabel.setText("Dirección del Mercado: " + market.getDireccion());
        
        frame.pack();
        frame.setVisible(true);
    }
}