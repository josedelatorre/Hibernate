package Main;

import DAO.*;
import Models.*;

public class Main {
	public static void main(String args[]) {
		AulaDAO dao = new AulaDAO();
		
		Aula a = dao.get(1);
		for(Alumno al : a.getAlumnos())
			System.out.println(al);
		
	}
}
