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
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> listModel;
	private JList<Persona> list;
	private JButton btnModificar;
	private JLabel lblSeleccion;

	public PanelModificarPersona(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
		
		setLayout(null);
		setSize(716, 237); 
		
		list = new JList<>(listModel);
		list.setBounds(53, 36, 612, 156);
		add(list);
		
		lblSeleccion = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccion.setBounds(53, 11, 256, 14);
		add(lblSeleccion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(527, 197, 138, 23);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(53, 198, 148, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(211, 198, 148, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(369, 198, 148, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
	}
	
	
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDNI() {
		return txtDNI;
	}

	public void setTxtDNI(JTextField txtDNI) {
		this.txtDNI = txtDNI;
	}

	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}
	
	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JLabel getLblSeleccionar() {
		return lblSeleccion;
	}

	public void setLblSeleccionar(JLabel lblSeleccion) {
		this.lblSeleccion = lblSeleccion;
	}

	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel = listmodelRecibido;
	}
}
