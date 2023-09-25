package negocio;

import java.awt.List;

import entidad.Persona;

public interface PersonaNegocio {

	public interface PersonaDao {

		public boolean insert (Persona persona);
		public boolean delete (Persona persona);
		public List readAll();
		
	}

}
