package sugerencias;

import javax.swing.*;
import java.awt.*;

public class VistaSugerencias extends JPanel {

	public JLabel lbl_sugerencias;
	
    public VistaSugerencias() {
    	
        initialize();
    }

    private void initialize() {
        setBackground(new Color(65, 105, 225));
        setLayout(null);
        JLabel lblNewLabel = new JLabel("Te sugerimos comprar los siguientes productos:");
        lblNewLabel.setBounds(45, 0, 430, 49);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(lblNewLabel);
        
        lbl_sugerencias = new JLabel("");
        lbl_sugerencias.setHorizontalAlignment(SwingConstants.LEFT);
        lbl_sugerencias.setForeground(Color.WHITE);
        lbl_sugerencias.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
        lbl_sugerencias.setBounds(166, 44, 430, 49);
        add(lbl_sugerencias);
    }
    
    public void actualizarSugerencias(String productosSugeridos) {
    	lbl_sugerencias.setText(productosSugeridos);
    }
}
