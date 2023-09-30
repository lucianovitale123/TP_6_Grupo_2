package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.NegocioImpl;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.VentanaPrincipal;

public class Controlador {
	
	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio negocioImpl;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private DefaultListModel<Persona> listModel;
	
	public Controlador(VentanaPrincipal vista, DefaultListModel<Persona> listModel1, PersonaNegocio negocio) {
		//Guardo todas las instancias que recibo en el constructor
		this.ventanaPrincipal = vista;
		this.listModel = listModel1;
		this.negocioImpl = negocio;
				
		//Instancio los paneles
		this.pnlAgregarPersonas = new PanelAgregarPersonas(listModel);
		
		//Enlazo todos los eventos
		//Eventos del menu VentanaPrincipal
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a, listModel));
		
		//Eventos PnlAgregarPersonas
		this.pnlAgregarPersonas.getBtnAceptar().addActionListener(b->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(b));
		this.pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyListener() {		

			@Override
			public void keyPressed(KeyEvent arg0) {
				
				pnlAgregarPersonas.getTxtNombre().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorNombre().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
			
				
			}


		});
		
		this.pnlAgregarPersonas.getTxtApellido().addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent arg0) {
			pnlAgregarPersonas.getTxtApellido().setBackground(Color.WHITE);
			pnlAgregarPersonas.getValidatorApellido().setVisible(false);
			pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		this.pnlAgregarPersonas.getTxtDNI().addKeyListener(new KeyListener() {
			
			public void keyPressed(KeyEvent arg0) {
				pnlAgregarPersonas.getTxtDNI().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorDNI().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}

			@Override
			public void keyReleased(KeyEvent e) {
			
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}
		});
		
	}
	
	public void  EventoClickMenu_AbrirPanel_AgregarPersona(ActionEvent a, DefaultListModel<Persona> listModel) {
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlAgregarPersonas);
		pnlAgregarPersonas.setDefaultListModel(listModel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();		
	}
	
	public void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		JTextField txtNombre = this.pnlAgregarPersonas.getTxtNombre();
		JLabel validatorNombre = this.pnlAgregarPersonas.getValidatorNombre();
		JTextField txtApellido = this.pnlAgregarPersonas.getTxtApellido();
		JLabel validatorApellido = this.pnlAgregarPersonas.getValidatorApellido();
		JTextField txtDNI = this.pnlAgregarPersonas.getTxtDNI();
		JLabel validatorDNI = this.pnlAgregarPersonas.getValidatorDNI();
		JLabel lblSucceed = this.pnlAgregarPersonas.getLblSucceed();
		
		int bandera = 0;
		boolean estado = false;
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
        
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
        
        if(esNumero(txtNombre.getText())) {
        	validatorNombre.setText("El nombre solo debe contener letras.");
        	validatorNombre.setVisible(true);
        	bandera++;
        }
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
        
        if(bandera == 0) {
        	Persona persona = new Persona(txtDNI.getText(),txtNombre.getText(),txtApellido.getText());
        	estado = negocioImpl.insert(persona);
        	if(estado) {
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
	
	public static Boolean esNumero(String campo) {
		if(campo.matches("[0-9]+")) {
			return true;
		}
		else return false;
	}
	
	public void inicializar() {
		this.ventanaPrincipal.setVisible(true);;
	}
}