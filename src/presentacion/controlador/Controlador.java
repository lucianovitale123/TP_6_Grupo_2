package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersona;
import presentacion.vista.VentanaPrincipal;

public class Controlador {
	
	private VentanaPrincipal ventanaPrincipal;
	private PanelAgregarPersonas pnlAgregarPersonas;
	private PanelModificarPersona pnlModificarPersona;
	private PanelEliminarPersonas pnlEliminarPersonas;
	private PanelListarPersonas pnlListarPersonas;
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
		this.pnlEliminarPersonas = new PanelEliminarPersonas(listModel);
		this.pnlListarPersonas = new PanelListarPersonas();
		
		//Eventos VentanaPrincipal
		this.ventanaPrincipal.getMntmAgregar().addActionListener(a->EventoClickMenu_AbrirPanel_AgregarPersona(a, listModel));
		this.ventanaPrincipal.getMntmModificar().addActionListener(a->EventoClickMenu_AbrirPanel_ModificarPersona(a, listModel));
		this.ventanaPrincipal.getMntmEliminar().addActionListener(a->EventoClickMenu_AbrirPanel_EliminarPersonas(a, listModel));
		this.ventanaPrincipal.getMntmListar().addActionListener(a->EventoClickMenu_AbrirPanel_ListarPersona(a));
		
		//Eventos PnlAgregarPersonas
		this.pnlAgregarPersonas.getBtnAceptar().addActionListener(b->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(b, listModel));
		
		//Eventos PnlModificarPersonas
		this.pnlModificarPersona.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPersona_PanelModificarPersona(a));
		
		this.pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyListener() {        
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
				if(pNeg.esNumero(pnlAgregarPersonas.getTxtNombre().getText())) {
			    	pnlAgregarPersonas.getValidatorNombre().setText("El nombre solo debe contener letras.");
			    	pnlAgregarPersonas.getValidatorNombre().setVisible(true);
			    }
				else pnlAgregarPersonas.getValidatorNombre().setText("");
			}
			});
		this.pnlAgregarPersonas.getTxtDNI().addKeyListener(new KeyListener() {        
			@Override
			public void keyPressed(KeyEvent arg0) {
				pnlAgregarPersonas.getTxtDNI().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorDNI().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(pnlAgregarPersonas.getTxtDNI().getText().isEmpty()) {
					pnlAgregarPersonas.getTxtDNI().setBackground(Color.red);
					pnlAgregarPersonas.getValidatorDNI().setVisible(true);
					pnlAgregarPersonas.getTxtDNI().setText("");
			    }
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(!pNeg.esNumero(pnlAgregarPersonas.getTxtDNI().getText())) {
			    	pnlAgregarPersonas.getValidatorDNI().setText("El DNI solo debe contener numeros.");
			    	pnlAgregarPersonas.getValidatorDNI().setVisible(true);
			    }
				else pnlAgregarPersonas.getValidatorDNI().setText("");
			}
			});
		
		this.pnlAgregarPersonas.getTxtApellido().addKeyListener(new KeyListener() {        
			@Override
			public void keyPressed(KeyEvent arg0) {
				pnlAgregarPersonas.getTxtApellido().setBackground(Color.WHITE);
				pnlAgregarPersonas.getValidatorApellido().setVisible(false);
				pnlAgregarPersonas.getLblSucceed().setVisible(false);
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(pnlAgregarPersonas.getTxtApellido().getText().isEmpty()) {
					pnlAgregarPersonas.getTxtApellido().setBackground(Color.red);
					pnlAgregarPersonas.getValidatorApellido().setVisible(true);
					pnlAgregarPersonas.getTxtApellido().setText("");
			    }
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(pNeg.esNumero(pnlAgregarPersonas.getTxtApellido().getText())) {
			    	pnlAgregarPersonas.getValidatorApellido().setText("El Apellido solo debe contener letras.");
			    	pnlAgregarPersonas.getValidatorApellido().setVisible(true);
			    }
				else pnlAgregarPersonas.getValidatorApellido().setText("");
			}
			});
		
		
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
	
	public void  EventoClickMenu_AbrirPanel_EliminarPersonas(ActionEvent a, DefaultListModel<Persona> listModel) {
		
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlEliminarPersonas);
		pnlEliminarPersonas.setDefaultListModel(listModel);
		ventanaPrincipal.getContentPane().repaint();
		ventanaPrincipal.getContentPane().revalidate();		
	}
	
	public void  EventoClickMenu_AbrirPanel_ListarPersona(ActionEvent a) {
		this.refrescarTabla();
		ventanaPrincipal.getContentPane().removeAll();
		ventanaPrincipal.getContentPane().add(pnlListarPersonas);
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
		
		Boolean estado = pNeg.validarPersona(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI);
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
        }else {JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");}
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
		
		Boolean estado = pNeg.validarPersonaModificar(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI,lblSucceed);
		if(estado) {
			if(pnlModificarPersona.getList().getSelectedIndex() != -1) {
				String dniAnterior = pnlModificarPersona.getList().getSelectedValue().getDni();
	        	if (pNeg.update(persona, dniAnterior)) {
		        	lblSucceed.setVisible(true);
		            txtDNI.setText("");
		            txtApellido.setText("");
		            txtNombre.setText("");
	        	}
	        	else {
	             	JOptionPane.showMessageDialog(null, "ERROR - DNI REPETIDO.");
	             	lblSucceed.setVisible(false);
	             	txtDNI.setText("");
	             	txtApellido.setText("");
	             	txtNombre.setText("");
	            }
		    }
			this.refrescarLista();
		}else {JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");}
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
	
	private void refrescarTabla()
	{
		this.personasEnTabla = (ArrayList<Persona>) pNeg.readAll();
		this.pnlListarPersonas.llenarTabla(this.personasEnTabla);
	}
	
	
	//Eliminar PERSONA
		public void EventoClickBoton_EliminarPersona_PanelEliminarPersonas(ActionEvent a) {
			
			JLabel lblSucceed = pnlEliminarPersonas.getLblSucceed();
					
			
		
}
		}


