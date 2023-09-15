package com.marketcompass.ui.vista;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.marketcompass.ui.controlador.Controlador;
import com.marketcompass.ui.vista.componentes.PanelImagenFondo;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class VistaMarketCompass {
	private JFrame frame;
	private JList list;
	private JList list_1;
    public static DefaultListModel<String> listProductos;
    private JScrollPane scrollPane;
    private JScrollBar scrollBar;
  
	
	public void inicializar() {
		frame = new JFrame("MarketCompass");
        frame.setVisible(true);
		PanelImagenFondo panel = new PanelImagenFondo();
		JTextField textProducto = crearTextProducto(); 
		JButton btnAgregar = crearBtnAgregar(textProducto);
		JButton btnEnviar = crearBtnEnviar();
		JScrollPane scrollPane = crearConfigurarLista();
			
		frame.add(panel);
		panel.add(textProducto);
		panel.add(btnAgregar);
		panel.add(btnEnviar);
	    panel.add(scrollPane);
		panel.setBounds(0, 0, 1400, 718);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
        frame.getContentPane().add(panel);
		frame.setBounds(550, 550, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
	}
	private JScrollPane crearConfigurarLista() {
	    listProductos = new DefaultListModel<>();
	    list = new JList<>(listProductos);
	    list.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	    list.setBackground(SystemColor.activeCaption);
	    list.setVisibleRowCount(16);
	    scrollPane = new JScrollPane(list);
	    scrollPane.setBounds(500, 350, 500, 120);
	    JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
	    scrollBar.setBounds(300, 155, 17, 170);
	    scrollBar.addAdjustmentListener(new AdjustmentListener() {
	        public void adjustmentValueChanged(AdjustmentEvent e) {
	            int value = e.getValue();
	            list.ensureIndexIsVisible(value);
	        }
	    });
	    return scrollPane;
	}
	public JTextField crearTextProducto() {
		JTextField textProducto = new JTextField();
		textProducto.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		textProducto.setBackground(SystemColor.getColor("0149ac"));
		textProducto.setBounds(400, 200, 400, 28);
		textProducto.setColumns(10);
		return textProducto;
	}
	public JButton crearBtnAgregar(JTextField textProducto) {
		JButton btnAgregar = new JButton("+");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(SystemColor.textHighlight);
		btnAgregar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String text = textProducto.getText();
            if (!text.isEmpty()) {
                listProductos.addElement(text);
                textProducto.setText("");
            }
			}
		});
		btnAgregar.setBounds(820, 200, 45, 28);
		return btnAgregar;
	}
	public JButton crearBtnEnviar() {
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(SystemColor.textHighlight);
		btnEnviar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnEnviar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEnviar.setBounds(640, 500, 105, 33);
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Controlador();
				
			}
			});
		return btnEnviar;
	}
}