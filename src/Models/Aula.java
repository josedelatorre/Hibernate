package Models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Aula")
public class Aula {

	@Id
	@Column
	private int Cod_Aula;
	
	@Column
	private String Nombre;
	
	@OneToMany(mappedBy="Aula",fetch=FetchType.EAGER)
	private List<Alumno> Alumnos;
	
	public Aula(){}
	
	public Aula(int codigo){
		Cod_Aula = codigo;
	}

	public int getCod_Aula() {
		return Cod_Aula;
	}

	public void setCod_Aula(int cod_Aula) {
		Cod_Aula = cod_Aula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return Alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		Alumnos = alumnos;
	}


}
