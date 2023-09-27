package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	@SuppressWarnings("unused")
	private DefaultListModel<Persona> listModel;
	
	public PanelAgregarPersonas() {
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(62, 66, 75, 20);
		add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Dni");
		lblNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_1.setBounds(62, 110, 75, 20);
		add(lblNombre_1);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre_2.setBounds(62, 152, 75, 20);
		add(lblNombre_2);
		
		textField = new JTextField();
		textField.setBounds(212, 66, 137, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(212, 110, 137, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(212, 152, 137, 20);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(136, 183, 106, 30);
		add(btnNewButton);
	}


	
	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel=listmodelRecibido;
		
	}
}
