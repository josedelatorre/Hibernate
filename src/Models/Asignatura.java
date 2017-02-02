package Models;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Asignatura")
public class Asignatura {

	@Id
	@Column
	private int Cod_Asig;
	@Column
	private String Nombre;
	@Column
	private String Curso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Profesor")
	private Profesor Profesor;
	
	@ManyToMany
    @JoinTable(
      name="Matricula",
      joinColumns=@JoinColumn(name="Cod_Asig", referencedColumnName="Cod_Asig"),
      inverseJoinColumns=@JoinColumn(name="Alumno", referencedColumnName="NIF"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Alumno> Alumnos;

	public Asignatura() {
	}

	public Asignatura(int cod_Asig, String nombre, String curso, Profesor profesor) {
		super();
		Cod_Asig = cod_Asig;
		Nombre = nombre;
		Curso = curso;
		Profesor = profesor;
	}

	public int getCod_Asig() {
		return Cod_Asig;
	}

	public void setCod_Asig(int cod_Asig) {
		Cod_Asig = cod_Asig;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public Profesor getProfesor() {
		return Profesor;
	}

	public void setProfesor(Profesor profesor) {
		Profesor = profesor;
	}

	public List<Alumno> getAlumnos() {
		return Alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		Alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Asignatura [Nombre=" + Nombre + ", Curso=" + Curso + "]";
	}

}
