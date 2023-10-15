package com.marketcompass.ui.vista;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import com.marketcompass.ui.vista.componentes.PanelImagenFondo;

import extensible.FiltradorPorCriterio;

import javax.swing.SwingConstants;
import java.awt.SystemColor;

@SuppressWarnings("deprecation")
public class VistaMarketCompass extends Observable{
	private JFrame frame;
	private JList<String> list;
	public static DefaultListModel<String> listProductos;
	public static FiltradorPorCriterio criterioSeleccionado;
    private JScrollPane scrollPane;
    private static JTextField resultadoTextField;
    private static JComboBox comboBox;

	public VistaMarketCompass() {
		
	}
	
	public void inicializar() {
		frame = new JFrame("MarketCompass");
        frame.setVisible(true);
		PanelImagenFondo panel = new PanelImagenFondo();
	    Dimension backgroundImageSize = panel.getBackgroundImageSize();
		int panelWidth = (int) backgroundImageSize.getWidth();
	    int panelHeight = (int) backgroundImageSize.getHeight();
	    
		JTextField textProducto = crearCampoProducto(); 
		JButton btnAgregar = crearBtnAgregar(textProducto);
		JButton btnEnviar = crearBtnEnviar();
		JScrollPane scrollPane = crearLista();
		JComboBox comboBoxCriterio = crearComboBox();
		
			
		frame.add(panel);
		panel.add(textProducto);
		panel.add(btnAgregar);
		panel.add(btnEnviar);
	    panel.add(scrollPane);
	    panel.add(comboBoxCriterio);
		panel.setBounds(0, 0, panelWidth, panelHeight);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
        frame.getContentPane().add(panel);
		frame.setBounds(550, 550, panelWidth, panelHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
	    resultadoTextField = new JTextField();
	    resultadoTextField.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
	    resultadoTextField.setEditable(false);
	    resultadoTextField.setBackground(SystemColor.getColor("0149ac"));
	    resultadoTextField.setBounds(300, 540, 800, 28);
	    frame.getContentPane().add(resultadoTextField);
	}
	
	private JScrollPane crearLista() {
	    listProductos = new DefaultListModel<>();
	    list = new JList<>(listProductos);
	    list.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
	    list.setBackground(SystemColor.activeCaption);
	    list.setVisibleRowCount(16);
	    scrollPane = new JScrollPane(list);
	    scrollPane.setBounds(450, 174, 500, 120);
	    JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL);
	    scrollBar.setBounds(450, 174, 17, 170);
	    scrollBar.addAdjustmentListener(new AdjustmentListener() {
	        public void adjustmentValueChanged(AdjustmentEvent e) {
	            int value = e.getValue();
	            list.ensureIndexIsVisible(value);
	        }
	    });
	    return scrollPane;
	}
	public JTextField crearCampoProducto() {
		JTextField textProducto = new JTextField();
		textProducto.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		textProducto.setBackground(SystemColor.activeCaption);
		textProducto.setBounds(360, 100, 400, 28);
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
                resultadoTextField.setText("");
            }
			}
		});
		btnAgregar.setBounds(775, 100, 45, 28);
		return btnAgregar;
	}
	public JButton crearBtnEnviar() {
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setBackground(SystemColor.textHighlight);
		btnEnviar.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 16));
		btnEnviar.setHorizontalAlignment(SwingConstants.CENTER);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setChanged();
			    notifyObservers(obtenerProductos());
			    listProductos.clear();
			}
		});
		btnEnviar.setBounds(640, 550, 105, 33);
		return btnEnviar;
	}
	
	// Acá se setearian las opciones disponibles del combo box con los filtradores disponibles la linea 144 tomaria los filtradores
	
	public JComboBox crearComboBox() {
		comboBox = new JComboBox();
		comboBox.setBounds(455, 343, 305, 33);
		comboBox.setBackground(SystemColor.activeCaption);
		comboBox.setEditable(true);
		return comboBox;
		
	}
	
//	public void cargarComboBoxCriterio(String[] criterios) {
//		comboBox.setModel(new DefaultComboBoxModel(criterios));
//	}
//	
//	public String obtenerCriterioSeleccionado() {
//		String itemSeleccionado = comboBox.getSelectedItem().toString();
//
//		// Verifica si el elemento seleccionado no es nulo antes de trabajar con él
//		if (itemSeleccionado != null) {
//		    String criterioSeleccionado = itemSeleccionado.toString();
//		    // Aquí tienes el String seleccionado en el JComboBox
//		   return criterioSeleccionado;
//		} else {
//		    return "No se ha seleccionado ningún elemento.";
//		}
//	}
	
	public void cargarComboBoxCriterio(String[] nombresCriterios, FiltradorPorCriterio[] criterios) {
	    comboBox.setModel(new DefaultComboBoxModel(nombresCriterios));

	    comboBox.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int selectedIndex = comboBox.getSelectedIndex();
	            if (selectedIndex != -1) {
	                criterioSeleccionado = criterios[selectedIndex];	                
	            }
	        }
	    });
	}
	
	public void actualizarResultado(String resultado) {
		resultadoTextField.setText(resultado);
	}
	
	public List<String> obtenerProductos(){
		return Collections.list(listProductos.elements()).stream().collect(Collectors.toList());
	}
}