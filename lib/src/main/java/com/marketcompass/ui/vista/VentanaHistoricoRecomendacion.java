package com.marketcompass.ui.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.marketcompass.ui.controlador.Controlador;

import javax.swing.ImageIcon;
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
    private JLabel lblImgLogo;

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
		frame = new JFrame("MarketCompass - Histórico");
        Color colorTexto = Color.WHITE;  // Color de texto blanco

        Color colorFondo = new Color(0x004AAD);

        
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(colorFondo);

        frame.setBackground(colorFondo);
        lblMensaje = new JLabel("Ya se realizó la solicitud de:");
        lblMensaje.setBounds(20, 36, 414, 18);
        lblMensaje.setFont(new Font("Britannic Bold", Font.PLAIN, 18));  
        lblMensaje.setForeground(colorTexto);
        frame.getContentPane().add(lblMensaje);

        lblProductos = new JLabel("Productos: " + productos.toString());
        lblProductos.setBounds(20, 65, 414, 18);
        lblProductos.setForeground(colorTexto);
        lblProductos.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
        frame.getContentPane().add(lblProductos);

        lblCriterio = new JLabel("Con el criterio: " + criterio);
        lblCriterio.setBounds(20, 94, 414, 18);
        lblCriterio.setForeground(colorTexto);
        lblCriterio.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
        frame.getContentPane().add(lblCriterio);

        lblRecomendacion = new JLabel("MARKETCOMPASS");
        lblRecomendacion.setBounds(0, 0, 434, 30);
        lblRecomendacion.setForeground(colorTexto);
        lblRecomendacion.setOpaque(true);
        lblRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);

        lblRecomendacion.setBackground(SystemColor.activeCaption);

        lblRecomendacion.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
        frame.getContentPane().add(lblRecomendacion);
        
        lblRecomendacion = new JLabel("¿Desea realizar la busqueda de todos modos?");
        lblRecomendacion.setBounds(39, 164, 414, 18);
        lblRecomendacion.setForeground(colorTexto);
        lblRecomendacion.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
        frame.getContentPane().add(lblRecomendacion);

        btnSi = new JButton("Sí");
        btnSi.setForeground(Color.WHITE);
        btnSi.setBackground(SystemColor.textHighlight);
        btnSi.setFont(new Font("Britannic Bold", Font.PLAIN, 20));       
        btnSi.setHorizontalAlignment(SwingConstants.CENTER);
        btnSi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controlador.pedirRecomendacionAlCore(productos);
                frame.dispose();
            }
        });
        btnSi.setBounds(63, 204, 89, 23);
        frame.getContentPane().add(btnSi);

        btnNo = new JButton("No");
        btnNo.setForeground(Color.WHITE);
        btnNo.setBackground(SystemColor.textHighlight);
        btnNo.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
        btnNo.setHorizontalAlignment(SwingConstants.CENTER);
        btnNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNo.setBounds(245, 204, 89, 23);
        frame.getContentPane().add(btnNo);
        
        lblRecomendacion = new JLabel("Se recomendó: " + mercado.toString());
        lblRecomendacion.setOpaque(true);
        lblRecomendacion.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecomendacion.setForeground(Color.WHITE);
        lblRecomendacion.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
        lblRecomendacion.setBackground(SystemColor.activeCaption);
        lblRecomendacion.setBounds(43, 134, 318, 30);
        frame.getContentPane().add(lblRecomendacion);
        
        lblImgLogo = new JLabel("New label");
        lblImgLogo.setIcon(new ImageIcon(VentanaHistoricoRecomendacion.class.getResource("/com/marketcompass/ui/vista/imagenes/logo.png")));
        lblImgLogo.setBounds(329, 203, 95, 58);
        frame.getContentPane().add(lblImgLogo);
}
	}
	
	
        
        
  
    
	
	
	
