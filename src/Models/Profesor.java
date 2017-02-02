package Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	
	@OneToMany(mappedBy="Profesor",fetch=FetchType.EAGER)
	private List<Asignatura> Asignaturas;
	
	@ManyToMany
    @JoinTable(
      name="Enseña",
      joinColumns=@JoinColumn(name="Profesor", referencedColumnName="NIF"),
      inverseJoinColumns=@JoinColumn(name="Alumno", referencedColumnName="NIF"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Alumno> Alumnos;

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

	public List<Asignatura> getAsignaturas() {
		return Asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		Asignaturas = asignaturas;
	}

	public List<Alumno> getAlumnos() {
		return Alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		Alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Profesor [NIF=" + NIF + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + "]";
	}

}
