package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador {
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersona pnlModificarPersona;
	private DefaultListModel<Persona> listModel;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	
	public Controlador(VentanaPrincipal vista, DefaultListModel<Persona> listModel1, PersonaNegocio pNeg) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.listModel = listModel1;
		this.pNeg = pNeg;
				
		//Instancio los paneles
		this.pnlAgregarPersonas = new PanelAgregarPersonas(listModel);
		this.pnlModificarPersona = new PanelModificarPersona(listModel);
		
		//Eventos VentanaPrincipal
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a, listModel));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a, listModel));
		
		//Eventos PnlAgregarPersonas
		this.pnlAgregarPersonas.getBtnAceptar().addActionListener(b->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(b, listModel));
		this.pnlAgregarPersonas.getTxtNombre().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlAgregarPersonas.getTxtNombre().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorNombre().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}
		});
		this.pnlAgregarPersonas.getTxtApellido().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlAgregarPersonas.getTxtApellido().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorApellido().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}
		});
		this.pnlAgregarPersonas.getTxtDNI().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnlAgregarPersonas.getTxtDNI().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorDNI().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}
		});
		
		//Eventos PnlModificarPersonas
		this.pnlModificarPersona.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPersona_PanelModificarPersona(a));
	}
	
	
	//AGREGAR PERSONA
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a, DefaultListModel<Persona> listModel) {
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		pnlAgregarPersonas.setDefaultListModel(listModel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();		
	}
	
	public void  EventoClickMenu_AbrirPanel_ModificarPersona(ActionEvent a, DefaultListModel<Persona> listModel) {
			this.refrescarLista();
			ventanaPrincipal.getContentPane().removeAll();
			ventanaPrincipal.getContentPane().add(pnlModificarPersona);
			pnlModificarPersona.setDefaultListModel(listModel);
			ventanaPrincipal.getContentPane().repaint();
			ventanaPrincipal.getContentPane().revalidate();		
		}
	
	public void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a, DefaultListModel<Persona> listModel) {
				
		JTextField txtNombre = this.pnlAgregarPersonas.getTxtNombre();
		JTextField txtApellido = this.pnlAgregarPersonas.getTxtApellido();
		JTextField txtDNI = this.pnlAgregarPersonas.getTxtDNI();
		JLabel lblSucceed = this.pnlAgregarPersonas.getLblSucceed();
		JLabel validatorNombre = this.pnlAgregarPersonas.getValidatorNombre();
		JLabel validatorApellido = this.pnlAgregarPersonas.getValidatorApellido();
		JLabel validatorDNI = this.pnlAgregarPersonas.getValidatorDNI();
		Persona persona = new Persona(txtDNI.getText(),txtNombre.getText(),txtApellido.getText());
		
		Boolean estado = validarPersona(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI);
		if(estado) {
        	if (pNeg.insert(persona)) {
	        	lblSucceed.setVisible(true);
	            txtDNI.setText("");
	            txtApellido.setText("");
	            txtNombre.setText("");
        	}
        	else {
             	JOptionPane.showMessageDialog(null, "ERROR - DNI REPETIDO.");
             	txtDNI.setText("");
             	txtApellido.setText("");
             	txtNombre.setText("");
            }
        }
    }
	
	public Boolean validarPersona (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI) {
		
		int bandera = 0;
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
		
		if (!validarTextFields(txtApellido, validatorApellido)) bandera++;
		if (!validarTextFields(txtNombre, validatorNombre)) bandera++;
		if (!validarTextFields(txtDNI, validatorDNI)) bandera++;

      
        if(esNumero(txtApellido.getText())) {
        	validatorApellido.setText("El apellido solo debe contener letras.");
        	validatorApellido.setVisible(true);
        	bandera++;
        }
        if(!esNumero(txtDNI.getText()) && !txtDNI.getText().isEmpty()) {
        	validatorDNI.setText("El DNI solo debe contener numeros.");
        	validatorDNI.setVisible(true);
        	bandera++;
        }
        if(bandera == 0 ) return true;
        else return false;
	}
	
	public Boolean validarTextFields (JTextField txt, JLabel lbl) {
		if(txt.getText().isEmpty()) {
            txt.setBackground(Color.red);
            lbl.setVisible(true);
            txt.setText("");
            return false;
        }
		else {
            txt.setBackground(Color.white);
            lbl.setVisible(false);
            return true;
        }
	}
	
	public static Boolean esNumero(String campo) {
		if(campo.matches("[0-9]+")) {
			return true;
		}
		else return false;
	}
	
	//MODIFICAR PERSONA
	public void EventoClickBoton_ModificarPersona_PanelModificarPersona(ActionEvent a) {
		JTextField txtApellido = pnlModificarPersona.getTxtApellido();
		JTextField txtNombre = pnlModificarPersona.getTxtNombre();
		JTextField txtDNI = pnlModificarPersona.getTxtDNI();
		JLabel lblSucceed = pnlModificarPersona.getLblSucceed();
		Persona persona = new Persona(txtDNI.getText(),txtNombre.getText(),txtApellido.getText());
		JLabel validatorApellido = pnlModificarPersona.getLblValidatorApellido();
		JLabel validatorNombre = pnlModificarPersona.getLblValidatorNombre();
		JLabel validatorDNI = pnlModificarPersona.getLblValidatorDNI();
		
		Boolean estado = validarPersona(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI);
		if(estado) {
			String dniAnterior = pnlModificarPersona.getList().getSelectedValue().getDni();
        	if (pNeg.update(persona, dniAnterior)) {
	        	lblSucceed.setVisible(true);
	            txtDNI.setText("");
	            txtApellido.setText("");
	            txtNombre.setText("");
        	}
        	else {
             	JOptionPane.showMessageDialog(null, "ERROR - DNI REPETIDO.");
             	txtDNI.setText("");
             	txtApellido.setText("");
             	txtNombre.setText("");
            }
        }
		this.refrescarLista();
	}
	
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);;
	}
	
	private void refrescarLista()
	{
		listModel.clear();
		personasEnTabla = pNeg.readAll();
		for (Persona persona : personasEnTabla) {
			listModel.addElement(persona);
		}
		pnlModificarPersona.setDefaultListModel(listModel);
	}
}


/*this.pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyListener() {        
@Override
public void keyPressed(KeyEvent arg0) {
	pnlAgregarPersonas.getTxtNombre().setBackground(Color.WHITE);
	pnlAgregarPersonas.getValidatorNombre().setVisible(false);
	pnlAgregarPersonas.getLblSucceed().setVisible(false);
}
@Override
public void keyReleased(KeyEvent arg0) {
	if(pnlAgregarPersonas.getTxtNombre().getText().isEmpty()) {
		pnlAgregarPersonas.getTxtNombre().setBackground(Color.red);
		pnlAgregarPersonas.getValidatorNombre().setVisible(true);
		pnlAgregarPersonas.getTxtNombre().setText("");
    }
}
@Override
public void keyTyped(KeyEvent arg0) {
	if(esNumero(pnlAgregarPersonas.getTxtNombre().getText())) {
    	pnlAgregarPersonas.getValidatorNombre().setText("El nombre solo debe contener letras.");
    	pnlAgregarPersonas.getValidatorNombre().setVisible(true);
    	bandera++;
    }
	else pnlAgregarPersonas.getValidatorNombre().setText("");
}
});*/