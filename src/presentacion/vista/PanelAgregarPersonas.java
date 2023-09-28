package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidad.Persona;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelAgregarPersonas extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private DefaultListModel<Persona> listModel;
	
	
	public PanelAgregarPersonas(DefaultListModel<Persona> listModel) {
		
		setLayout(null);
		setSize(423, 237); 
		
		JLabel lblNombre = new JLabel("Apellido");
		lblNombre.setBounds(127, 50, 70, 15);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre);
		
		JLabel lblNombre_1 = new JLabel("Dni");
		lblNombre_1.setBounds(127, 76, 70, 15);
		lblNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre_1);
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setBounds(127, 24, 70, 15);
		lblNombre_2.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblNombre_2);
		
		JLabel lblSucceed = new JLabel("Persona agregada con \u00E9xito.");
		lblSucceed.setVisible(false);
		lblSucceed.setForeground(new Color(0, 128, 0));
		lblSucceed.setBounds(167, 199, 219, 14);
		add(lblSucceed);
		
		JLabel validatorNombre = new JLabel("*");
		validatorNombre.setVisible(false);
		validatorNombre.setForeground(Color.RED);
		validatorNombre.setBounds(340, 24, 46, 14);
		add(validatorNombre);
		
		JLabel validatorApellido = new JLabel("*");
		validatorApellido.setVisible(false);
		validatorApellido.setForeground(Color.RED);
		validatorApellido.setBounds(340, 50, 13, 14);
		add(validatorApellido);
		
		JLabel validatorDNI = new JLabel("*");
		validatorDNI.setVisible(false);
		validatorDNI.setForeground(Color.RED);
		validatorDNI.setBounds(340, 81, 46, 14);
		add(validatorDNI);
		
	
		txtNombre = new JTextField();
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtNombre.setBackground(Color.WHITE);
				validatorNombre.setVisible(false);
				lblSucceed.setVisible(false);
			}
		});
		txtNombre.setBounds(211, 21, 120, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtApellido.setBackground(Color.WHITE);
				validatorApellido.setVisible(false);
				lblSucceed.setVisible(false);
			}
		});
		txtApellido.setBounds(211, 47, 120, 20);
		txtApellido.setColumns(10);
		add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtDNI.setBackground(Color.WHITE);
				validatorDNI.setVisible(false);
				lblSucceed.setVisible(false);
			}
			
		});
		txtDNI.setBounds(210, 78, 121, 20);
		txtDNI.setColumns(10);
		add(txtDNI);
	
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(169, 141, 120, 37);
		add(btnAceptar);
		btnAceptar.addActionListener(new EventoButtonAceptar(txtNombre, txtApellido,txtDNI,validatorNombre,validatorApellido,validatorDNI,lblSucceed));
	
	}


	
	public void setDefaultListModel(DefaultListModel<Persona> listmodelRecibido) {
		this.listModel=listmodelRecibido;
		
	}
}

class EventoButtonAceptar implements ActionListener{
	
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JLabel validatorNombre;
	private JLabel validatorApellido;
	private JLabel validatorDNI;
	private JLabel lblSucceed;
	
	public EventoButtonAceptar(JTextField txtNombre, JTextField txtApellido, JTextField txtDNI, JLabel validatorNombre,
			JLabel validatorApellido, JLabel validatorDNI,JLabel lblSucceed) {
		super();
		this.txtNombre = txtNombre;
		this.txtApellido = txtApellido;
		this.txtDNI = txtDNI;
		this.validatorNombre = validatorNombre;
		this.validatorApellido = validatorApellido;
		this.validatorDNI = validatorDNI;
		this.lblSucceed = lblSucceed;
	}

	
	public void actionPerformed(ActionEvent e) {
		
		int bandera = 0;
		
		if(txtNombre.getText().isEmpty()) {
			txtNombre.setBackground(Color.red);
			validatorNombre.setVisible(true);
			txtNombre.setText("");
			bandera++;
		}
		else {
			txtNombre.setBackground(Color.white);
			validatorNombre.setVisible(false);
		}
		if (txtApellido.getText().isEmpty()) {
			txtApellido.setBackground(Color.red);
			validatorApellido.setVisible(true);
			txtApellido.setText("");
			bandera++;
		}
		else {
			txtApellido.setBackground(Color.WHITE);
			validatorApellido.setVisible(false);
		}
		
		
		if(txtDNI.getText().isEmpty()) {
			txtDNI.setBackground(Color.red);
			validatorDNI.setVisible(true);
			txtDNI.setText("");
			bandera++;
		}
		else {
			txtDNI.setBackground(Color.white);
			validatorDNI.setVisible(false);
		}
		
		if(bandera == 0) {
			lblSucceed.setVisible(true);
			txtDNI.setText("");
			txtApellido.setText("");
			txtNombre.setText("");
		}
		
		
		
	}
	
	
}
