package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import entidad.Persona;
import java.awt.Color;
import java.util.List;
import java.awt.ScrollPane;

public class PanelModificarPersona extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> listModel;
	private JList<Persona> list;
	private JButton btnModificar;
	private JLabel lblSeleccion;
	private JLabel lblSucceed;
	private JLabel lblValidatorNombre;
	private JLabel lblValidatorApellido;
	private JLabel lblValidatorDNI;

	public PanelModificarPersona(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
		
		setLayout(null);
		setSize(716, 267); 
		
		list = new JList<>(listModel);
		list.setBounds(53, 36, 612, 156);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setView(list);
		scrollPane.setBounds(63, 36, 612, 156);
		add(scrollPane);
		//add(list);
		
		lblSeleccion = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccion.setBounds(53, 11, 256, 14);
		add(lblSeleccion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(537, 197, 138, 23);
		add(btnModificar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(63, 198, 148, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(225, 198, 148, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(383, 198, 148, 20);
		add(txtDNI);
		txtDNI.setColumns(10);
		txtDNI.setEditable(false);
		
		lblSucceed = new JLabel("Persona modificada con éxito.");
		lblSucceed.setForeground(Color.GREEN);
		lblSucceed.setBounds(225, 242, 281, 14);
		lblSucceed.setVisible(false);
		add(lblSucceed);
		
		lblValidatorNombre = new JLabel("*");
		lblValidatorNombre.setForeground(Color.RED);
		lblValidatorNombre.setBounds(63, 218, 148, 14);
		lblValidatorNombre.setVisible(false);
		add(lblValidatorNombre);
		
		lblValidatorApellido = new JLabel("*");
		lblValidatorApellido.setForeground(Color.RED);
		lblValidatorApellido.setBounds(225, 218, 148, 14);
		lblValidatorApellido.setVisible(false);
		add(lblValidatorApellido);
		
		lblValidatorDNI = new JLabel("*");
		lblValidatorDNI.setForeground(Color.RED);
		lblValidatorDNI.setBounds(383, 218, 148, 14);
		lblValidatorDNI.setVisible(false);
		add(lblValidatorDNI);
		
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

	public JLabel getLblSeleccion() {
		return lblSeleccion;
	}

	public void setLblSeleccion(JLabel lblSeleccion) {
		this.lblSeleccion = lblSeleccion;
	}

	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel = listmodelRecibido;
	}
	
	public DefaultListModel<Persona> getDefultListModel (){
		return listModel;
	}

	public JLabel getLblSucceed() {
		return lblSucceed;
	}

	public void setLblSucceed(JLabel lblSucceed) {
		this.lblSucceed = lblSucceed;
	}

	public JLabel getLblValidatorNombre() {
		return lblValidatorNombre;
	}

	public void setLblValidatorNombre(JLabel lblValidatorNombre) {
		this.lblValidatorNombre = lblValidatorNombre;
	}

	public JLabel getLblValidatorApellido() {
		return lblValidatorApellido;
	}

	public void setLblValidatorApellido(JLabel lblValidatorApellido) {
		this.lblValidatorApellido = lblValidatorApellido;
	}

	public JLabel getLblValidatorDNI() {
		return lblValidatorDNI;
	}

	public void setLblValidatorDNI(JLabel lblValidatorDNI) {
		this.lblValidatorDNI = lblValidatorDNI;
	}
}
