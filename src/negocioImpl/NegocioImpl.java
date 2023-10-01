package negocioImpl;

import java.util.ArrayList;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class NegocioImpl implements PersonaNegocio{

	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		
		boolean estado=false, repetido;
		
		repetido = validarDNIRepetido(persona);
		if(repetido) return false;
			
		estado	= pdao.insert(persona);
		
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
	
	
	public boolean validarDNIRepetido(Persona persona) {
		
        ArrayList<Persona> listaPersonas;
		
		listaPersonas = pdao.readAll();
		
		for (Persona per : listaPersonas ) {
			if(per.getDni() == persona.getDni()) {
				return true;
			}
		}
		
		return false;
		
	}

}
