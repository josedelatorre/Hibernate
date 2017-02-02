package Models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "Alumno")
public class Alumno implements Serializable {

	@Id
	@Column(name = "NIF")
	private String NIF;

	@Column(name = "Nombre")
	private String Nombre;

	@Column(name = "Apellidos")
	private String Apellidos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Cod_Aula")
	private Aula Aula;
	
	public Alumno(){
		
	}

	public Alumno(String nIF, String nombre, String apellidos, Aula aula) {
		super();
		NIF = nIF;
		Nombre = nombre;
		Apellidos = apellidos;
		Aula = aula;
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

	public Aula getAula() {
		return Aula;
	}

	public void setAula(Aula aula) {
		Aula = aula;
	}

	@Override
	public String toString() {
		return "Alumno [NIF=" + NIF + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + "]";
	}
	
}
