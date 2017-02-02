package Models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Profesor")
public class Profesor implements Serializable {

	@Id
	@Column(name = "NIF")
	private String NIF;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Apellidos")
	private String Apellidos;

	public Profesor() {

	}

	public Profesor(String nIF, String nombre, String apellidos) {
		super();
		NIF = nIF;
		Nombre = nombre;
		Apellidos = apellidos;
	}

	public String getNIF() {
		return NIF;
	}

	public String getNombre() {
		return Nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setNIF(String nIF) {
		NIF = nIF;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

}
