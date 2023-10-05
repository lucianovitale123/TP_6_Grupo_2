package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import entidad.Persona;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEliminarPersonas extends JPanel {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Persona> listModel;
	private JList<Persona> list;
	private JButton btnEliminar;
	private JLabel lblSeleccion;
	private JLabel lblSucceed;

	public PanelEliminarPersonas(DefaultListModel<Persona> listModel) {
		this.listModel = listModel;
		
		setLayout(null);
		setSize(716, 267); 
		
		list = new JList<>(listModel);
		list.setBounds(53, 36, 612, 156);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().setView(list);
		scrollPane.setBounds(196, 36, 256, 156);
		add(scrollPane);
		//add(list);
		
		lblSeleccion = new JLabel("Seleccione la persona que desea eliminar");
		lblSeleccion.setBounds(229, 11, 204, 14);
		add(lblSeleccion);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEliminar.setBounds(258, 208, 138, 23);
		add(btnEliminar);
		
		lblSucceed = new JLabel("Persona eliminada con éxito.");
		lblSucceed.setForeground(Color.GREEN);
		lblSucceed.setBounds(258, 242, 154, 14);
		lblSucceed.setVisible(false);
		add(lblSucceed);
	
	

	
}
	

	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}
	
	public JButton getBtnModificar() {
		return btnEliminar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnEliminar = btnModificar;
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


}
