package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import entidad.Persona;

public class PanelModificarPersona extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private DefaultListModel<Persona> listModel;

	public PanelModificarPersona(DefaultListModel<Persona> listModel) {
		
		setLayout(null);
		setSize(716, 237); 
		
		JList list = new JList();
		list.setBounds(53, 36, 612, 156);
		add(list);
		
		JLabel lblNewLabel = new JLabel("Seleccione la persona que desea modificar");
		lblNewLabel.setBounds(53, 11, 256, 14);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(527, 197, 138, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(53, 198, 148, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 198, 148, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(369, 198, 148, 20);
		add(textField_2);
		textField_2.setColumns(10);

	}
	
	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel = listmodelRecibido;
	}
}
