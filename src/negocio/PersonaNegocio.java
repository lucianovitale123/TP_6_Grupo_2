package negocio;

import java.util.ArrayList;

import entidad.Persona;

public interface PersonaNegocio {
	
	public boolean insert (Persona persona);
	public boolean delete (Persona persona);
	public ArrayList<Persona> readAll();
	boolean validarDNIRepetido(Persona persona);
	public boolean update (Persona persona, String dniAnterior);
<<<<<<< HEAD
	//public Boolean validarPersona (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI);
	public Boolean esNumero(String campo);
	//public Boolean validarPersonaModificar (JTextField txtApellido, JTextField txtNombre, JTextField txtDNI, JLabel validatorApellido, JLabel validatorNombre, JLabel validatorDNI,JLabel lbl);
=======
>>>>>>> origin/main
	
}
