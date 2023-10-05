package presentacion.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		this.pnlAgregarPersonas.getTxtNombre().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	EventoTecla(pnlAgregarPersonas.getTxtNombre(), pnlAgregarPersonas.getValidatorNombre(), "Solo debe contener letras");
		    }
		});
		this.pnlAgregarPersonas.getTxtDNI().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	EventoTeclaDNI(pnlAgregarPersonas.getTxtDNI(), pnlAgregarPersonas.getValidatorDNI(), "Solo debe contener numeros");
		    }
		});
		
		this.pnlAgregarPersonas.getTxtApellido().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	EventoTecla(pnlAgregarPersonas.getTxtApellido(), pnlAgregarPersonas.getValidatorApellido(), "Solo debe contener letras");
		    }
		});
		
		//Eventos PnlModificarPersonas
		this.pnlModificarPersona.getBtnModificar().addActionListener(a->EventoClickBoton_ModificarPersona_PanelModificarPersona(a));
		this.pnlModificarPersona.getList().addListSelectionListener(a->EventoSeleccion_PanelModificarPersona(a));		
		this.pnlModificarPersona.getTxtNombre().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	EventoTecla(pnlModificarPersona.getTxtNombre(), pnlModificarPersona.getLblValidatorNombre(), "Solo debe contener letras");
		    }
		});
		pnlModificarPersona.getTxtApellido().addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		    	EventoTecla(pnlModificarPersona.getTxtApellido(), pnlModificarPersona.getLblValidatorApellido(), "Solo debe contener letras");
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
		Persona persona = new Persona(txtDNI.getText(),txtNombre.getText(),txtApellido.getText());
		
		//Boolean estado = pNeg.validarPersona(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI);
		//if(estado) {
        	if (pNeg.insert(persona)) {
	        	lblSucceed.setVisible(true);
	            txtDNI.setText("");
	            txtApellido.setText("");
	            txtNombre.setText("");
        	}
        	else {
             	JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");
             	lblSucceed.setVisible(false);
             	txtDNI.setText("");
             	txtApellido.setText("");
             	txtNombre.setText("");
            }
        }//else {JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");}
    //}
	
	public void EventoSeleccion_PanelModificarPersona(ListSelectionEvent a){
		if (pnlModificarPersona.getList().getSelectedIndex() != -1) {
			Persona persona = pnlModificarPersona.getList().getSelectedValue();
			pnlModificarPersona.getTxtApellido().setText(persona.getApellido());
			pnlModificarPersona.getTxtNombre().setText(persona.getNombre());
			pnlModificarPersona.getTxtDNI().setText(persona.getDni());   
			pnlModificarPersona.getTxtApellido().setBackground(Color.WHITE);
			pnlModificarPersona.getTxtNombre().setBackground(Color.WHITE);
        }
	}
	
	
	//MODIFICAR PERSONA
	public void EventoClickBoton_ModificarPersona_PanelModificarPersona(ActionEvent a) {
		JTextField txtApellido = pnlModificarPersona.getTxtApellido();
		JTextField txtNombre = pnlModificarPersona.getTxtNombre();
		JTextField txtDNI = pnlModificarPersona.getTxtDNI();
		JLabel lblSucceed = pnlModificarPersona.getLblSucceed();
		Persona persona = new Persona(txtDNI.getText(),txtNombre.getText(),txtApellido.getText());
		
		//Boolean estado = pNeg.validarPersonaModificar(txtApellido, txtNombre, txtDNI, validatorApellido, validatorNombre, validatorDNI,lblSucceed);
		//if(estado) {
			if(pnlModificarPersona.getList().getSelectedIndex() != -1) {
				String dniAnterior = pnlModificarPersona.getList().getSelectedValue().getDni();
	        	if (pNeg.update(persona, dniAnterior)) {
		        	lblSucceed.setVisible(true);
		            txtDNI.setText("");
		            txtApellido.setText("");
		            txtNombre.setText("");
	        	}
	        	else {
	             	JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");
	             	lblSucceed.setVisible(false);
	             	txtDNI.setText("");
	             	txtApellido.setText("");
	             	txtNombre.setText("");
	            }
		    }
			else {
             	JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UN ELEMENTO.");
			}
			this.refrescarLista();
		}/*else {
			JOptionPane.showMessageDialog(null, "ES NECESARIO COMPLETAR TODOS LOS CAMPOS.");
			lblSucceed.setVisible(false);	
		}
	}*/
	
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
	
<<<<<<< HEAD
	private void EventoTecla(JTextField txt, JLabel validator, String mensaje) {
		if(txt.getText().isEmpty()) {
			txt.setBackground(Color.red);
			validator.setVisible(true);
			txt.setText("");
		}
		else {
			txt.setBackground(Color.WHITE);
			validator.setVisible(false);
		}
		if(pNeg.esNumero(txt.getText())) {
		    	validator.setText(mensaje);
		    	validator.setVisible(true);
		}
		else validator.setText("");
	}
	
	private void EventoTeclaDNI (JTextField txt, JLabel validator, String mensaje) {
		if(txt.getText().isEmpty()) {
			txt.setBackground(Color.red);
			validator.setVisible(true);
			txt.setText("");
		}
		else {
			txt.setBackground(Color.WHITE);
			validator.setVisible(false);
		}
		if(!pNeg.esNumero(txt.getText()) && !txt.getText().isEmpty()) {
		    	validator.setText(mensaje);
		    	validator.setVisible(true);
		}
		else validator.setText("");
	}
}
=======
	
	//Eliminar PERSONA
		public void EventoClickBoton_EliminarPersona_PanelEliminarPersonas(ActionEvent a) {
			
			JLabel lblSucceed = pnlEliminarPersonas.getLblSucceed();
					
			
		
}
		}


>>>>>>> origin/main
