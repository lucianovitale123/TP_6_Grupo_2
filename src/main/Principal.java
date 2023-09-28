package main;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import entidad.Persona;
import presentacion.controlador.Controlador;
import presentacion.vista.VentanaPrincipal;

public class Principal {
	
	private static DefaultListModel<Persona> listModel;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					//INSTANCIO EL LISTMODEL
					listModel = new DefaultListModel<Persona>();
					VentanaPrincipal frame = new VentanaPrincipal(listModel);
					frame.setVisible(true);
					
					Controlador controlador = new Controlador(frame, listModel);
					controlador.inicializar();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}



































