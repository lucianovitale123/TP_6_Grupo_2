package negocioImpl;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class NegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean validarDNIRepetido(Persona persona) {
		ArrayList<Persona> listaPersonas;
		listaPersonas = pdao.readAll();
		for (Persona per : listaPersonas ) {
			if(per.getDni().equals(persona.getDni())) {
				return true;
			}
		}
		return false;	
	}
	
	@Override
	public boolean insert(Persona persona) {
        
        boolean estado=false, repetido;
        
        repetido = validarDNIRepetido(persona);
        if(repetido) return false;
            
        estado = pdao.insert(persona);
        return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		if(persona_a_eliminar.getDni().length() > 0)//LOGICA
		{
			// Verifica que exista el DNI
			ArrayList<Persona> listaPersonas = pdao.readAll();
		    for (Persona persona : listaPersonas) {
		        if (persona.getDni().equalsIgnoreCase(persona_a_eliminar.getDni())) {
		       
		        	estado=pdao.delete(persona_a_eliminar);
		}}}
		return estado;
	}

	@Override
	public ArrayList<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean update(Persona persona, String dniAnterior) {
		
		boolean estado=false, repetido;
        repetido = validarDNIRepetido(persona);
        if(repetido) return false;
        estado = pdao.update(persona, dniAnterior);
        return estado;
	}
	@Override
	public Boolean esNumero(String campo) {
		if(campo.matches("[0-9]+")) {
			return true;
		}
		else return false;
	}
	
	@Override
	public Boolean validarTextFields2 (JTextField nombre,JTextField apellido,JTextField dni) {
		if(nombre.getText().isEmpty() || apellido.getText().isEmpty() || dni.getText().isEmpty()) {
            
            nombre.setText("");
            apellido.setText("");
            dni.setText("");
            return false;
        }
		else if(esNumero(dni.getText())&& !esNumero(apellido.getText())&&!esNumero(nombre.getText())) {
            return true;
        }else {return false;}
	}
	
	@Override
	public Boolean validarPersona (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI) {
		
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
		
		if (validarTextFields2(txtApellido, txtNombre, txtDNI)) {
			return true;
		}else{return false;}

	}
	
	@Override
	public Boolean validarPersonaModificar (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI,JLabel lbl) {
		
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
		
		if (validarTextFields2(txtApellido, txtNombre, txtDNI)) {
			return true;
		}else{
			lbl.setVisible(false);
			return false;
			}
	}
}
