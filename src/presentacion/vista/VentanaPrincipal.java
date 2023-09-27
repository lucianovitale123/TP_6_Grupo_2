package presentacion.vista;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import entidad.Persona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{
	
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal(DefaultListModel<Persona> listModel) {
		setTitle("Programa");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setSize(800,400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Persona");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAgregar = new JMenuItem("Agregar");
		mntmAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				PanelAgregarPersonas panelAgregar= new PanelAgregarPersonas();
				panelAgregar.setDefaultListModel(listModel);
				contentPane.add(panelAgregar);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mntmAgregar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmAgregar);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmModificar);
		
		JMenuItem mntmEliminar = new JMenuItem("Eliminar");
		mntmEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmEliminar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setHorizontalAlignment(SwingConstants.LEFT);
		mnNewMenu.add(mntmListar);
		

		
	}

	

}
