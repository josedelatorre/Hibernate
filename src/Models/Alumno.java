package Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

@Component
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
	
	@ManyToMany
    @JoinTable(
      name="Matricula",
      joinColumns=@JoinColumn(name="Alumno", referencedColumnName="NIF"),
      inverseJoinColumns=@JoinColumn(name="Cod_Asig", referencedColumnName="Cod_Asig"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Asignatura> Asignaturas;
	
	@ManyToMany
    @JoinTable(
      name="Enseña",
      joinColumns=@JoinColumn(name="Alumno", referencedColumnName="NIF"),
      inverseJoinColumns=@JoinColumn(name="Profesor", referencedColumnName="NIF"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Profesor> Profesores;
	
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

	public List<Asignatura> getAsignaturas() {
		return Asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		Asignaturas = asignaturas;
	}

	public List<Profesor> getProfesores() {
		return Profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		Profesores = profesores;
	}

	@Override
	public String toString() {
		return "Alumno [NIF=" + NIF + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + "]";
	}
	
}
