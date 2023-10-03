package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidad.Persona;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> listModel;
	private JLabel lblNombre;
	private JLabel lblNombre_1;
	private JLabel lblNombre_2;
	private JButton btnAceptar;
	private JLabel lblSucceed;
	private JLabel validatorNombre;
	private JLabel validatorApellido;
	private JLabel validatorDNI;
	
	
	public PanelAgregarPersonas(DefaultListModel<Persona> listModel) {
		setDefaultListModel(listModel);
		
		setLayout(null);
		setSize(716, 237); 
		
		lblNombre = new JLabel("Apellido");
		lblNombre.setBounds(147, 50, 70, 15);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre);
		
		lblNombre_1 = new JLabel("Dni");
		lblNombre_1.setBounds(147, 81, 70, 15);
		lblNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre_1);
		
		lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setBounds(147, 24, 70, 15);
		lblNombre_2.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre_2);
		
		lblSucceed = new JLabel("Persona agregada con \u00E9xito.");
		lblSucceed.setVisible(false);
		lblSucceed.setForeground(new Color(0, 128, 0));
		lblSucceed.setBounds(167, 199, 219, 14);
		add(lblSucceed);
		
		validatorNombre = new JLabel("*");
		validatorNombre.setVisible(false);
		validatorNombre.setForeground(Color.RED);
		validatorNombre.setBounds(357, 24, 568, 14);
		add(validatorNombre);
		
		validatorApellido = new JLabel("*");
		validatorApellido.setVisible(false);
		validatorApellido.setForeground(Color.RED);
		validatorApellido.setBounds(357, 50, 542, 14);
		add(validatorApellido);
		
		validatorDNI = new JLabel("*");
		validatorDNI.setVisible(false);
		validatorDNI.setForeground(Color.RED);
		validatorDNI.setBounds(357, 81, 517, 14);
		add(validatorDNI);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(227, 21, 120, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(227, 47, 120, 20);
		txtApellido.setColumns(10);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(226, 78, 121, 20);
		txtDNI.setColumns(10);
		add(txtDNI);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(169, 141, 120, 37);
		add(btnAceptar);	
	}

	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel = listmodelRecibido;
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

	public JButton getBtnAceptar(){
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar){
		this.btnAceptar = btnAceptar;
	}
	
    public JLabel getValidatorNombre() {
		return validatorNombre;
	}

	public void setValidatorNombre(JLabel validatorNombre) {
		this.validatorNombre = validatorNombre;
	}

	public JLabel getValidatorApellido() {
		return validatorApellido;
	}

	public void setValidatorApellido(JLabel validatorApellido) {
		this.validatorApellido = validatorApellido;
	}

	public JLabel getValidatorDNI() {
		return validatorDNI;
	}

	public void setValidatorDNI(JLabel validatorDNI) {
		this.validatorDNI = validatorDNI;
	}

	public JLabel getLblSucceed() {
		return lblSucceed;
	}

	public void setLblSucceed(JLabel lblSucceed) {
		this.lblSucceed = lblSucceed;
	}
}