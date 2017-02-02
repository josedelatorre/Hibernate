package Main;

import DAO.*;
import Models.*;

public class Main {
	public static void main(String args[]) {
		AsignaturaDAO dao = new AsignaturaDAO();
		AlumnoDAO alumnoDAO = new AlumnoDAO();		
		
		for(Profesor p : alumnoDAO.get("26266549C").getProfesores())
			System.out.println(p);
		
		
		
	}
}
