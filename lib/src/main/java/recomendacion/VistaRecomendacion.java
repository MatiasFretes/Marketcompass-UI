package recomendacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.stream.Collectors;

public class VistaRecomendacion extends JPanel {

    private JTextField textField;
    private JButton butonAgregarProducto;
    private JList<String> list;
    public static DefaultListModel<String> listProductos;
    public JComboBox cb_criterios;
    public JButton btnEnviar;
    public JLabel lbl_recomendacion;

    public VistaRecomendacion() {
        initialize();
    }

    private void initialize() {
        setLayout(null);
        Color colorDeFondo = new Color(0, 74, 173);
        setBackground(colorDeFondo);

        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/imagenes/logoMarketCompass.png"));
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(43, 33, 292, 273);
        add(logoLabel);

        JLabel lbl_pregunta = new JLabel("¿Qué productos deseas comprar?");
        lbl_pregunta.setBounds(384, 11, 374, 36);
        lbl_pregunta.setForeground(Color.WHITE);
        lbl_pregunta.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
        add(lbl_pregunta);

        textField = new JTextField();
        textField.setBounds(384, 50, 275, 36);
        textField.setForeground(colorDeFondo);
        textField.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
        add(textField);
        textField.setColumns(10);

        listProductos = new DefaultListModel<>();
        list = new JList<>(listProductos);
        list.setForeground(new Color(255, 255, 255));
        list.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        list.setBackground(new Color(65, 105, 225));
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBounds(384, 97, 326, 90);
        scrollPane.setForeground(new Color(255, 255, 255));
        scrollPane.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        scrollPane.setBackground(new Color(65, 105, 225));
        add(scrollPane);

        butonAgregarProducto = new JButton("+");
        butonAgregarProducto.setBounds(667, 50, 43, 36);
        butonAgregarProducto.setForeground(new Color(0, 74, 173));
        butonAgregarProducto.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
        add(butonAgregarProducto);

        butonAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (!text.isEmpty()) {
                    listProductos.addElement(text);
                    textField.setText("");
                }
            }
        });

        btnEnviar = new JButton("Enviar");
        btnEnviar.setForeground(colorDeFondo);
        btnEnviar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
        btnEnviar.setBounds(469, 270, 169, 36);
        add(btnEnviar);
        
        cb_criterios = new JComboBox();
        cb_criterios.setBounds(384, 223, 326, 36);
        add(cb_criterios);
        
        lbl_recomendacion = new JLabel();
        lbl_recomendacion.setForeground(Color.WHITE);
        lbl_recomendacion.setFont(new Font("Bahnschrift", Font.PLAIN, 19));
        lbl_recomendacion.setBounds(47, 333, 374, 36);
        add(lbl_recomendacion);
        
        JLabel lbl_SeleccionarCriterio = new JLabel("Seleccione un criterio");
        lbl_SeleccionarCriterio.setForeground(Color.WHITE);
        lbl_SeleccionarCriterio.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
        lbl_SeleccionarCriterio.setBounds(384, 203, 374, 20);
        add(lbl_SeleccionarCriterio);
    }
    
    public void actualizarComboBoxCriterio(java.util.List<String> criterios) {
	    DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(criterios.toArray(new String[0]));
    	cb_criterios.setModel(comboBoxModel);
    }
    
    public void agregarActionListenerBotonEnviar(ActionListener listener) {
    	btnEnviar.addActionListener(listener);
    }
    
    public java.util.List<String> obtenerProductos(){
		return Collections.list(listProductos.elements()).stream().collect(Collectors.toList());
	}
    
    public void agregarActionListenerComboBox(ActionListener listener) {
    	cb_criterios.addActionListener(listener);
    }
    
    public String obtenerSeleccionComboBox() {
        return (String) cb_criterios.getSelectedItem();
    }
    
    public void actualizarRecomendacion(String recomendacion) {
    	lbl_recomendacion.setText("Se recomienda realizar la compra en: " + recomendacion);
    }
}