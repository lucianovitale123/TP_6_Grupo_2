package dao;

import java.awt.List;
import java.util.ArrayList;

import entidad.Persona;

public interface PersonaDao {

	public boolean insert (Persona persona);
	public boolean delete (Persona persona);
	public ArrayList<Persona> readAll();
	
}
