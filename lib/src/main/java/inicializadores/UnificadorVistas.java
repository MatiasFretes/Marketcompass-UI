package inicializadores;

import java.awt.EventQueue;
import javax.swing.JFrame;
import recomendacion.VistaRecomendacion;
import sugerencias.VistaSugerencias;
import javax.swing.*;

public class UnificadorVistas {

    public void unirVistas(VistaRecomendacion recomendacion, VistaSugerencias sugerencias) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame frame = new JFrame("MarketCompass");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setBounds(100, 100, 800, 600);

                    JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, recomendacion, sugerencias);
                    splitPane.setDividerLocation(400);

                    frame.getContentPane().add(splitPane);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
