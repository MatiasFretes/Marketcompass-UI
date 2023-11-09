package sugerencias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;

public class VistaSugerencias extends JPanel {

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
    }
}
