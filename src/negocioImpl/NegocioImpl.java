package negocioImpl;

import java.util.ArrayList;
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
        if(repetido) {
        	JOptionPane.showMessageDialog(null, "ERROR - DNI REPETIDO.");
        	return false;
        }
            
        if(!persona.getNombre().isEmpty() && !persona.getApellido().isEmpty() && !persona.getDni().isEmpty()) {
        	if(esNumero(persona.getDni()) && !esNumero(persona.getApellido())&&!esNumero(persona.getNombre())) {
        	estado = pdao.insert(persona);
        	}
		}
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
		boolean estado = false;
        if(!persona.getNombre().isEmpty() && !persona.getApellido().isEmpty() && !persona.getDni().isEmpty()) {
        	if(esNumero(persona.getDni()) && !esNumero(persona.getApellido())&&!esNumero(persona.getNombre())) {
        		estado = pdao.update(persona, dniAnterior);
        	}
		}
        return estado;
	}
<<<<<<< HEAD
	
	public Boolean esNumero(String campo) {
		if(campo.matches("[0-9]+")) {
			return true;
		}
		else return false;
	}
	
	/*public Boolean validarPersona (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI) {
		
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
		
		if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtDNI.getText().isEmpty()) {
            txtNombre.setText("");
            txtApellido.setText("");
            txtDNI.setText("");
            return false;
        }
		else if(esNumero(txtDNI.getText())&& !esNumero(txtApellido.getText())&&!esNumero(txtNombre.getText())) {
            return true;
        }else {return false;}
	}
	
	public Boolean validarPersonaModificar (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI,JLabel lbl) {
		
		validatorApellido.setText("*");
		validatorDNI.setText("*");
		validatorNombre.setText("*");
		
		if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()) {
            txtNombre.setText("");
            txtApellido.setText("");
            txtDNI.setText("");
            return false;
        }
		else if(!esNumero(txtApellido.getText())&&!esNumero(txtNombre.getText())) {
            return true;
        }else {return false;}
	}*/
=======
>>>>>>> origin/main
}
