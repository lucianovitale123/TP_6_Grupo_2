package main;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.NegocioImpl;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {
	
	private static DefaultListModel<Persona> listModel;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					//INSTANCIO OBJETOS VISTA
					listModel = new DefaultListModel<Persona>();
					VentanaPrincipal vista = new VentanaPrincipal(listModel);
					vista.setVisible(true);
					
					//INSTANCIO OBJETO LOGICA
					PersonaNegocio negocio = new NegocioImpl();
					
					//CONTROLADOR PARA UNIR VISTA Y LOGICA
					Controlador controlador = new Controlador(vista, listModel);
					controlador.inicializar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



































