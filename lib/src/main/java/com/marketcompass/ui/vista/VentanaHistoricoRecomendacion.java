package com.marketcompass.ui.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.marketcompass.ui.controlador.Controlador;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class VentanaHistoricoRecomendacion {

    private JFrame frame;
    private JLabel lblMensaje;
    private JLabel lblProductos;
    private JLabel lblCriterio;
    private JLabel lblRecomendacion;
    private JButton btnSi;
    private JButton btnNo;
    
    private List<String> productos;
    private String criterio;
    private String mercado;
    private Controlador controlador;

    public VentanaHistoricoRecomendacion(Controlador controlador, List<String> productos, String criterio, String mercado) {
        this.controlador = controlador;
    	this.productos = productos;
        this.criterio = criterio;
        this.mercado = mercado;
        initialize();
    }

    public VentanaHistoricoRecomendacion() {
	}
    
    public void mostrarVentana() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        lblMensaje = new JLabel("Ya se realizó la solicitud de:");
        lblMensaje.setBounds(10, 11, 414, 14);
        frame.getContentPane().add(lblMensaje);

        lblProductos = new JLabel("Productos: " + productos.toString());
        lblProductos.setBounds(10, 36, 414, 14);
        frame.getContentPane().add(lblProductos);

        lblCriterio = new JLabel("Con el criterio: " + criterio);
        lblCriterio.setBounds(10, 61, 414, 14);
        frame.getContentPane().add(lblCriterio);

        lblRecomendacion = new JLabel("Se recomendó: " + mercado);
        lblRecomendacion.setBounds(10, 86, 414, 14);
        frame.getContentPane().add(lblRecomendacion);
        
        lblRecomendacion = new JLabel("¿Desea realizar la busqueda de todos modos?");
        lblRecomendacion.setBounds(10, 120, 414, 14);
        frame.getContentPane().add(lblRecomendacion);

        btnSi = new JButton("Sí");
        btnSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlador.pedirRecomendacionAlCore(productos);
                frame.dispose();
            }
        });
        btnSi.setBounds(76, 149, 89, 23);
        frame.getContentPane().add(btnSi);

        btnNo = new JButton("No");
        btnNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNo.setBounds(239, 149, 89, 23);
        frame.getContentPane().add(btnNo);
    }
}