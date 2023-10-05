package daoImpl;

import dao.PersonaDao;
import entidad.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDaoImpl implements PersonaDao {
	
	private static final String insert = "INSERT INTO personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE dni = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";

	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(Persona persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1,persona_a_eliminar.getDni());
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public ArrayList<Persona> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException {
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Apellido");
		return new Persona(dni, nombre, tel);
	}

	@Override
	public boolean update(Persona persona, String dniAnterior) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdatetExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, dniAnterior);
			
			if(statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdatetExitoso = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return isUpdatetExitoso;
	}

}
