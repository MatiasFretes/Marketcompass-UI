package com.marketcompass.ui.vista.componentes;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class PanelImagenFondo extends JPanel {
    private Image backgroundImage;
    
    public PanelImagenFondo() {
        try {
            // Carga la imagen desde la ruta especificadab
            backgroundImage = ImageIO.read(getClass().getResource("/com/marketcompass/ui/vista/imagenes/fondo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Dibuja la imagen de fondo en el panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    // Obtener las dimensiones de la imagen de fondo
    public Dimension getBackgroundImageSize() {
        if (backgroundImage != null) {
            return new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
        } else {
            return new Dimension(0, 0);
        }
    }


}
